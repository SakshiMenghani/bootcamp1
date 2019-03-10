package com.example.sakshi.bootcamp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName , etEmail , etpass , etcpass , etno ;
            private Button etbtn ;
            private String name,email,password,confirm_password,number;
            private TinyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new TinyDB(this);
        initView();
        etbtn.setOnClickListener(this);



    }

    private void initView() {
        etName =  findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etpass = findViewById(R.id.etpass);
        etcpass = findViewById(R.id.etcpass);
        etno = findViewById(R.id.etno);
        etbtn = findViewById(R.id.etbtn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.etbtn:
                getInfo();
                register();
                break;
        }
    }



    private void getInfo() {
        name= etName.getText().toString();
        email=etEmail.getText().toString();
        password=etpass.getText().toString();
        confirm_password=etcpass.getText().toString();
        number=etno.getText().toString();

    }
    private void register() {

        if(name.isEmpty()||email.isEmpty()||password.isEmpty()||confirm_password.isEmpty()||number.isEmpty())
            Toast.makeText(this, "one or more fields are empty", Toast.LENGTH_SHORT).show();
        else {
            if(password.equals(confirm_password)){
                db.putString("name",name);
                db.putString("email",email);
                db.putString("password",password);
                Intent i = new Intent (this,LoginActivity.class);
                startActivity(i);
                finish();

                Toast.makeText(this, "user is registered", Toast.LENGTH_SHORT).show();
            }

            else{
                Toast.makeText(this, "password does not match", Toast.LENGTH_SHORT).show();
            }



        }
    }


}
