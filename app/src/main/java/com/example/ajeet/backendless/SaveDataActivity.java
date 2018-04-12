package com.example.ajeet.backendless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class SaveDataActivity extends AppCompatActivity {
Button SaveBtn,UpdateBtn;
EditText NameTxt,AddressTxt,EmailTxt,MobileTxt,NameTxt1,AddressTxt1,EmailTxt1,MobileTxt1;
static  profileTable ProfileTable,ProfileTable1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);
        Backendless.initApp(getApplicationContext(),"FDD05A44-FC23-7AEC-FF05-73BCF58A9900","6295D91A-65F2-420C-FF02-C9834F453200");
        SaveBtn=(Button)findViewById(R.id.btnSave);
        UpdateBtn=(Button)findViewById(R.id.btnUpdate);
        NameTxt=(EditText)findViewById(R.id.txtNam);
        AddressTxt=(EditText)findViewById(R.id.txtAdd);
        EmailTxt=(EditText)findViewById(R.id.txtEmail);
        MobileTxt=(EditText)findViewById(R.id.txtMobile);
        NameTxt1=(EditText)findViewById(R.id.txtNam1);
        AddressTxt1=(EditText)findViewById(R.id.txtAdd1);
        EmailTxt1=(EditText)findViewById(R.id.txtEmail1);
        MobileTxt1=(EditText)findViewById(R.id.txtMobile1);
        ProfileTable=new profileTable();
        ProfileTable1=new profileTable();
        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileTable.setName(NameTxt.getText().toString());
                ProfileTable.setAdd(AddressTxt.getText().toString());
                ProfileTable.setEmail(EmailTxt.getText().toString());
                ProfileTable.setMobileNo(MobileTxt.getText().toString());
                Toast.makeText(getApplicationContext(),"data saved",Toast.LENGTH_LONG).show();
                Backendless.Persistence.save(ProfileTable, new AsyncCallback<profileTable>() {
                    @Override
                    public void handleResponse(profileTable response) {
                        NameTxt1.setText(response.getName());
                        AddressTxt1.setText(response.getAdd());
                        EmailTxt1.setText(response.getEmail());
                        MobileTxt1.setText(response.getMobileNo());
                       ProfileTable1=response;
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                });
            }
        });
        UpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileTable1.setName(NameTxt1.getText().toString());
                ProfileTable1.setAdd(AddressTxt1.getText().toString());
                ProfileTable1.setEmail(EmailTxt1.getText().toString());
                ProfileTable1.setMobileNo(MobileTxt1.getText().toString());
                Backendless.Persistence.save(ProfileTable1, new AsyncCallback<profileTable>() {
                    @Override
                    public void handleResponse(profileTable response) {
                        Toast.makeText(getApplicationContext(),"updated",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                });;
            }
        });

    }
}
