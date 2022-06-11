package com.example.budfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.budfit.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout
import android.widget.EditText as Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button: Button = binding.button
        button.setOnClickListener(View.OnClickListener {
            openBMIActivity();
        })
        val vodaText : TextView = binding.vodaText
        val vodaButton: ImageButton = binding.vodaButton
        var pocitadlo = 0

        vodaButton.setOnClickListener() {
            pocitadlo ++
            vodaText.text = pocitadlo.toString()
        }
        binding.vyberJedlaButton.setOnClickListener() {
            openVyberJedlaActivity()
        }
    }

    private fun openBMIActivity() {
        val switchActivityBMIIntent = Intent(this, BMI::class.java)

        startActivity(switchActivityBMIIntent)
    }

    private fun openVyberJedlaActivity() {
        val switchActivityVyberJedlaActivity = Intent(this, VyberJedlaActivity::class.java)

        startActivity(switchActivityVyberJedlaActivity)
    }


    /*//var vyska = inputVyska.edit.
    var vek = findViewById(R.id.inputVek) as TextInputLayout
    var vaha = findViewById(R.id.inputVaha) as TextInputLayout
    //var textVysledok = findViewById(R.id.textViewResult) as TextView
    val buttonVypocitaj = findViewById(R.id.button) as Button

    buttonVypocitaj.setOnClickListener{
        //textVysledok.text = vyska.toString()


    }*/

        /*fun pocitajBMI(view: View) {
            var vyska = findViewById<EditText>(R.id.inputVyska)
            var msg = vyska.text.toString()

            val textVysledok = findViewById<TextView>(R.id.textViewResult).apply {
                text = msg
            }

        }*/

    /*fun pocitajBMI(vyska: Int, vaha: Int): Float {

    }*/



    /*fun pocitajBMI(view: android.view.View) {
        var editVyska = findViewById<android.widget.EditText>(R.id.editTextVyska)

        var editVaha = findViewById<android.widget.EditText>(R.id.editTextTextVaha)
        var editVek = findViewById<android.widget.EditText>(R.id.editTextVek)

        var vyska = editVyska.text.toString().toInt() / 100
        var vaha = editVaha.text.toString().toInt()
        var vek = editVek.text.toString().toInt()
        var msg = vaha - vyska

        val textVysledok = findViewById<TextView>(R.id.textViewResult).apply {
             text = msg.toString()
        }
    }*/

    /*fun pocitaj(vyska: Int, vaha: Int){
        var vyska = editVyska
        var vaha = editVaha
        var vysledok = vyska. + vaha
    }*/


}
    