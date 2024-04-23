package edu.utsa.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class RegisterActivity extends ComponentActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        setupButtons();
    }
    private void setupButtons(){
        Button submit=(Button) findViewById(R.id.submit_register);
        submit.setOnClickListener(v -> {
            if(validateAccountInfo()){
                Toast.makeText(getBaseContext(),"all text have values", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getBaseContext(),"atleast one value is empty", Toast.LENGTH_SHORT).show();
            }
            //Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
          //  startActivity(intent);
        });
    }
    private boolean validateAccountInfo(){
        EditText usnameInput= (EditText) findViewById(R.id.Usname_input);
        EditText upassInput= (EditText) findViewById(R.id.Upass_input);
        EditText unameInput= (EditText) findViewById(R.id.UName_input);
        EditText uemailInput= (EditText) findViewById(R.id.Uemail_input);
        return !usnameInput.getText().toString().equals("") && !upassInput.getText().toString().equals("") && !unameInput.getText().toString().equals("") && !uemailInput.getText().toString().equals("");

    }
    private int createLogin(){
        EditText usnameInput= (EditText) findViewById(R.id.Usname_input);
        EditText upassInput= (EditText) findViewById(R.id.Upass_input);
        String username = usnameInput.getText().toString();
        String password = upassInput.getText().toString();
        File f = new file(getFilesDir().getAbsolutePath()+"/login.txt");
        int id;
        if(!f.exists()){
            id=1;
            try {
                OutputStreamWriter w = new OutputStreamWriter(openFileOutput("login.txt",MODE_PRIVATE));
            }
            catch (IOException e){}
        }
        openFileInput("");
        openFileOutput("",MODE_APPEND);


    }
}

