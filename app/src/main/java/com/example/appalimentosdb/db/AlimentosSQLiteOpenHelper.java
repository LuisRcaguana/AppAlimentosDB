package com.example.appalimentosdb.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class AlimentosSQLiteOpenHelper  extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "AlimentosDB";
    static final int DATABASE_VERSION = 1;

    static  final String CREATE_TABLE_ALIMENTACION =
            "CREATE TABLE "+ AlimentosContract.AliemtosEntry.TABLE_NAME+ "( "+
                    AlimentosContract.AliemtosEntry.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                    AlimentosContract.AliemtosEntry.COLUMN_NAMEA+" TEXT NOT NULL," +
                    AlimentosContract.AliemtosEntry.COLUMN_TIPO+" TEXT NOT NULL," +
                    AlimentosContract.AliemtosEntry.COLUMN_ORIGEN+" TEXT NOT NULL," +
                    AlimentosContract.AliemtosEntry.COLUMN_NUTRIENTES+" TEXT NOT NULL," +
                    AlimentosContract.AliemtosEntry.COLUMN_FUNCION+" TEXT NOT NULL);";
    public AlimentosSQLiteOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ALIMENTACION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ AlimentosContract.AliemtosEntry.TABLE_NAME);
        onCreate(db);


    }
}
