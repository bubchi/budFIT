package com.example.budfit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.budfit.databinding.ActivityVyberJedlaBinding

class VyberJedlaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVyberJedlaBinding
    private lateinit var jedla: Jedla
    private var Kcal: Int = 0
    private lateinit var mnozstva : ArrayList<String>
    //private var mnozstvoMasa = binding.mnozstvoMasa.text.toString()
    //private var mnozstvoPrilohy = binding.mnozstvoPrilohy.text.toString()
    //private var mnozstvoZeleniny = binding.mnozstvoZeleniny.text.toString()
    //private var mnozstvoOvocia = binding.mnozstvoOvocia.text.toString()
    //private var mnozstvoObylnin = binding.mnozstvoObylnin.text.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVyberJedlaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*mnozstva.add(mnozstvoMasa)
        mnozstva.add(mnozstvoPrilohy)
        mnozstva.add(mnozstvoZeleniny)
        mnozstva.add(mnozstvoOvocia)
        mnozstva.add(mnozstvoObylnin)*/

        var ryza: Float = 0F;


        /*var spinnerPriloha = binding.priloha.adapter.getItem(1)
        if (spinnerPriloha.equals(0)) {
            ryza = Jedla.RYZA.kalorie
        }*/

        println("mmmmmmmmmmmmmm")
        binding.priloha.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val objekt = adapterView?.getItemAtPosition(position)


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        //val b = binding.maso.get
        binding.button3.setOnClickListener() {
            if (binding.mnozstvoMasa.text.toString().toFloatOrNull() != null || binding.mnozstvoPrilohy.text.toString().toIntOrNull() != null ||
                binding.mnozstvoZeleniny.text.toString().toIntOrNull() != null || binding.mnozstvoOvocia.text.toString().toIntOrNull() != null ||
                binding.mnozstvoObylnin.text.toString().toIntOrNull() != null
            ) {
                Jedla.values().forEach {
                    if (it.meno == binding.maso.selectedItem.toString() || it.meno == binding.priloha.selectedItem.toString() ||
                        it.meno == binding.zelenina.selectedItem.toString() || it.meno == binding.ovocie.selectedItem.toString() ||
                        it.meno == binding.obylniny.selectedItem.toString()) {
                        /*Log.v(
                            "RYZA menoASDASDAFADFASDASDASD",
                            binding.priloha.selectedItem.toString()
                        )*/
                        Toast.makeText(
                            this@VyberJedlaActivity,
                            binding.mnozstvoMasa.text.toString() + " " + it.kalorie.toString(),
                            Toast.LENGTH_SHORT).show()
                        Kcal = (binding.mnozstvoMasa.text.toString().toFloat() * it.kalorie.toString().toFloat()).toInt()


                        binding.sumaKalorii.text = Kcal.toString() + " " + it.kalorie.toString()
                        //TODO v cykle prejst formulare a pomocou switchu priradit hodnotu a pripocitat kalorie
                    }
                }
            }



        }

        binding.backButton.setOnClickListener() {
            backToMainActivity()
        }



    }



    fun backToMainActivity() {
        val switchActivityIntent = Intent(this, MainActivity::class.java)
        if (Kcal != null) {
            switchActivityIntent.putExtra(
                "kalorie", Kcal
            )
        }
        startActivity(switchActivityIntent)
    }
}