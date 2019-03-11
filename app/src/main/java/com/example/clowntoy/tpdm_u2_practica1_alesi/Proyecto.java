package com.example.clowntoy.tpdm_u2_practica1_alesi;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Proyecto {
    BaseProyecto base;
    private int idpr;
    private String desc;
    private String ubic;
    private String error;
    private String fecha;
    private float pres;


    public Proyecto(Activity act){
        base=new BaseProyecto(act,"constructora",null,1);
    }

    public Proyecto(int idpr,String desc,String ubic,String fecha,float pres){
        this.idpr=idpr;
        this.desc=desc;
        this.ubic=ubic;
        this.fecha=fecha;
        this.pres=pres;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUbic() {
        return ubic;
    }

    public void setUbic(String ubic) {
        this.ubic = ubic;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPres() {
        return pres;
    }

    public void setPres(float pres) {
        this.pres = pres;
    }

    public int getIdpr() {
        return idpr;
    }

    public void setIdpr(int idpr) {
        this.idpr = idpr;
    }


    public String getError(){
        return error;
    }


    public boolean insertar(Proyecto proy){
        try{
            SQLiteDatabase insert=base.getWritableDatabase();
            ContentValues valores=new ContentValues();
            valores.put("DESCRIPCION",proy.getDesc());
            valores.put("UBICACION",proy.getUbic());
            valores.put("FECHA",proy.getFecha());
            valores.put("PRESUPUESTO",proy.getPres());
            long resultado=insert.insert("Proyectos","IDPROYECTO ",valores);
            insert.close();
            if(resultado==-1){
                error="El insert no pudo realizarse";
                return false;
            }
        }catch(SQLiteException e){
            error=e.getMessage();
            return false;
        }
        return true;
    }

    public Proyecto[] consultar(){
        Proyecto[] result=null;
        try{
            SQLiteDatabase select=base.getReadableDatabase();
            String SQL="SELECT * FROM Proyectos;";
            Cursor c=select.rawQuery(SQL,null);
            if(c.moveToFirst()) {
                result = new Proyecto[c.getCount()];
                int pos = 0;
                do {


                    result[pos] = new Proyecto(c.getInt(0), c.getString(1),
                            c.getString(2), c.getString(3), c.getFloat(4));
                    pos++;
                } while (c.moveToNext());
            }
        }catch(SQLiteException e){
            error=e.getMessage();
            return null;
        }
        return result;
    }

    public Proyecto consultar(int id){
        Proyecto result=null;
        try{
            SQLiteDatabase select=base.getReadableDatabase();
            String SQL="SELECT * FROM Proyectos WHERE IDPROYECTO="+id+";";
            Cursor c=select.rawQuery(SQL,null);
            if(c.moveToFirst()) {
                result = new Proyecto(c.getInt(0), c.getString(1),
                        c.getString(2), c.getString(3), c.getFloat(4));
            }
        }catch(SQLiteException e){
            error=e.getMessage();
            return null;
        }
        return result;
    }

    public Proyecto consultar(String d){
        Proyecto result=null;
        try{
            SQLiteDatabase select=base.getReadableDatabase();
            String SQL="SELECT * FROM Proyectos WHERE DESCRIPCION='"+d+"';";
            Cursor c=select.rawQuery(SQL,null);
            if(c.moveToFirst()) {
                result = new Proyecto(c.getInt(0), c.getString(1),
                        c.getString(2), c.getString(3), c.getFloat(4));
            }
        }catch(SQLiteException e){
            error=e.getMessage();
            return null;
        }
        return result;
    }

}
