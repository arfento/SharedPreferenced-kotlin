package com.ims.sharedpreferenced_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ims.sharedpreferenced_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var preferencesProvider: PreferencesProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        preferencesProvider = PreferencesProvider(applicationContext)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            preferencesProvider.putString(Constants.KEY_FIRST_NAME, binding.inputFirstName.text.toString())
            preferencesProvider.putString(Constants.KEY_LAST_NAME, binding.inputLastName.text.toString())
            preferencesProvider.putString(Constants.KEY_AGE, binding.inputAge.text.toString())
            preferencesProvider.putBoolean(
                Constants.KEY_GENDER,
                binding.rgGender.checkedRadioButtonId == R.id.rbMale
            )
            Toast.makeText(this@MainActivity, "Data saved", Toast.LENGTH_SHORT).show()
        }

        binding.btnLoad.setOnClickListener{
            binding.inputFirstName.setText(preferencesProvider.getString(Constants.KEY_FIRST_NAME))
            binding.inputLastName.setText(preferencesProvider.getString(Constants.KEY_LAST_NAME))
            binding.inputAge.setText(preferencesProvider.getString(Constants.KEY_AGE))
            if (preferencesProvider.getBoolean(Constants.KEY_GENDER)){
                binding.rbMale.isChecked = true
            }else{
                binding.rbFemale.isChecked = true
            }
            Toast.makeText(this@MainActivity, "Data Retrieved", Toast.LENGTH_SHORT).show()
        }

        binding.btnClear.setOnClickListener {
            preferencesProvider.clear()
            Toast.makeText(this@MainActivity, "Data clear", Toast.LENGTH_SHORT).show()

        }

    }
}