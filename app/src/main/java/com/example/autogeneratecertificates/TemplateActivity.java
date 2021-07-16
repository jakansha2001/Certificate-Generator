package com.example.autogeneratecertificates;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class TemplateActivity extends AppCompatActivity {

    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        test = (TextView) findViewById(R.id.test);
        showData();
    }

    public void showData() {
        new Thread(() -> {
            try {
                String path_xlsx = getIntent().getStringExtra("file path");
                InputStream inputfile = getContentResolver().openInputStream(Uri.parse(path_xlsx));

                XSSFWorkbook workbook = new XSSFWorkbook(inputfile);
                XSSFSheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                int count = 0;
                while (rowIterator.hasNext() && count < 10) {
                    count++;
                    Row row = rowIterator.next();
                    Iterator<Cell> c = row.cellIterator();
                    c.next();
                    test.post(() -> test.setText(c.next().getStringCellValue()));
                    Thread.sleep(1000);
                }
                inputfile.close();
            } catch (FileNotFoundException e) {
                test.setText("FilenotFound");
                e.printStackTrace();
            } catch (IOException e) {
                test.setText("IOException");
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}