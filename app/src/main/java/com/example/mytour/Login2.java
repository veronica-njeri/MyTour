package com.example.mytour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytour.Fragments.HomeFragment;
import com.google.firebase.auth.FirebaseAuth;

public class Login2 extends AppCompatActivity {
    EditText mFullName, mPassword;
    Button btn_login;
    TextView txv;
    FirebaseAuth fAuth;
    ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mFullName = findViewById(R.id.user_name);
        mPassword= findViewById(R.id.pass_word);
        fAuth=FirebaseAuth.getInstance();
        pbar = findViewById(R.id.progressBar1);
        btn_login = findViewById(R.id.btn_login);
        txv =findViewById(R.id.signText);
        txv.setOnClickListener(v -> startActivity(new Intent(Login2.this,Register.class)));

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mFullName.getText().toString().trim();
                String password = mPassword.getText().toString();

                if (TextUtils.isEmpty(email)){
                    mFullName.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required");
                    return;
                }
                pbar.setVisibility(View.VISIBLE);



                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(Login2.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), FinalPage.class));
                        finish();
                    }
                    else{
                        Toast.makeText(Login2.this, "Please Check your Credentials",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}