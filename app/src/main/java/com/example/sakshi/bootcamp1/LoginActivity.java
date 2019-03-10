package com.example.sakshi.bootcamp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText email, pass;
    Button login;
    TinyDB db;

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init(){
        email = findViewById(R.id.etLoginEmail);
        pass = findViewById(R.id.etLoginPassword);
        login = findViewById(R.id.etLoginbtn);

        db = new TinyDB(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.etLoginbtn){
            login();
        }
    }

    private void login() {
        String emailId = email.getText().toString().trim();
        String password = pass.getText().toString();

        if(db.getString("email").equals(emailId) && db.getString("password").equals(password)){
            Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);
            finish();
        }
    }
}