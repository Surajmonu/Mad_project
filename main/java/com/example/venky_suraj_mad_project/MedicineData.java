package com.example.venky_suraj_mad_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class MedicineData extends SQLiteOpenHelper {
    public MedicineData(Context context) { // Press Control+o in the Option select 1stone.
        // after method is overridden you will list of parameter will be present insideparanthesis clear all that and inside parenthesis create reference of Context
        super(context, "MedDataBase", null, 1);
        // in the place of name pass the databsename enclose it within double quote and in the name of factory pass null and in the nameversion pass 1.
    }
    @Override // presss control+o and select onUpgrade
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    @Override // presss control+o and select onCreate
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table MedTab(MedName TEXT, MedDate TEXT, MedTime TEXT)");
    }
    public boolean insertValues(String name,String date,String time)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("MedName",name);
        contentValues.put("MedDate",date);
        contentValues.put("MedTime",time);
        long res=database.insert("MedTab",null,contentValues);
        if (res==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor FetchActivity(String date,String time)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from MedTab where MedDate='"+date+"' AND MedTime='"+time+"' ",null);
        return cursor;
    }
}
