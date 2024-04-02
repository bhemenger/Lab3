package edu.utsa.lab3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends ComponentActivity {
    private Button login;
    private Button guest;
    Toast toast;






    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setupButtons();
    }
      public EditText i1;
      public EditText i2;
      public String inputUser;
      public String inputPass;
      public String testUser;                                          
      public String testPass;                                          


    void setupButtons(){
        login=(Button) findViewById(R.id.Login_Button);
        guest=(Button) findViewById(R.id.Guest_button);
       login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class );
                AssetManager f = getAssets();
                try {
                    Scanner scan = new Scanner(f.open("user_info"));
                    i1 = (EditText) findViewById(R.id.user_name);
                    i2 = (EditText) findViewById(R.id.user_pass);
                    inputUser = String.valueOf(i1.getText());
                    inputPass = String.valueOf(i2.getText());


                    while(scan.hasNextLine()) {
                                            //Toast.makeText(getBaseContext(), "fuck", Toast.LENGTH_SHORT).show();
                       String temp = scan.nextLine();
                       testUser = temp.substring(0, temp.indexOf(','));
                       testPass = temp.substring(temp.indexOf(',') + 1);
                       Toast.makeText(getBaseContext(), inputUser+" "+inputPass, Toast.LENGTH_SHORT).show();
                } }
                catch (FileNotFoundException e) {
                    //throw new RuntimeException(e);
                    login.setText("file no worky");
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if(testUser.equals(inputUser) && testPass.equals(inputPass)) {
                    startActivity(intent); }
                else {
                    Toast.makeText(getBaseContext(), "incorrect username or passowrd", Toast.LENGTH_SHORT).show();
                }
            }
        });
        guest.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class );
                
                startActivity(intent);
            }
        });
    }
}
