package com.example.autogeneratecertificates;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button browse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        browse = (Button) findViewById(R.id.browseButton);
        browse.setOnClickListener(this);
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
                    String path_xlsx = data.getData().toString();
                    Intent i1 = new Intent(getApplicationContext(), TemplateActivity.class);
                    i1.putExtra("file path", path_xlsx);
                    browse.setText(R.string.browse);
                    startActivity(i1);
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        getPath();
    }
}