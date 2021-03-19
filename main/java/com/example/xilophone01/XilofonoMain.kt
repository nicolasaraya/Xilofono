package com.example.xilophone01

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_xilofono_main.*

class XilofonoMain : AppCompatActivity() {
    private lateinit var mp : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        var i = intent
        var s = i.getStringExtra("name")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xilofono_main)
        var t = findViewById<TextView>(R.id.texto)
        t.text= "Bienvenido, " + s
        if(s == "Mario Medina" || s == "mario medina") t.text = "Bienvenido Profesor"
    }


    fun sonido(view : View){
        if(view.getId() == R.id.buttonRosado ) mp = MediaPlayer.create(this, R.raw.do1)
        if(view.getId() == R.id.buttonMorado ) mp = MediaPlayer.create(this, R.raw.re)
        if(view.getId() == R.id.buttonAzul ) mp = MediaPlayer.create(this, R.raw.mi)
        if(view.getId() == R.id.buttonCeleste ) mp = MediaPlayer.create(this, R.raw.fa)
        if(view.getId() == R.id.buttonVerde ) mp = MediaPlayer.create(this, R.raw.sol)
        if(view.getId() == R.id.buttonAmarillo ) mp = MediaPlayer.create(this, R.raw.la)
        if(view.getId() == R.id.buttonNaranja ) mp = MediaPlayer.create(this, R.raw.si)
        if(view.getId() == R.id.buttonRojo ) mp = MediaPlayer.create(this, R.raw.do2)
        mp.start()
        mp.setOnCompletionListener(object : MediaPlayer.OnCompletionListener {
            override fun onCompletion(mp: MediaPlayer) {
                mp.release()
            }
        })
    }
}