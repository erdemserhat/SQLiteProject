package com.erdemserhat.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Basics of SQLite

        try {
            //Operations which will be tried.
            //Creating Main Database
            SQLiteDatabase database = this.openOrCreateDatabase("MajorDataBaseName",MODE_PRIVATE, null);
            //Creating a sheet/table and columns.
            database.execSQL("CREATE TABLE IF NOT EXISTS tableName (column1 VARCHAR, colum2 INT)");


        } catch (Exception e){
            e.printStackTrace();
        }

    }

}