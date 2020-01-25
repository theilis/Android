package com.example.alcoolgasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalcular(view: View){
        val precoAlcool = editTextAlcool.text.toString()
        val precoGasolina = editTextGasolina.text.toString()

        if(validarCampos(precoAlcool, precoGasolina)){
            calculaMelhorPreco(precoAlcool, precoGasolina)
        } else{
            textViewResultado.setText("Digite um valor")
        }
    }

    fun validarCampos (precoAlcool: String, precoGasolina: String): Boolean{
        var camposValidos: Boolean = true
        if(precoAlcool == null || precoAlcool.equals("")){
            camposValidos = false;
        }
        else if(precoGasolina == null || precoGasolina.equals("")){
            camposValidos = false;
        }
        return camposValidos;
    }

    fun calculaMelhorPreco(precoAlcool: String, precoGasolina: String){
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina
        if(resultadoPreco >= 0.7){
            textViewResultado.setText("Melhor utilizar Gasolina")
        } else{
            textViewResultado.setText("Melhor utilizar alcool")
        }
    }
}
