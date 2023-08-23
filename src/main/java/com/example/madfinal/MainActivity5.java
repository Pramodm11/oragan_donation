package com.example.madfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    TextView name;
    Button view,delete;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        name = findViewById(R.id.name);
        view = findViewById(R.id.button67);
        delete = findViewById(R.id.button2);
        DB = new DBHelper(this);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity5.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("hospital:"+res.getString(1)+"\n");
                    buffer.append("blood group"+res.getString(2)+"\n");
                    buffer.append("organ :"+res.getString(3)+"\n");
                    buffer.append("dob:"+res.getString(4)+"\n");
                    buffer.append("contact :"+res.getString(5)+"\n");
                    buffer.append("address :"+res.getString(6)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity5.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(MainActivity5.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity5.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });
    }
}