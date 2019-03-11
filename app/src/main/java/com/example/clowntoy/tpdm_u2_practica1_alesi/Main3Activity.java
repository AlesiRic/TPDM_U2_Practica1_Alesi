package com.example.clowntoy.tpdm_u2_practica1_alesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    EditText cons;
    TextView uno,dos,tres,cuatro;

    Button search,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        cons=findViewById(R.id.buscCons);
        uno=findViewById(R.id.unoA);
        dos=findViewById(R.id.dosA);
        tres=findViewById(R.id.tresA);
        cuatro=findViewById(R.id.cuatroA);
        search=findViewById(R.id.Cons);
        exit=findViewById(R.id.consRet);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Proyecto select = new Proyecto(Main3Activity.this);
                    select = select.consultar(Integer.parseInt(cons.getText().toString()));
                    uno.setText(select.getDesc());
                    dos.setText(select.getUbic());
                    tres.setText(select.getFecha());
                    cuatro.setText(select.getPres()+"");
                }catch (NumberFormatException e){
                    Proyecto select = new Proyecto(Main3Activity.this);
                    select = select.consultar(cons.getText().toString());
                    uno.setText(select.getDesc());
                    dos.setText(select.getUbic());
                    tres.setText(select.getFecha());
                    cuatro.setText(select.getPres()+"");
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
