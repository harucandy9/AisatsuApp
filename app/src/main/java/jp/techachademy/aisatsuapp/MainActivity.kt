package jp.techachademy.aisatsuapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.app.TimePickerDialog
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timePickerButton.setOnClickListener { showTimePicker() }
    }

    private fun showTimePicker(){
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                this.aisatsuTextView.text = createAisatsu(hour)
            },
            12, 0, true)
        timePickerDialog.show()
    }

    private fun createAisatsu(hour:Int):String{

        if(2 <= hour && hour < 10){
            return "おはよう"
        }
        if(10 <= hour && hour < 18){
            return "こんにちは"
        }
        return "こんばんは"

    }



}
