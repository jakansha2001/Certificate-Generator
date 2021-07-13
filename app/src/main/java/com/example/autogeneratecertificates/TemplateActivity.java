package com.example.autogeneratecertificates;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class TemplateActivity extends AppCompatActivity {

    TextView test;
    String path_xlsx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        test=(TextView)findViewById(R.id.test);
        Intent i2=getIntent();
        path_xlsx=i2.getStringExtra("file path");
        //Toast.makeText(this, path_xlsx, Toast.LENGTH_LONG).show();

        try {
            FileInputStream inputfile = new FileInputStream(new File(path_xlsx));

            XSSFWorkbook workbook = new XSSFWorkbook(inputfile);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator < Row > rowIterator = sheet.iterator();
            int count=0;
            while (rowIterator.hasNext()) {
                count++;
            }
            String[] Name=new String[count];
            String[] Course=new String[count];
            String[] College=new String[count];
            String[] Society=new String[count];
            String[] Position=new String[count];
            count=0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                Iterator < Cell > cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cellname = cellIterator.next();
                    Name[count]=cellname.toString();
                    Cell cellcourse = cellIterator.next();
                    Course[count]=cellcourse.toString();
                    Cell cellcollege = cellIterator.next();
                    College[count]=cellcollege.toString();
                    Cell cellsociety = cellIterator.next();
                    Society[count]=cellsociety.toString();
                    Cell cellposition = cellIterator.next();
                    Position[count]=cellposition.toString();
                    count++;
                    }
                }
            test.setText(College[3]);
            inputfile.close();
        }
        catch (FileNotFoundException e) {
            test.setText("FilenotFound");
            e.printStackTrace();
        } catch (IOException e) {
            test.setText("IOException");
            e.printStackTrace();
        }

    }
}