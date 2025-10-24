package com.sample.text;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroActivity extends AppCompatActivity {

    private FirebaseAnalytics oFirebaseAnalytics;
    private FirebaseAuth oFirebaseAuth;
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        oFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("Mensaje", "Entro_al_Log");
        oFirebaseAnalytics.logEvent("pantalla_de_logeo", bundle);
        this.setTitle("Inicio de Sesión");

        //instancia de Firebase Auth
        oFirebaseAuth = FirebaseAuth.getInstance();
        Button btnRegistrarseReg = findViewById(R.id.btnRegistrarseReg);


        btnRegistrarseReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //crearRegistro();
            }
        });
    }



}