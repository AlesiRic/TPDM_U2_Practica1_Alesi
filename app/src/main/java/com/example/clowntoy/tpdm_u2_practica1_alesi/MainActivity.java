package com.example.clowntoy.tpdm_u2_practica1_alesi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Proyecto[] vector;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=findViewById(R.id.lista);

    }
    @Override
    protected void onStart() {
        Proyecto pro=new Proyecto(this);
        vector=pro.consultar();
        String[] proyectodesc=null;
        if(vector==null){
            proyectodesc=new String[]{"No hay proyecto capturados"};
        }else{
            proyectodesc=new String[vector.length];
            for(int i=0;i<vector.length;i++){
                proyectodesc[i]=vector[i].getDesc();
            }
        }
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,proyectodesc);
        lista.setAdapter(adaptador);
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuprincipal,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.nuevo:
                Intent nuevo=new Intent(this,Main2Activity.class);
                startActivity(nuevo);
                break;
            case R.id.consultar:
                Intent consultar=new Intent(this,Main3Activity.class);
                startActivity(consultar);
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }



}
