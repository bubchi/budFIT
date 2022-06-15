package com.example.budfit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.budfit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var progres = 0
    private var pocitadlo = 0

    private lateinit var voda: String
    private var kalorie: Int = 0

    private lateinit var vodaText : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        updateProgres()


        //inicializacia btnu na otvorenie BMI aktivity,
        val buttonOpenBMI: Button = binding.button
        buttonOpenBMI.setOnClickListener(View.OnClickListener {
            openBMIActivity();
        })


        val kcalJedlo: TextView = binding.kcalJedlo
        kcalJedlo.text = kalorie.toString()

        //vodaText = binding.vodaText
        val vodaText = binding.vodaText
        val vodaButton: ImageButton = binding.vodaButton


        //vodaText.text = pocitadlo.toString()
        //vodaText.text = voda

        if (pocitadlo > 0)
            vodaText.text = pocitadlo.toString()


        vodaButton.setOnClickListener() {
            pocitadlo ++
            vodaText.text = pocitadlo.toString()
            if (progres <= 90)
                progres += 10
            updateProgres()

            saveData()
        }
        saveData()
        binding.vyberJedlaButton.setOnClickListener() {
            openVyberJedlaActivity()
        }


        val cvicenieButton = binding.cvicenieButton
        cvicenieButton.setOnClickListener() {

            var dialog = Dialog()
            dialog.show(supportFragmentManager, "Dialog")
        }


    }

    private fun updateProgres() {
        binding.progressBar.progress = progres
    }

    private fun openDialog() {
        TODO("Not yet implemented")
    }

    private fun openBMIActivity() {
        val switchActivityBMIIntent = Intent(this, BMI::class.java)

        startActivity(switchActivityBMIIntent)
    }

    private fun openVyberJedlaActivity() {
        val switchActivityVyberJedlaActivity = Intent(this, VyberJedlaActivity::class.java)

        startActivity(switchActivityVyberJedlaActivity)
    }


    private  fun saveData() {
        val sharedPreferences = getSharedPreferences("SharedP", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply(){
            putInt("check", pocitadlo)
            putInt("p", progres)
            putInt("kcal", kalorie)
            //putString("voda", voda)
        }.apply()
    }
    private  fun loadData() {
        val sharedPreferences =getSharedPreferences("SharedP", Context.MODE_PRIVATE)
        pocitadlo =sharedPreferences.getInt("check", 0)
        progres = sharedPreferences.getInt("p", 0)
        kalorie = sharedPreferences.getInt("kcal", 0)
        //val savedString : String? = sharedPreferences.getString("voda", null)
        //vodaText.text = pocitadlo.toString()
    }


    private  fun reciveData() {
        kalorie = intent.getIntExtra("kalorie", 0)
    }





}
    