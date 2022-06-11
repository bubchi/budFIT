package com.example.budfit

import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.budfit.databinding.ActivityBmiBinding

class BMI : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var vyska = 0f;
        var vaha = 0f;
        var vek = 0f;

        //val vaha = binding.editTextTextVaha
        //val vyska = binding.editTextVyska
        //val vysledok = binding.textViewResult
        //val vypocitajButton : Button = binding.VypocitajButton

        binding.VypocitajButton.setOnClickListener() {
            //TODO null hodnoty osetrit
            vaha = binding.editTextTextVaha.text.toString().toFloat()
            vyska = binding.editTextVyska.text.toString().toFloat() / 100
            vek = binding.editTextVek.text.toString().toFloat()
            //var kometarBMI = binding.KomentarBMI.text
            if(vaha != 0f && vyska != 0f) {
                val vysledok = vaha / (vyska * vyska)

                if (vysledok < 18.5) {
                    binding.KomentarBMI.text = "malo"
                } else if (vysledok < 24.9) {
                    binding.KomentarBMI.text = "ok"
                } else
                    binding.KomentarBMI.text = "vela"

                binding.textViewResult.text = vysledok.toString()
            } else
            Toast.makeText(this,"Zadaj udaje najprv", Toast.LENGTH_SHORT).show()
        }





}}




/*override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(R.id.nav_host_fragment_content_bmi)
    return navController.navigateUp(appBarConfiguration)
            || super.onSupportNavigateUp()
}
}*/