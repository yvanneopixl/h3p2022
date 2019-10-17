package com.neopixl.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var aCharacter = 'a'
        var oneValue = "👽"

        var count = 15
        // + 15
        val value1 = ++count // 15 -> 16
        count = 15
        val value2 = count++ // 15 -> 16

        count = 15

        val value3 = --count

        count = 15

        val value4 = count--

        count = 15

        count += 20

        // Name est optionnel (pas obligatoire = potentiellement nulle)
        var name: String? = null // String?

        val nameLength = name?.length

        // Ici Name2 est obligatoire
        var name2 = "" // String

        val name2Length = name2.length

        //name = "Yvan"

        val nameLengthNonNull = name?.length ?: 0

        // var nomDuTableau = ["nom", "prenom", "age"]

        // Array<Type_stocké>
        val array1 = arrayOf("nom", "prenom", 15)

        // Préférable en Kotlin d'avoir le même type
        // pour tous les éléments du tableau
        val array2 = arrayOf("login", "password", "birthdate")

        // mutableList, filter, map, reduce
    }
}
