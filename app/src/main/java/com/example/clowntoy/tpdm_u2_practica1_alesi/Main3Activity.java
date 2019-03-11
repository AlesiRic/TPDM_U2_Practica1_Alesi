package com.example.clowntoy.tpdm_u2_practica1_alesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    EditText busc;
    Button cons,retu;
    TextView uno,dos,tres,cuatro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        busc=findViewById(R.id.buscCons);
        cons=findViewById(R.id.Cons);
        retu=findViewById(R.id.consRet);
        uno.findViewById(R.id.unoA);
        dos.findViewById(R.id.dosA);
        tres.findViewById(R.id.tresA);
        cuatro.findViewById(R.id.cuatroA);

        cons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proyecto consulta=new Proyecto(Main3Activity.this);
                try{
                    Proyecto res=consulta.consultar(Integer.parseInt(busc.getText().toString()));
                    if(res!=null){
                        uno.setText(res.getDesc());
                        dos.setText(res.getUbic());
                        tres.setText(res.getFecha());
                        cuatro.setText(res.getPres()+"");
                    }
                }catch(NumberFormatException e){
                    Proyecto res=consulta.consultar(busc.getText().toString());
                    if(res!=null) {
                        uno.setText(res.getDesc());
                        dos.setText(res.getUbic());
                        tres.setText(res.getFecha());
                        cuatro.setText(res.getPres() + "");
                    }
                }
            }
        });


        retu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
