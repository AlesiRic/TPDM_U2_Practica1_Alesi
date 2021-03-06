package com.example.clowntoy.tpdm_u2_practica1_alesi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseProyecto extends SQLiteOpenHelper {
    public BaseProyecto(Context context,String name,SQLiteDatabase.CursorFactory factory,int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Proyectos(IDPROYECTO INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DESCRIPCION VARCHAR(200) NOT NULL," +
                "UBICACION VARCHAR(200)," +
                "FECHA DATE," +
                "PRESUPUESTO FLOAT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
