package com.erdemserhat.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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
            SQLiteDatabase database = this.openOrCreateDatabase("Students",MODE_PRIVATE, null);
            //Creating a sheet/table and columns.
            database.execSQL("CREATE TABLE IF NOT EXISTS students (name VARCHAR, age INT)");
            //Inserting data
            database.execSQL("INSERT INTO students (name, age) VALUES ('Serhat',22)");
            //Reading Data
            Cursor cursor = database.rawQuery("SELECT * FROM students",null);

            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");

            while(cursor.moveToNext()){
                System.out.println("Name : " + cursor.getString(nameIx));
                System.out.println("Age : " + cursor.getInt(ageIx));

            }

            cursor.close();


        } catch (Exception e){
            e.printStackTrace();
        }

    }

}

