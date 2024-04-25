package edu.utsa.lab3;


import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends ComponentActivity {
    private Button login;
    private Button guest;
    private Button register;
    //AssetManager f;
    String[] arr;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setupButtons();
        //f=getAssets();
    }
      public EditText i1;
      public EditText i2;

    void setupButtons(){
        login=(Button) findViewById(R.id.Login_Button);
        guest=(Button) findViewById(R.id.Guest_button);
        register=(Button) findViewById(R.id.Signup_Button);
       login.setOnClickListener(v -> {


                    i1 = (EditText) findViewById(R.id.user_name);
                    i2 = (EditText) findViewById(R.id.user_pass);
                    int id = authenticate(i1.getText().toString(), i2.getText().toString());
           if (id != -1) {
               Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
               intent.putExtra("id", id);
               startActivity(intent);
           } else {
               i1.setText("");
               i2.setText("");
               i1.setError("Incorrect username and password combination.");
               i2.setError("Incorrect username and password combination.");
           }

    });

        guest.setOnClickListener(v -> {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    });
        register.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
}

    private int authenticate(String username, String password) {
        Scanner scan;
        String str;
        String[] arr=null;
        int id = -1;
        File f = new File(getFilesDir().getAbsolutePath()+"/login.txt");
        try {
            scan = new Scanner(openFileInput("login.txt"));
            while (scan.hasNextLine()) {
                str = scan.nextLine();
                arr = str.split(",");
                if (arr.length >= 3 && username.equalsIgnoreCase(arr[1]) && password.equals(arr[2])) {
                    id = Integer.parseInt(arr[0]);
                    break;
                }
            }
            scan.close();
        } catch (IOException e) {
            e.printStackTrace(); // Print exception details for debugging
        }

        return id;
    }
}
