package com.example.lbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class bookadd extends AppCompatActivity {
Button addbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookadd);
        addbook=findViewById(R.id.bookadd);
        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Book added Succesfully",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(bookadd.this,mainpage.class);
                startActivity(intent);
            }
        });
    }
}