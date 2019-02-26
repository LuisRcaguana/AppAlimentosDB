package com.example.appalimentosdb.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appalimentosdb.JavaBean.Alimentacion;

import java.util.ArrayList;

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

    public ArrayList<Alimentacion> consultarAl(){
        ArrayList<Alimentacion> listaAlimentos = new ArrayList<Alimentacion>();
        SQLiteDatabase sdb = openReadable();

        String[] columnas = {AlimentosContract.AliemtosEntry.COLUMN_ID,
                             AlimentosContract.AliemtosEntry.COLUMN_NAMEA,
                             AlimentosContract.AliemtosEntry.COLUMN_TIPO,
                             AlimentosContract.AliemtosEntry.COLUMN_ORIGEN,
                             AlimentosContract.AliemtosEntry.COLUMN_NUTRIENTES,
                             AlimentosContract.AliemtosEntry.COLUMN_FUNCION};
        Cursor cursor = sdb.query(AlimentosContract.AliemtosEntry.TABLE_NAME,
                                columnas, null, null,
                null, null, AlimentosContract.AliemtosEntry.COLUMN_NAMEA + "DESC");//AQUI PUEDES AÑADIR MAS ATRIBUTOS

        int id;
        String nombreA;
        String tipoA;
        String origenesA;
        String nutrientesA;
        String funcionA;
        if (cursor.moveToFirst()){
            do{
                id = cursor.getInt(cursor.getColumnIndex(AlimentosContract.AliemtosEntry.COLUMN_ID));
                nombreA = cursor.getString(cursor.getColumnIndex(AlimentosContract.AliemtosEntry.COLUMN_NAMEA));
                tipoA = cursor.getString(cursor.getColumnIndex(AlimentosContract.AliemtosEntry.COLUMN_TIPO));
                origenesA = cursor.getString(cursor.getColumnIndex(AlimentosContract.AliemtosEntry.COLUMN_ORIGEN));
                nutrientesA = cursor.getString(cursor.getColumnIndex(AlimentosContract.AliemtosEntry.COLUMN_NUTRIENTES));
                funcionA = cursor.getString(cursor.getColumnIndex(AlimentosContract.AliemtosEntry.COLUMN_FUNCION));
                listaAlimentos.add(new Alimentacion(id, nombreA, tipoA, origenesA, nutrientesA, funcionA));
            } while (cursor.moveToNext());
        }
            cursor.close();
            sdb.close();
            return  listaAlimentos;

    }

    public long meterAlimentacion(Alimentacion alimentacion){
        SQLiteDatabase sdb = openWriteable();

        sdb.beginTransaction();

        ContentValues cv = new ContentValues();
        cv.put(AlimentosContract.AliemtosEntry.COLUMN_NAMEA, alimentacion.getNameA());
        cv.put(AlimentosContract.AliemtosEntry.COLUMN_TIPO, alimentacion.getTipoA());
        cv.put(AlimentosContract.AliemtosEntry.COLUMN_ORIGEN, alimentacion.getOrigenA());
        cv.put(AlimentosContract.AliemtosEntry.COLUMN_NUTRIENTES, alimentacion.getNutrientesA());
        cv.put(AlimentosContract.AliemtosEntry.COLUMN_FUNCION, alimentacion.getFuncionA());

        long id =  sdb.insert(AlimentosContract.AliemtosEntry.TABLE_NAME, null, cv);

        if(id != -1){
            sdb.setTransactionSuccessful();
        }
        sdb.endTransaction();
        close(sdb);
        return id;
    }
    public  void  modiAlimentacion(Alimentacion alimentacion){
        SQLiteDatabase sdb = openWriteable();
        sdb.beginTransaction();

        ContentValues contentValues = new ContentValues();
        contentValues.put(AlimentosContract.AliemtosEntry.COLUMN_NAMEA,
                alimentacion.getNameA());
        contentValues.put(AlimentosContract.AliemtosEntry.COLUMN_TIPO,
                alimentacion.getTipoA());
        contentValues.put(AlimentosContract.AliemtosEntry.COLUMN_ORIGEN,
                alimentacion.getOrigenA());
        contentValues.put(AlimentosContract.AliemtosEntry.COLUMN_NUTRIENTES,
                alimentacion.getNutrientesA());
        contentValues.put(AlimentosContract.AliemtosEntry.COLUMN_FUNCION,
                alimentacion.getFuncionA());

        String clausulaWhere = AlimentosContract.AliemtosEntry.COLUMN_ID + " = ?";
        String [] argumentos = {String.valueOf(alimentacion.getIdA())};

        sdb.update(AlimentosContract.AliemtosEntry.TABLE_NAME,
                contentValues,
                clausulaWhere,
                argumentos
                );

    }


    



}
