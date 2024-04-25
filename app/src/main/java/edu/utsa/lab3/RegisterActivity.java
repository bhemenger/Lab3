package edu.utsa.lab3;
//1:26:33
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class RegisterActivity extends ComponentActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        setupButtons();
    }
    private void setupButtons(){
        Button submit=(Button) findViewById(R.id.submit_register);
        submit.setOnClickListener(v -> {
            int id=-1;
            EditText usnameInput= (EditText) findViewById(R.id.Usname_input);
            EditText upassInput= (EditText) findViewById(R.id.Upass_input);
            EditText unameInput= (EditText) findViewById(R.id.UName_input);
            EditText uemailInput= (EditText) findViewById(R.id.Uemail_input);
            if(validateAccountInfo()){
                Toast.makeText(getBaseContext(),"all text have values", Toast.LENGTH_SHORT).show();
                id = createLogin();
                if(id>0);
                try {
                    createAccount(id);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
            else{
                usnameInput.setText("");
                upassInput.setText("");
                unameInput.setText("");
                upassInput.setText("");
                usnameInput.setError("All fields must be filled out");
                upassInput.setError("All fields must be filled out");
                unameInput.setError("All fields must be filled out");
                uemailInput.setError("All fields must be filled out");

            }

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
        File f = new File(getFilesDir().getAbsolutePath()+"/login.txt");
        Scanner scan;
        int id = -1;
        String str;
        String[] arr;
        if(!f.exists()){
            id=1;
            try {
                OutputStreamWriter w = new OutputStreamWriter(openFileOutput("login.txt",MODE_PRIVATE));
                w.write(id+","+username+","+password);
                w.close();
            }
            catch (IOException e){
                Toast.makeText(getBaseContext(),"IOException: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        else{
            try{
            scan = new Scanner(openFileInput("login.txt"));
            while(scan.hasNextLine()) {
                str = scan.nextLine();

                if(str!=null){
                    arr = str.split(",");
                    if(arr.length==3){
                        id=Integer.parseInt(arr[0]+1);
                    }
                }
                scan.close();

                OutputStreamWriter w = new OutputStreamWriter(openFileOutput("login.txt",MODE_APPEND));
                w.append("\n"+id+","+username+","+password);
                w.close();
            }
            }
            catch(IOException e){
                Toast.makeText(getBaseContext(),"IOException: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return id;
    }
    public void createAccount(int id) throws IOException {
        EditText uNameInput= (EditText) findViewById(R.id.UName_input);
        EditText uEmailInput= (EditText) findViewById(R.id.Uemail_input);
        String name = uNameInput.getText().toString();
        String email = uEmailInput.getText().toString();
        File f = new File(getFilesDir().getAbsolutePath()+"/accounts.txt");
        if(!f.exists()){
            try {
                OutputStreamWriter w = new OutputStreamWriter(openFileOutput("accounts.txt",MODE_PRIVATE));
                w.write(id+","+name+","+email);
                w.close();
            }
            catch (IOException e){
                Toast.makeText(getBaseContext(),"IOException: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        else{
            OutputStreamWriter w = new OutputStreamWriter(openFileOutput("account.txt",MODE_APPEND));
            w.append("\n"+id+","+name+","+email);
            w.close();
        }
    }

}

