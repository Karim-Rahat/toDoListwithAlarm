package com.example.mytodoapplication;

//add database entities
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

@Database(entities = {MainData.class},version = 2,exportSchema = false)

public abstract class RoomDB extends RoomDatabase {


    private static RoomDB databse;
    

    private static String DATABASE_NAME="database";

    public  synchronized static RoomDB getInstance(Context context){
        if(databse==null){
            //when db is null
            //initialize dab
            databse= Room.databaseBuilder(context.getApplicationContext(),RoomDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }


        return databse;
    }


    public abstract MainDao mainDao();

}
