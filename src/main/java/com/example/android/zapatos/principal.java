package com.example.android.zapatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class principal extends AppCompatActivity {
    private  String[] marcaComprador;
    private ArrayAdapter aMarca;
    private TextView valorTotal;
    private  String[] sexoComprador;
    private ArrayAdapter aSexo;
    private  String[] tipoComprador;
    private Spinner Sexo;
    private Spinner TipoZ;
    private Spinner Marca;
    private ArrayAdapter Tipo;
    private EditText canti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        canti = (EditText)findViewById(R.id.txtCantidad);
        Sexo = (Spinner)findViewById(R.id.cboSexo);
        valorTotal = (TextView)findViewById(R.id.txtTotCompra);
        TipoZ = (Spinner)findViewById(R.id.cboTipoZapato);
        Marca = (Spinner)findViewById(R.id.cboMarca);

        sexoComprador =this.getResources().getStringArray(R.array.sexo_comprador);
        aSexo = new ArrayAdapter(this,android.R.layout.simple_list_item_1,sexoComprador);
        Sexo.setAdapter(aSexo);

        tipoComprador =this.getResources().getStringArray(R.array.tipo_zapato);
        Tipo = new ArrayAdapter(this,android.R.layout.simple_list_item_1,tipoComprador);
        TipoZ.setAdapter(Tipo);

        marcaComprador =this.getResources().getStringArray(R.array.marca_zapato);
        aMarca = new ArrayAdapter(this,android.R.layout.simple_list_item_1,marcaComprador);
        Marca.setAdapter(aMarca);

    }

    public void calcularTotal(View v){
        int sexo, tipo, marca, cant, res=0,uni=0;
        int Hombren=120000, Hombrea=140000, Hombrep=130000;
        int Hombrecn=50000, Hombreca=80000, Hombrecp=100000;
        int Mujern=100000, Mujera=130000, Mujerp=110000;
        int Mujercn=60000, Mujerca=70000, Mujercp=120000;

        if (validar()) {
            cant = Integer.parseInt(canti.getText().toString());
            sexo = Sexo.getSelectedItemPosition();
            tipo = TipoZ.getSelectedItemPosition();
            marca = Marca.getSelectedItemPosition();

            switch (sexo) {

                case 0:

                    switch (tipo) {

                        case 0:

                            switch (marca) {

                                case 0:
                                    res = cant * Hombren;
                                    uni = Hombren;
                                    break;
                                case 1:
                                    res = cant * Hombrea;
                                    uni = Hombrea;
                                    break;
                                case 2:
                                    res = cant * Hombrep;
                                    uni = Hombrep;
                                    break;


                            }
                            break;
                        case 1:

                            switch (marca) {

                                case 0:
                                    res = cant * Hombrecn;
                                    uni = Hombrecn;
                                    break;
                                case 1:
                                    res = cant * Hombreca;
                                    uni = Hombreca;
                                    break;
                                case 2:
                                    res = cant * Hombrecp;
                                    uni = Hombrecp;
                                    break;
                            }
                            break;

                    }
                    break;

                case 1:

                    switch (tipo) {

                        case 0:

                            switch (marca) {

                                case 0:
                                    res = cant * Mujern;
                                    uni = Mujern;
                                    break;
                                case 1:
                                    res = cant * Mujera;
                                    uni = Mujera;
                                    break;
                                case 2:
                                    res = cant * Mujerp;
                                    uni = Mujerp;
                                    break;


                            }
                            break;
                        case 1:

                            switch (marca) {

                                case 0:
                                    res = cant * Mujercn;
                                    uni = Mujercn;
                                    break;
                                case 1:
                                    res = cant * Mujerca;
                                    uni = Mujerca;
                                    break;
                                case 2:
                                    res = cant * Mujercp;
                                    uni = Mujercp;
                                    break;
                            }
                            break;

                    }

                    break;
            }
            valorTotal.setText("" + res);
        }
    }



    public boolean validar() {

        if (canti.getText().toString().isEmpty()) {
            canti.setError(this.getResources().getString(R.string.error_c));
            canti.requestFocus();
            return false;
        }
        if (Integer.parseInt(canti.getText().toString()) == 0) {
            canti.setError(this.getResources().getString(R.string.error_cero));
            canti.requestFocus();
            return false;

        }
        return true;
    }


}
