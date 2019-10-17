package com.neopixl.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val = constante
        // var = variable

        val day: Int = 14
        // day = 15 // impossible, day est une constante
        var month = 6 // Type inference

        // month = "7" // impossible car month a été défini
        // comme un entier

        month = 7


        var count = 10

        val value1 = count++

        // val value1 = count; count = count + 1;

        // value1 = 10

        count = 10

        val value2 = ++count

        // value2 = 11

        count = 10

        count += 20 // count = 30

        // String = String avec tout le temps une valeur
        // String? = String potentiellement nulle
        var name: String? = "Jules"

        name = null

        val nameLength = name?.length

        val nameLengthNonNull = name?.length ?: 0

        // var tableau = ["nom", "prenom", "age"]

        // Array<type_stocké>
        val tableau = arrayOf("nom", "prenom", 20)

        // En Kotlin on préfère utiliser
        // des tableaux avec le même type stocké (ex : que des String)

    }
}
