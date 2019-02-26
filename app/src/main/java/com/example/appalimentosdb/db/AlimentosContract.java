package com.example.appalimentosdb.db;

import android.provider.BaseColumns;

public class AlimentosContract {

    public static  abstract  class AliemtosEntry implements BaseColumns{
        public static final String TABLE_NAME = "ALIMENTOS";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAMEA = "NOMBRE_ALIMENTOS";
        public static final String COLUMN_TIPO = "TIPO_ALIMENTOS";
        public static final String COLUMN_ORIGEN = "ORIGEN_ALIMENTOS";
        public static final String COLUMN_NUTRIENTES = "NUTRIENTES_ALIMENTACION";
        public static final String COLUMN_FUNCION = "FUNCION_ALIMENTACION";


    }
}
