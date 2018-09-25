package com.example.igugl.registerform;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button register;
    EditText firstNumber;
    EditText lastNumber;
    EditText email;
    EditText password;
    boolean validateBotton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firstNumber = (EditText)findViewById(R.id.firstName);
        lastNumber = (EditText)findViewById(R.id.lname);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        register = (Button)findViewById(R.id.reg);

        validateBotton = false;

        firstNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View b, boolean hasFocus){
                if(!hasFocus && firstNumber.getText().toString().length() <= 1){
                    firstNumber.setError("Слишком короткое имя");
                }else{
                    validateBotton = true;
                }
            }
        });

        lastNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View b, boolean hasFocus){
                if(!hasFocus && lastNumber.getText().toString().length() <= 1){
                    lastNumber.setError("Слишком короткая фамилия");
                }
            }
        });

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View b, boolean hasFocus){
                if(!hasFocus && !Validate.isValidEmail(email.getText().toString())){
                    email.setError("неверный адресс электронной почты");
                }
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View b, boolean hasFocus){
                if(!hasFocus && password.getText().toString().length() <= 3){
                    password.setError("Пароль должен содержать не менее 4 символов");
                }
            }
        });
        //lastNumber.addTextChangedListener();
        //email.addTextChangedListener();
        //password.addTextChangedListener();
        //register.addTextChangedListener();



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplication(), postPetition.class);
                i.putExtra("firstName", firstNumber.getText().toString());
                i.putExtra("lastName", lastNumber.getText().toString());
                i.putExtra("email", email.getText().toString());
                i.putExtra("password", password.getText().toString());
                startActivity(i);
            }

    });
    }
}

