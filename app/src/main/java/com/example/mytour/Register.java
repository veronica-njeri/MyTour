package com.example.mytour;

import androidx.annotation.NonNull;
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
import android.content.Intent;

import com.example.mytour.Fragments.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText mFullName,mEmail,mPassword,mPhone;
    Button mRegisterBtn;
    TextView mLoginButton;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.fullname);
        mEmail = findViewById(R.id.Email);
        mPassword= findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegisterBtn = findViewById(R.id.registerBtn);
        mLoginButton = findViewById(R.id.createText);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this,Login2.class);
                startActivity(i);
            }
        });

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), FinalPage.class));
            finish();
        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mFullName.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString();
                String phone = mPhone.getText().toString();


                if (TextUtils.isEmpty(email)){
                    mFullName.setError("Username is required");
                    return;
                }
                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(email)){
                    mPassword.setError("password is required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mPhone.setError("Phone is required");
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);

                //Register user to firebase
                createUser(name, email,password);
            }




        });
    }

    private void createUser(String name, String email, String password) {
        fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),FinalPage.class));
                    finish();
                }else {
                    Toast.makeText(Register.this, "Error !" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}