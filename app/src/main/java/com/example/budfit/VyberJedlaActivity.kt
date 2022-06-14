package com.example.budfit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.R
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.budfit.databinding.ActivityVyberJedlaBinding

class VyberJedlaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVyberJedlaBinding
    private lateinit var jedla: Jedla

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVyberJedlaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val spinner: Spinner = findViewById(R.id.priloha)

        val customList = listOf("1", "2", "3", "4")
        val c = listOf(jedla)
        //val adapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, c)

        //binding.ovocie.adapter =adapter

        var ryza: Float = 0F;

        var spinnerPriloha = binding.priloha.adapter.getItem(1)
        if (spinnerPriloha.equals(0)) {
            ryza = Jedla.RYZA.kalorie
        }

        println("mmmmmmmmmmmmmm")
        binding.priloha.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val objekt = adapterView?.getItemAtPosition(position)


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        //val b = binding.maso.get
        binding.button3.setOnClickListener() {
            Toast.makeText(this@VyberJedlaActivity, " kcal " + ryza.toString() + " " + "", Toast.LENGTH_SHORT).show()
        }







    }

    fun main() {

    }

    private fun getKalorie(jedla: Jedla) {

    }
}