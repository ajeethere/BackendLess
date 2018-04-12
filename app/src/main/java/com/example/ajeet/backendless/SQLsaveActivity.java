package com.example.ajeet.backendless;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLsaveActivity extends AppCompatActivity {
EditText Name,Password;
Button login;
SQLiteDatabase SQLiteObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlsave);
        try {
            //open if exist and create if not
            SQLiteObj = openOrCreateDatabase("myDB", MODE_PRIVATE, null);
            //create table
            SQLiteObj.execSQL("CREATE TABLE IF NOT EXISTS UserTable(username VARCHAR,password VARCHAR,name VARCHAR);");
            //insert data in table
            SQLiteObj.execSQL("INSERT INTO UserTable VALUES('admin','admin123','ajeet gathala');");
            Name = (EditText) findViewById(R.id.txtUsr);
            Password = (EditText) findViewById(R.id.txtPwd);
            login = (Button) findViewById(R.id.btn);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //select data
                    Cursor resultSet=SQLiteObj.rawQuery("Select username,password from UserTable WHERE username = '"+Name.getText().toString()+"' AND password = '"+Password.getText().toString()+"'",null);
                    if (resultSet.getCount()>0){
                        Intent i=new Intent(SQLsaveActivity.this,SaveDataActivity.class);
                        startActivity(i);
                    }else{
                        Name.setText("");
                        Password.setText("");
                        Toast.makeText(getApplicationContext(),"wrong username and password",Toast.LENGTH_LONG).show();
                    }

                }
            });
        }catch (Exception ex){
            Toast.makeText(this,"databse error",Toast.LENGTH_LONG).show();
        }

    }
}
