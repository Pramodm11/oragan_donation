package com.example.madfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    Button b12;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b12 = findViewById(R.id.b12);
        b12.setText(GlobalVariable.message);
        DB = new DBHelper(this);
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity4.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("hospital :"+res.getString(1)+"\n");
                    buffer.append("blood group:"+res.getString(2)+"\n");
                    buffer.append("organ name:"+res.getString(3)+"\n");
                    buffer.append("dob"+res.getString(4)+"\n");
                    buffer.append("contact:"+res.getString(5)+"\n\n");buffer.append("address:"+res.getString(6)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity4.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }
}