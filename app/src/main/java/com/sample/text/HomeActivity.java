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
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.setTitle(getUsuarioActual());

        Button button3 = findViewById(R.id.btnCerrarSessionHome);
        button3.setOnClickListener(view -> {
            CerrarSession();
            onBackPressed();
        });
    }

    public void CerrarSession(){
        FirebaseAuth.getInstance().signOut();
    }

    private String getUsuarioActual(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null){
            String name = user.getDisplayName();
            String uid = user.getUid();

        }

        return user.getEmail();
    }
}