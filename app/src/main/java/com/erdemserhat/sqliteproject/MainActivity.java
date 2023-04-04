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
            //Creating a sheet/table and columns, auto incrementing id with  "INTEGER PRIMARY KEY"
            database.execSQL("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY,name VARCHAR, age INT)");
            //Inserting data
            //database.execSQL("INSERT INTO students (name, age) VALUES ('Serhat',22)");
            //database.execSQL("INSERT INTO students (name, age) VALUES ('Ali',31)");
            //database.execSQL("INSERT INTO students (name, age) VALUES ('Volkan',30)");

            //Reading Data, filtering data by using where keyword
            Cursor cursor = database.rawQuery("SELECT * FROM students where id=3",null);

            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIx = cursor.getColumnIndex("id");

            while(cursor.moveToNext()){
                System.out.println("Name : " + cursor.getString(nameIx));
                System.out.println("Age : " + cursor.getInt(ageIx));
                System.out.println("ID : " + cursor.getInt(idIx));

            }

            cursor.close();


        } catch (Exception e){
            e.printStackTrace();
        }

    }

}

