package com.example.budfit

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.budfit.databinding.ActivityBmiBinding
import java.text.DecimalFormat
import kotlin.math.roundToInt

class BMI : AppCompatActivity() {

    private var vysledok: Float = 0f
    private lateinit var binding: ActivityBmiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewResult.text = "" //schova vysledny text
        binding.KomentarBMI.text = "" //schova vysledny text

        /**
         * vypocet BMI po stlaceni tlacidla
         */
        binding.VypocitajButton.setOnClickListener() {
            val vaha = binding.editTextTextVaha.text.toString().toFloatOrNull()
            var vyska = binding.editTextVyska.text.toString().toFloatOrNull()
            val vek = binding.editTextVek.text.toString().toFloatOrNull()

            if (vaha != null && vyska != null) {
                vyska = vyska/100
                vysledok = vaha / (vyska * vyska) //vzorec pre vypocet BMI

                if (vysledok < 18.5) {
                    binding.KomentarBMI.text = "podla BMI mas nizku vahu"
                } else if (vysledok < 24.9) {
                    binding.KomentarBMI.text = "podla BMI mas vahu v norme"
                } else
                    binding.KomentarBMI.text = "podla BMI mas nadvahu"


                val df =DecimalFormat("#.##")

                binding.textViewResult.text = df.format(vysledok).toString() //vypis BMI ypoctu
             } else {
                 Toast.makeText(this,"Zadaj udaje najprv", Toast.LENGTH_SHORT).show()}
        }







}


}




/*override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(R.id.nav_host_fragment_content_bmi)
    return navController.navigateUp(appBarConfiguration)
            || super.onSupportNavigateUp()
}
}*/