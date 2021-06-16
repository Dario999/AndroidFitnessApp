package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessapp.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;

    private EditText editTextUsername,editTextAge,editTextEmail,editTextPassword,editTextConfirmPassword;
    private ProgressBar progressBar;
    private TextView backToLogin,registerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        mAuth = FirebaseAuth.getInstance();

        backToLogin = (TextView) findViewById(R.id.back_to_login);
        backToLogin.setOnClickListener(this);

        registerUser = (Button) findViewById(R.id.button_register);
        registerUser.setOnClickListener(this);

        editTextUsername = (EditText) findViewById(R.id.edit_username);
        editTextAge = (EditText) findViewById(R.id.edit_age);
        editTextEmail = (EditText) findViewById(R.id.edit_email);
        editTextPassword = (EditText) findViewById(R.id.edit_password);
        editTextConfirmPassword = (EditText) findViewById(R.id.edit_confirm_password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_to_login:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.button_register:
                registerUser();
                break;
        }
    }

    private void registerUser(){
        String username = editTextUsername.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();


        if(username.isEmpty()){
            editTextUsername.setError("Username is required");
            editTextUsername.requestFocus();
            return;
        }
        if(age.isEmpty()){
            editTextAge.setError("Age is required");
            editTextAge.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Email not valid");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        if(password.length() < 6){
            editTextPassword.setError("Password should be 6 characters long minimum");
            editTextPassword.requestFocus();
            return;
        }
        if(confirmPassword.length() < 6){
            editTextConfirmPassword.setError("Password should be 6 characters long minimum");
            editTextConfirmPassword.requestFocus();
            return;
        }
        if(!password.equals(confirmPassword)){
            editTextPassword.setError("Confirm password does not match the password");
            editTextConfirmPassword.setError("Confirm password does not match the password");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(username,age,password);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if(task.isSuccessful()){
                                                            Toast.makeText(RegisterUser.this,"User has been registered successfully",Toast.LENGTH_LONG).show();
                                                        }else{
                                                            Toast.makeText(RegisterUser.this,"Failed to register",Toast.LENGTH_LONG).show();
                                                        }
                                                        progressBar.setVisibility(View.GONE);
                                                    }
                                                });
                        }else{
                            Toast.makeText(RegisterUser.this,"Failed to register",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}