package com.example.misionticsemana1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ejemploRelativeLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_relative_layout);

        TextView txtResultado = (TextView) findViewById(R.id.relative_txtResultado);
        Switch swActivo = (Switch) findViewById(R.id.relative_SwitchActivo);
        Button btnVerificar = (Button) findViewById(R.id.relative_btnVerificar);
        ToggleButton tbnActivo = (ToggleButton) findViewById(R.id.relative_ToggleActivo);
        Spinner spnColores = (Spinner) findViewById(R.id.relative_spinnerColores);
        RadioGroup drgGeneros = (RadioGroup) findViewById(R.id.relative_RadioGroupGeneros);

        drgGeneros.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.relative_radioMasculino: txtResultado.setText("Masculino");
                break;
                    case R.id.relative_radioFemenino: txtResultado.setText("Femenino");
                break;}
            }
        });

        ArrayAdapter<CharSequence> lista = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item);
        lista.add("Blanco");
        lista.add("Negro");
        lista.add("Rojo");
        lista.add("Azul");
        lista.add("Verde");

        spnColores.setAdapter(lista);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                if(swActivo.isChecked()){
                   txtResultado.setText("El Switch está activo");
                }else{
                    txtResultado.setText("El Switch no está activo");
                }

                txtResultado.setText(swActivo.isChecked()?"El Switch está activo":"El Switch no está activo");
                 */
                String resultado = "Resultado: ";
                resultado += swActivo.isChecked()?"Switch (activo)":"Switch (inactivo) - ";
                resultado += tbnActivo.isChecked()?"Toggle (activo)":"Toggle (inactivo) ";
                txtResultado.setText(resultado);

            }
        });

       /* ListView listSitios = (ListView) findViewById(R.id.semana2_listaSitios);
        Spinner spinnerSitios = (Spinner) findViewById(R.id.semana2_spinnerSitios);
        TextView txtListaSitios = (TextView) findViewById(R.id.semana2_txtListaSitios);
        TextView txtSpinnerSitios = (TextView) findViewById(R.id.semana2_txtSpinnerSitios);

        listSitios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String resultado = (String) parent.getItemAtPosition(position);
                txtListaSitios.setText(resultado);
            }
        });

        spinnerSitios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String resultado = (String) parent.getSelectedItem();
                txtSpinnerSitios.setText(resultado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                AlertDialog.Builder msj = new AlertDialog.Builder(parent.getContext());
                msj.setTitle("Error");
                msj.setMessage("Ningun elemento");
                msj.create();
                msj.show();
            }
        }); */
    }
}