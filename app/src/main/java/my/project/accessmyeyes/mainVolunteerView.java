package my.project.accessmyeyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class mainVolunteerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_volunteer_view);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        final LottieAnimationView btnAccion = (LottieAnimationView) findViewById(R.id.btnEnviarSolicitud);
        TextView lblAccion = (TextView) findViewById(R.id.lblEjecucion);

        ImageButton btnHome = (ImageButton) findViewById(R.id.btnRegresarFromClient);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        final boolean[] icono = {false};
        btnAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icono[0] = !icono[0];
                btnAccion.setAnimation(icono[0] ? R.raw.colgar : R.raw.enviar_solicitud);
                btnAccion.playAnimation();
                lblAccion.setText(icono[0] ? "Finalizar" : "Comenzar");
            }
        });


    }
}