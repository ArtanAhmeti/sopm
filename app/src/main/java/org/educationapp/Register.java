package org.educationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void register (View view) {
        EditText email;
        EditText password;
        email = (EditText)findViewById(R.id.editTextTextPersonEmail);
        password = (EditText)findViewById(R.id.editTextTextPersonPassword);
        Log.i("Register", email.getText().toString());
        mAuth = FirebaseAuth.getInstance();
//
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        // create new user or register new user
        try {
            mAuth
                    .createUserWithEmailAndPassword(userEmail, userPassword)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(),
                                        "Registration successful!",
                                        Toast.LENGTH_LONG)
                                        .show();

//                             hide the progress bar
//                            progressBar.setVisibility(View.GONE);

                                // if the user created intent to login activity
//                            Intent intent
//                                    = new Intent(RegistrationActivity.this,
//                                    MainActivity.class);
//                            startActivity(intent);
                            }
                            else {

                                // Registration failed
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Registration failed!!"
                                                + " Please try again later",
                                        Toast.LENGTH_LONG)
                                        .show();

                                // hide the progress bar
//                            progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
        } catch (Exception e) {
            Log.i("Register", e.toString());
        }


    }
}