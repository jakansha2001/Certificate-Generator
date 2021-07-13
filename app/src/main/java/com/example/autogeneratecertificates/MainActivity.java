package com.example.autogeneratecertificates;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button browse = findViewById( R.id.browse_button );
        // Button drive = findViewById( R.id.drive_button );

        browse.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );

        /*
        drive.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );*/
    }
}