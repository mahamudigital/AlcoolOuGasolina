package com.mahamudigitallab.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    //declara variaveis
    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // instancia os elementos de interface
        editPrecoAlcool = findViewById(R.id.editTextPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editTetPrecoGasolina);
        textResultado = findViewById(R.id.textViewResultado);
    }

    //define o metodo que calcula o preço
    public void calcularPreco(View view) {
        //recupera valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();
        //validar os campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados) {

            //convertendo String para números
            double valorAlcool = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble(precoGasolina);
            /* Fazer cáluco de menor preço
            se (valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
            se não e melhor utilizar álcool */
            Double resultado = valorAlcool / valorGasolina;
            if (resultado >= 0.7){
                textResultado.setText("Melhor utilizar Gasolina");
            }else{
                textResultado.setText("Melhor utilizar Álcool");
            }
        } else {
            textResultado.setText("Preencha os preços primeiro!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {
        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }
}