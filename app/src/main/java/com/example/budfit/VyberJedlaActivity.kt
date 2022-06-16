package com.example.budfit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.budfit.databinding.ActivityVyberJedlaBinding

/**
 * Aktivita, ktora umoznuje uzivatelovi z 5 spinnerov vybrat z kazdeho rozne druhy jedal
 * zadat mnozstvo gramov a nasledne vypocita mnozstvo kalorii
 */
class VyberJedlaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVyberJedlaBinding
    private var Kcal: Int = 0
    private var totalKcal: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVyberJedlaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /**
         * vypocet kalorii po stlaceni buttonu
         */
        binding.vypocitajKcal.setOnClickListener() {
            if (binding.mnozstvoJedla.text.toString().toFloatOrNull() != null) { //kontrola zadaneho mnozstva
                Jedla.values().forEach { //vsetky jedla enumu

                    //ak sa najde zhoda v mene enumu Jedla a nzvu itemu v spinneri
                    if (it.meno == binding.maso.selectedItem.toString() || it.meno == binding.priloha.selectedItem.toString() ||
                        it.meno == binding.zelenina.selectedItem.toString() || it.meno == binding.ovocie.selectedItem.toString() ||
                        it.meno == binding.obylniny.selectedItem.toString()) {

                        //vypocet zvolene mnozstvo gramov * kalorickea hodnota na jeden gram z enumu
                        Kcal = (binding.mnozstvoJedla.text.toString().toFloat() * it.kalorie.toString().toFloat()).toInt()

                        binding.sumaKalorii.text = Kcal.toString() // vypis vypocitanych kcal

                        totalKcal += Kcal //prirata vyratane hodnoty Kcal do premennej (pre nasledne posunutie do MainActivity)

                        binding.maso.setSelection(0) //nastavi defaul hodnotu spinnerov
                        binding.priloha.setSelection(0)
                        binding.zelenina.setSelection(0)
                        binding.ovocie.setSelection(0)
                        binding.obylniny.setSelection(0)
                    } 
                }
            }
        }

        /**
         * po kliknuti buttonu zavola metodu backToMainActivity
         */
        binding.backButton.setOnClickListener() {
            backToMainActivity()
        }
    }

    /**
     * prepnutie do MainActivity spolu s datami o mnozsve kalorii
     */
    fun backToMainActivity() {
        val switchActivityIntent = Intent(this, MainActivity::class.java)
        if (totalKcal != null) {
            switchActivityIntent.putExtra(
                "kalorie", totalKcal
            )
        }
        startActivity(switchActivityIntent)
    }
}