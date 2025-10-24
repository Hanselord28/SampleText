package com.sample.text;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import javax.annotation.Nonnull;

public class LogActivity extends AppCompatActivity {

    private FirebaseAnalytics oFirebaseAnalytics;
    private FirebaseAuth oFirebaseAuth;
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        oFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString("mensaje", "Entro_al_Log");
        oFirebaseAnalytics.logEvent("pantalla_de_Log", bundle);
        this.setTitle("Inicio de Session");
        EditText txtC = findViewById(R.id.txtCorreoLog);
        EditText txtP = findViewById(R.id.txtContraLog);


        oFirebaseAuth = FirebaseAuth.getInstance();
        Button button1 = findViewById(R.id.btnIniciarSesionLog);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText correo = findViewById(R.id.txtCorreoLog);
                EditText contra = findViewById(R.id.txtContraLog);
                ingresar(String.valueOf(correo.getText()), String.valueOf(contra.getText()));

            }
        });


    }
    private void ingresar(String email, String password){
        oFirebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@Nonnull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG, "SignInWithEmail:success");
                            FirebaseUser user = oFirebaseAuth.getCurrentUser();
                            //updateUI(user);
                            Intent intent = new Intent(LogActivity.this, HomeActivity.class);

                        }else{
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LogActivity.this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
                            //updateUI(null);

                        }
                    }
                });
    }

    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = oFirebaseAuth.getCurrentUser();
        if (currentUser != null){
            reload();
        }
    }



    private void updateUI(FirebaseUser user) {

    }



    private void reload(){

    }


}