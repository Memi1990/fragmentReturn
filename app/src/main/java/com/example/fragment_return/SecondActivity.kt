package com.example.fragment_return

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment_return.Fragments.FifthFragment
import com.example.fragment_return.Fragments.FourthFragment
import com.example.fragment_return.Fragments.ThirdFragment
import com.example.fragment_return.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var b:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(b.root)

        val frag3 = ThirdFragment()
        val frag4 = FourthFragment()
        val frag5 = FifthFragment()

        b.btnBlue.setOnClickListener {fragmentTransCustom(frag3)}
        b.btnBeige.setOnClickListener {fragmentTransCustom(frag4)}
        b.btnBrown.setOnClickListener {fragmentTransCustom(frag5)}

        b.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
//    fun fragmentTrans(fragment:Fragment){
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragmentContainerView3,fragment)
////            Poner en la pila. Eso repercute a la hora de volver
//            addToBackStack(null)
//            commit()
//        }
//    }
    fun fragmentTransCustom(fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_in,
                R.anim.slide_out,
                R.anim.fade_out)
            .replace(R.id.fragmentContainerView3,fragment)
            .commit()
    }
}