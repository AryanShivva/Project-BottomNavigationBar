package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        replaceWithFragment(Home())                                                 //calling function

        val bottomView = findViewById<BottomNavigationView>(R.id.bottomnavigation) //finding

        bottomView.setOnItemSelectedListener{                             //using
            when(it.itemId){
                R.id.item1 -> replaceWithFragment(Home())                             //replace with the fragments when clicke on it
                R.id.item2 -> replaceWithFragment(Search())
                R.id.item3 -> replaceWithFragment(Profile())
                R.id.item4 -> replaceWithFragment(Fragment4())
                else -> {
                }
            }
            true       // making items clickable

        }



    }

    private fun replaceWithFragment(fragment : Fragment){                       //function name and accepting the fragment

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()            //by default it will show home fragment
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
    }


}