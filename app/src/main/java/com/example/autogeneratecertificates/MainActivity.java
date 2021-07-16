package com.example.autogeneratecertificates;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
    Button browse;
    TextView pathText;
    String path_xlsx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        browse = (Button) findViewById(R.id.browseButton);
        pathText = (TextView) findViewById(R.id.pathText);
        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPath();
                browse.setText("GO TO TEMPLATES");
                browse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i1 = new Intent(getApplicationContext(), TemplateActivity.class);
                        i1.putExtra("file path", path_xlsx);
                        Log.i("path", path_xlsx);
                        startActivity(i1);
                    }
                });
            }
        });
    }

    protected void getPath() {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    path_xlsx = data.getData().toString();
                    Toast.makeText(this, path_xlsx, Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}