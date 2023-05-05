package com.example.parcial_3_diferido_miguelguzman;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String NOMBRE_DB="Parcial3.db";
    private static final int VERSION_DB=1;
    private static final String TABLA_CLIENTE= "CREATE TABLE CLIENTE(Nombre TEXT , Apellido TEXT, Direccion TEXT, Ciudad TEXT)";

    public AdminSQLiteOpenHelper(Context context)
    {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_CLIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_CLIENTE);
        sqLiteDatabase.execSQL(TABLA_CLIENTE);
    }

    public void agregarcliente(String Nombre, String Apellido, String Direccion, String Ciudad){
        SQLiteDatabase db=getWritableDatabase();
        if(db!=null){
            db.execSQL("INSERT INTO TABLA_CLIENTE VALUES('"+Nombre+"','"+Apellido+"','"+Direccion+"','"+Ciudad+"')");
            db.close();
        }
    }

}
