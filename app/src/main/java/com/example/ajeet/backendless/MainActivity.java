package com.example.ajeet.backendless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn,Sbtn,mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.lbtn);
        Sbtn=(Button)findViewById(R.id.SaveBtn);
        mBtn=(Button)findViewById(R.id.SQLBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ListActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"list",Toast.LENGTH_LONG).show();
            }
        });
        Sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SaveDataActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Start saving data",Toast.LENGTH_LONG).show();
            }
        });
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SQLsaveActivity.class);
                startActivity(i);
            }
        });
    }
}
