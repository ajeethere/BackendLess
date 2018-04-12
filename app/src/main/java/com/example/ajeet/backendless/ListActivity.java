package com.example.ajeet.backendless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.widget.ListAdapter;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=(ListView)findViewById(R.id.LView);
        Backendless.initApp(getApplicationContext(),"FDD05A44-FC23-7AEC-FF05-73BCF58A9900","6295D91A-65F2-420C-FF02-C9834F453200");
        List<profileTable> profileList=new ArrayList<>();
        Backendless.Persistence.of(profileTable.class).find(new AsyncCallback<List<profileTable>>() {
            @Override
            public void handleResponse(List<profileTable> responce) {
                Log.e("Backendless Response..","no of object.."+responce);
                listView.setAdapter(new com.example.ajeet.backendless.ListAdapter(ListActivity.this,responce));
            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
    }
}
