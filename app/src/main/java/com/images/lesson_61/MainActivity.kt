package com.images.lesson_61

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns

import by.kirich1409.viewbindingdelegate.viewBinding

import com.images.lesson_61.databinding.ActivityMainBinding
import java.util.regex.Pattern
import kotlin.random.Random

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    private val imageURL = arrayListOf<String>(
        "https://st3.depositphotos.com/7340112/15280/i/1600/depositphotos_152809206-stock-photo-mountain-peaks-in-cape-town.jpg",
        "https://i.pinimg.com/474x/98/63/d6/9863d6c8548eca3e71b865a942dc10e3.jpg",
        "https://i.pinimg.com/474x/ce/e1/bb/cee1bb54ff5a8c7051956b98513a64fa.jpg",
        "https://i.pinimg.com/564x/77/d7/6f/77d76f9286c2f2bbf530f4da3b3f14be.jpg",
        "https://i.pinimg.com/474x/27/9b/42/279b42875142af1b587b2ec92d645d8c.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClicker()

    }

    private fun initClicker() {
        with(binding) {

            btnSubmit.setOnClickListener {
                if (etURL.text.isEmpty()) {
                    etURL.error = getString(R.string.empty_field)
                } else if (Patterns.WEB_URL.matcher(etURL.text.toString()).matches()) {
                    imageURL.add(etURL.text.toString())
                    image.loadImage(etURL.text.toString())
                    etURL.text.clear()
                } else showToast(getString(R.string.non_working_URL))
            }

            btnRandom.setOnClickListener {
                image.loadImage(imageURL[Random.nextInt(imageURL.size)])
            }
        }
    }

}