package com.example.xilophone01

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val a = XilofonoMain()
    private var count : Int = 0
    private lateinit var mp : MediaPlayer
    private lateinit var eText : EditText
    private lateinit var s : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mp = MediaPlayer.create(this, R.raw.easter)
    }
    fun openXilofono(view : View){
        eText = findViewById<EditText>(R.id.TextoNombre)
        s = eText.text.toString()
        if(s.isNotEmpty()){
            mp.stop()
            count = 0
            val intent = Intent (this, XilofonoMain::class.java)
            intent.putExtra("name", s)
            startActivity(intent)

        }
        else{
            count ++
            if(count == 7) {
                count == 0
                mp = MediaPlayer.create(this, R.raw.easter)
                mp.start()
                Toast.makeText(view.context, "Enjoy", Toast.LENGTH_LONG).show()
            }

            else Toast.makeText(view.context, "Ingrese un Nombre", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        count = 0
        mp.pause()
    }
    override fun onDestroy() {
        super.onDestroy()
        count = 0
        mp.pause()
    }

    fun touch(){
        val rosado = findViewById<Button>(R.id.buttonRosado)
        
    }


}


