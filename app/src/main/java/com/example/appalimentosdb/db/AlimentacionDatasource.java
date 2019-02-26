package com.example.appalimentosdb.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appalimentosdb.JavaBean.Alimentacion;

public class AlimentacionDatasource {
    private  AlimentosSQLiteOpenHelper ash;
    private Context context;

    public AlimentacionDatasource(Context context){
        this.context = context;
        ash = new AlimentosSQLiteOpenHelper(context);
    }

    public SQLiteDatabase openReadable(){ return ash.getReadableDatabase();}
    public SQLiteDatabase  openWriteable(){return ash.getWritableDatabase();}
    public void close(SQLiteDatabase database){ database.close();}

    public Alimentacion ConsultarAlimentacion(int idAlimentacion) {
        SQLiteDatabase sdb = openReadable();

        String select = "SELECT " + AlimentosContract.AliemtosEntry.COLUMN_ID +
                ", " + AlimentosContract.AliemtosEntry.COLUMN_NAMEA +
                ", " + AlimentosContract.AliemtosEntry.COLUMN_TIPO +
                ", " + AlimentosContract.AliemtosEntry.COLUMN_ORIGEN+
                ", " + AlimentosContract.AliemtosEntry.COLUMN_NUTRIENTES+
                ", " + AlimentosContract.AliemtosEntry.COLUMN_FUNCION+
                " FROM " + AlimentosContract.AliemtosEntry.TABLE_NAME+
                " WHERE " + AlimentosContract.AliemtosEntry.COLUMN_ID + " =?";

                String [] args = {String.valueOf(idAlimentacion)};

                Cursor cursor = sdb.rawQuery(select, args);

         Alimentacion alimentacion = null;
         int id;
         String nombreA;
         String tipoA;
         String origenA;
         String nutrientesA;
         String funcionA;

         if (cursor.moveToFirst()){
             id = cursor.getInt(cursor.getColumnIndex(AlimentosContract.AliemtosEntry.COLUMN_ID));
             nombreA = cursor.getString(cursor.getColumnIndex(AlimentosContract.AliemtosEntry.COLUMN_NAMEA));
             tipoA = cursor.getString(cursor.getColumnIndex(AlimentosContract.AliemtosEntry.COLUMN_TIPO));
             origenA = cursor.getString(cursor.getColumnIndex(AlimentosContract.AliemtosEntry.COLUMN_ORIGEN));
             nutrientesA = cursor.getString(cursor.getColumnIndex(AlimentosContract.AliemtosEntry.COLUMN_NUTRIENTES));
             funcionA = cursor.getString(cursor.getColumnIndex(AlimentosContract.AliemtosEntry.COLUMN_FUNCION));
             alimentacion = new Alimentacion(idAlimentacion, nombreA, tipoA, origenA, nutrientesA, funcionA);
         }

         cursor.close();
         sdb.close();
        return alimentacion;
    }

    



}
