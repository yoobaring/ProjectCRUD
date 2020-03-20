package com.example.melayu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

    SQLiteHelper( Context context,
                  String name,
                  SQLiteDatabase.CursorFactory factory,
                  int  version) {
        super(context, name, factory, version);
    }
    public void  queryData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name, String age, String phone, byte[] image) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO RECORD VALUES(NULL, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, age);
        statement.bindString(3, phone);
        statement.bindString(4, String.valueOf(image));

        statement.executeInsert();

    }

    public void updateData(String name, String age, String phone, byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE RECORD SET name=?, age=?, phone=?, image=? WHERE id=?";

        SQLiteStatement statement = database.compileStatement(sql);


        statement.bindString(1, name);
        statement.bindString(2, age);
        statement.bindString(3, phone);
        statement.bindString(4, String.valueOf(image));
        statement.bindString(5, String.valueOf((double)id));

        statement.executeInsert();
        database.close();

    }

    public void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql ="DELETE FROM RECORD WHERE id=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, String.valueOf((double)id));

        statement.execute();
        database.close();

    }

    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
