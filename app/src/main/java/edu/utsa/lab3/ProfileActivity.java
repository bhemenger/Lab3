package edu.utsa.lab3;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ProfileActivity extends ComponentActivity {

    public Button button;
    private Account profileInfo = null;
    //private AssetManager assets;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        //assets = getAssets();
        setupProfile();
        setupButtons();
    }

    public void setupProfile(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",-1);
        File f =new File(getFilesDir().getAbsolutePath()+"/accounts.txt");

        Scanner scan;
        String str;
        String[] arr;

        try {
            if(f.exists()){
                scan = new Scanner(getFilesDir().getAbsolutePath()+"/accounts.txt");
                while(scan.hasNext()) {
                str = scan.nextLine();
                arr = str.split(",");
                if(Integer.parseInt(arr[0]) == id){
                    profileInfo = new Account(id,arr[1],arr[2]);
                    break;
                }
            }
            scan.close();
        }
        } catch (NumberFormatException e) {

            Toast.makeText(getBaseContext(),"RunTimeException: "+e.getMessage(), Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }
        if(profileInfo!=null) {

            TextView name = (TextView) findViewById(R.id.F_N_edit);
            TextView email = (TextView) findViewById(R.id.Email_edit);
            name.setText(profileInfo.getName());
            email.setText(profileInfo.getEmail());
        }
    }

    private void setupButtons() {
        button = findViewById(R.id.exit);

        button.setOnClickListener(v -> {
            finish();
        });
    }





}
