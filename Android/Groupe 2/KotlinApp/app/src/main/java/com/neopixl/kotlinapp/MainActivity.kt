package com.neopixl.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class User(val firstName: String, val lastName: String,
           val emailAddress: String, var age: Int) {

    fun displayInformation() {
        println("$firstName $lastName $emailAddress $age")
    }
}

// "Kayak".isPalindrome()
fun String.isPalindrome(): Boolean {
    val reverseWord = this.reversed()

    // kayak == kayak
    // Kayak == kayaK
    return this.toLowerCase() == reverseWord.toLowerCase()
}

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

        var values = mutableListOf(1, 4, 5, 6, 7)

        // values = collection muable
        values.add(8)

        values.remove(5)    // return true

        values.remove(99)   // return false

        values.removeAt(0)    // suppresion du premier élément : index=0


        // Boucler sur le tableau = parcourir tous les éléments

        // For index de 0 à n

        for(i in 0 until values.count()) {
            val value = values[i]
            println("valeur $value")
        }

        for(i in values.indices) {
            val value = values[i]
            println("valeur $value")
        }

        // For each

        for(oneValue in values) {
            println("valeur $oneValue")
        }

        // Tri du tableau

        values.sort()       // Destructif, modifie le contenu

        // Non destructif, récupération d'un nouveau tableau
        val valuesSorted = values.sorted()

        // Map, filter, reduce  -> Non destructif

        // Map = transformation d'un tableau avec un type
        // vers un tableau avec un autre type

        // values : 4, 6, 7, 8

        val mapValues = values.map { value ->
            // value = 4
            // value = 6
            // value = 7
            // value = 8

            // Pour chaque valeur récupérée on retourne la valeur sous forme de String
            value.toString()
        }

        // Filter = récupération d'un tableau filtré
        // (avec potentiellement moins d'élements que l'original)

        // it = valeur récupéré du tableau
        val evenValues = values.filter {
            // filter conserve la valeur du tableau si le retour == true
            it%2==0
        }

        // evenValues = [4, 6, 8]

        // Reduce = à partir d'un tableau on obtient une valeur

        val sum = values.reduce { acc, i ->
            // acc = valeur accumulé de la précédente itération
            // i = nouvelle valeur (4, 6, 7 puis 8)
            acc + i
        }

        println("sum $sum")  // 25

        val isValid = true

        if(isValid) {
            println("C'est valide")
        } else {
            println("Ce n'est pas valide")
        }

        // switch

        val number = 3

        // when = switch
        when(number) {
            1 -> {
                println("Cas un")
            }
            2 -> {
                println("Cas deux")
            }
            3 -> {
                println("Cas trois")
            }
            4 -> {
                println("Cas quatre")
            }
            else -> {
                println("Cas raté")
            }
        }

        val palindromeTest = isPalindrome("Kayak") // true

        val palindromeTest2 = "Kayak".isPalindrome()
        "Radio".isPalindrome() // false

        // création d'une instance (objet) User en appelant le constructeur
        val user1 = User("John", "Weak",
            "john.weak@hetic.net", 45)
        user1.displayInformation()

        // Une majuscule au début d'un Nom = Classe
        // une minuscule au début d'un nom = variable / constante / nom_méthode

        // Incorrect !!!
        var Array1 = arrayOf(10, 2, 4)

        // Correct
        var array11 = arrayOf(10, 2, 4)

        // user2 = instance (commence par une minuscule)
        // User = classe (commence par une majuscule)
        val user2 = User("Roxane", "Police",
            "roxane@police.co.uk", 35)

        user2.age++

    }

    // word = kayak -> true
    // word = boat -> false
    fun isPalindrome(word: String): Boolean {
        val reverseWord = word.reversed()

        // kayak == kayak
        // Kayak == kayaK
        return word.toLowerCase() == reverseWord.toLowerCase()
    }

}
