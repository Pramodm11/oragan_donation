package com.example.madfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.InputType;


public class LoginActivity1 extends AppCompatActivity {


    EditText username, password;
    Button btnlogin;
    DBHelper2 DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); // Set password input type
        btnlogin = (Button) findViewById(R.id.btnsignin1);
        DB = new DBHelper2(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity1.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    //Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(user.equals("Admin") && pass.equals("password@123")){
                        Toast.makeText(LoginActivity1.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        GlobalVariable.message=username.getText().toString();
                        Intent intent  = new Intent(getApplicationContext(), MainActivity5.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity1.this, "Invalid username or password", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}