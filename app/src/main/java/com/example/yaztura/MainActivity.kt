package com.example.yaztura

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flipButton: Button = findViewById(R.id.button)
        flipButton.setOnClickListener { flipCoin() }

        val firstImage: ImageView = findViewById(R.id.imageView)
        firstImage.setImageResource(R.drawable.black_question_mark)

        val ilkYaziSayac: TextView = findViewById(R.id.yaziSayisi)
        ilkYaziSayac.text = "0"

        val ilkTuraSayac: TextView = findViewById(R.id.turaSayisi)
        ilkTuraSayac.text = "0"

    }

    var yaziSayisi = 0
    var turaSayisi = 0

    //0 geldiginde yazi, 1 geldiginde tura oluyor

    private fun flipCoin() {

        val myCoin = Coin().flip()
        val coinImage: ImageView = findViewById(R.id.imageView)

        if (myCoin == 0) {
            coinImage.setImageResource(R.drawable._tl_yaz)
            yaziSayisi += 1

        } else {
            coinImage.setImageResource(R.drawable.tura)
            turaSayisi += 1
        }

        val yaziGoster: TextView = findViewById(R.id.yaziSayisi)
        yaziGoster.text = yaziSayisi.toString()

        val turaGoster: TextView = findViewById(R.id.turaSayisi)
        turaGoster.text = turaSayisi.toString()
    }
}

class Coin {

    fun flip(): Int {
        return (0..1).random()
    }
}

