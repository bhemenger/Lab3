package edu.utsa.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;

public class MainActivity extends ComponentActivity {
    private Button login;
    private Button guest;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setupButtons();
    }
    void setupButtons(){
        login=(Button) findViewById(R.id.Login_Button);
        guest=(Button) findViewById(R.id.Guest_button);
       login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class );
                startActivity(intent);
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
