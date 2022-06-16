package com.example.budfit

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.budfit.databinding.ActivityMainBinding
/**
 * Aktivita, ktora umoznuje uzivatelovi pridat mnozstvo vody aj s grafickym zobrazeni na progres bare
 * po kliknuti na tlacidla otvori dalsiu aktivity
 * uschovava vsetky data cez share dpreferences ktore moze uzivatel resetovat
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var progres = 0
    private var pocitadlo = 0

    private var sumaKcal: Int = 0
    private var receivedKcal: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        saveData()
        updateProgres()

        /**
         * inicializacia btnu na otvorenie BMI aktivity
         */
        val buttonOpenBMI: Button = binding.button
        buttonOpenBMI.setOnClickListener(View.OnClickListener {
            openBMIActivity();
        })


        reciveData() //zavolana metoda na ziskanie dat z aktivity VyberJeclaActivity

        /**
         * vypise a spocita prijate kalorie
         */
        val kcalJedlo: TextView = binding.kcalJedlo
            kcalJedlo.setText("jedlo")
        if (sumaKcal + receivedKcal > 0) {
        sumaKcal = sumaKcal + receivedKcal
        kcalJedlo.text = "prijate Kcal: " + sumaKcal.toString()
        } else {
            kcalJedlo.setText("jedlo")
            saveData()
        }


        val vodaText = binding.vodaText
        val vodaButton = binding.vodaButton

        /**
         * po stlaceni tlacida prida mnozstvo a vypise
         */
        vodaButton.setOnClickListener() {
            pocitadlo ++
            vodaText.text = "vypite pohare vody: " + pocitadlo.toString()
            if (progres <= 90) {
                progres += 10 //posunie progres
            }
            updateProgres() //metoda kt aktualizuje hodnotu k uzatvoreniu kruhu
            saveData()
        }

        if (pocitadlo > 0)
            vodaText.text = "vypite pohare vody: " + pocitadlo.toString()
        /**
         * po stlaceni tlacida zavola metodu na otvorenie dalsej aktivity
         */
        binding.vyberJedlaButton.setOnClickListener() {
            openVyberJedlaActivity()
        }


        /**
         * po stlaceni tlacida otvori DialogFragment
         */
        val cvicenieButton = binding.cvicenieButton
        cvicenieButton.setOnClickListener() {
            var dialog = Dialog()
            dialog.show(supportFragmentManager, "Dialog")
        }

        /**
         * vymaze ulozene data a resetuje hodnoty
         */
        val resetBTN = binding.resetData
        resetBTN.setOnClickListener(){
            val sharedPreferences = getSharedPreferences("SharedP", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.commit()

            vodaText.setText("voda")
            pocitadlo =0
            progres = 0
            updateProgres()

            sumaKcal = 0
            kcalJedlo.setText("jedlo")
        }
        saveData()

    }

    /**
     * aktualizuje stav/progres progres baru k uzatvoreniu kruhu
     */
    private fun updateProgres() {
        binding.progressBar.progress = progres
    }

    /**
     * otvori aktivitu BMI
     */
    private fun openBMIActivity() {
        val switchActivityBMIIntent = Intent(this, BMI::class.java)

        startActivity(switchActivityBMIIntent)
    }

    /**
     * otvori aktivitu openVyberJedlaActivity
     */
    private fun openVyberJedlaActivity() {
        val switchActivityVyberJedlaActivity = Intent(this, VyberJedlaActivity::class.java)

        startActivity(switchActivityVyberJedlaActivity)
    }


    /**
     * ulozenie dat cez shared preferences
     */
    private  fun saveData() {
        val sharedPreferences = getSharedPreferences("SharedP", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply(){
            putInt("pocitadloVody", pocitadlo)
            putInt("progresBar", progres)
            putInt("kcal", sumaKcal)
            //putInt("vvisible", pitnyRezimGoal)
        }.apply()
    }

    /**
     * nacitanie ulozenych dat cez shared preferences
     */
    private  fun loadData() {
        val sharedPreferences =getSharedPreferences("SharedP", Context.MODE_PRIVATE)
        pocitadlo =sharedPreferences.getInt("pocitadloVody", 0)
        progres = sharedPreferences.getInt("progresBar", 0)
        sumaKcal = sharedPreferences.getInt("kcal", 0)
        //pitnyRezimGoal = sharedPreferences.getInt("visible", pitnyRezimGoal)
    }

    /**
     * ziskanie dat z aktivity VyberJedlaActivity
     */
    private  fun reciveData() {
        receivedKcal = intent.getIntExtra("kalorie", 0)
    }






}
    