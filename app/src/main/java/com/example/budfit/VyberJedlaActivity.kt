package com.example.budfit

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.R
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.budfit.databinding.ActivityVyberJedlaBinding

class VyberJedlaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVyberJedlaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVyberJedlaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val customListPriloha = listOf("ryza", "zamiaky", "bataty", "cestoviny", "kuskus")
        val adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customListPriloha)
        binding.priloha.adapter = adapter

        binding.priloha.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@VyberJedlaActivity, "you selected ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_LONG).show()
            }
        }*/

    }
}