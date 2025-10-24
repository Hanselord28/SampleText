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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.annotation.Nonnull;

public class RegistroActivity extends AppCompatActivity {

    private FirebaseAnalytics oFirebaseAnalytics;
    private FirebaseAuth oFirebaseAuth;
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

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
                crearRegistro();
            }
        });


    }

    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = oFirebaseAuth.getCurrentUser();
        if(currentUser != null){
            //reload();
        }
    }


    private void reload(){

    };


    private void crearRegistro() {
        EditText Correo1 = findViewById(R.id.txtCorreoReg);
        EditText Contra1 = findViewById(R.id.txtContraReg);
        oFirebaseAuth.createUserWithEmailAndPassword(String.valueOf(Correo1.getText()), String.valueOf(Contra1.getText()))
                .addOnCompleteListener(RegistroActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@Nonnull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG, "CreateUserWithEmail:succes");
                            FirebaseUser user = oFirebaseAuth.getCurrentUser();
                            //updateUI(user);
                            Toast.makeText(RegistroActivity.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                            onBackPressed();
                        }else{
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegistroActivity.this, "Fallo en la autenticacion", Toast.LENGTH_SHORT).show();
                            Toast.makeText(RegistroActivity.this, "Instroduzca correctamente sus datos", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                            Correo1.requestFocus();
                        }
                    }
                });

    }

    private void updateUI(FirebaseUser user) {

    }


}