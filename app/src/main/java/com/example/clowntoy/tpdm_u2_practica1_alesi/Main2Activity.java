package com.example.clowntoy.tpdm_u2_practica1_alesi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText desc,ubic,fech,pres;
    Button accept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        desc=findViewById(R.id.descProy);
        ubic=findViewById(R.id.ubicProy);
        fech=findViewById(R.id.fechaProy);
        pres=findViewById(R.id.presProy);
        accept=findViewById(R.id.btninsert);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
    }

    private void insert(){
        Proyecto insert=new Proyecto(this);
        Proyecto nuevo=new Proyecto(-1,
                desc.getText().toString(),
                ubic.getText().toString(),
                fech.getText().toString(),
                Float.parseFloat(pres.getText().toString()));
        boolean con=insert.insertar(nuevo);
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        if(con){
            b.setTitle("Exito").setPositiveButton("OK",null)
                    .setMessage("La inserción se realizo con éxito.").show();

            return;
        }
        b.setTitle("Error").setPositiveButton("OK",null)
                .setMessage("La inserción no se pudo realizar").show();
    }
}
