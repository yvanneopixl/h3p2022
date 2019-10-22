package com.neopixl.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Créer une function extension
fun String.isPalindrome(): Boolean {
    if(this.trim().isEmpty()) return false

    val reversedWord = this.reversed()
    return reversedWord.toLowerCase()==this.toLowerCase()
}

class Credential(val login: String, private val password: String, var validityDuration: Int) {

    fun displayPassword() {
        println("password: $password")
    }

}

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


        // MutableList (ajout, suppresion, …)
        val brands = mutableListOf("HTC", "Samsung", "Xiaomi", "Huawei")

        brands.add("One Plus")

        brands.add(0, "Apple")

        // Pour afficher un log dans la console

        // [Apple, HTC, Samsung, Xiaomi, Huawei, One Plus]
        println("brands : $brands")

        // premier index = 0
        brands.removeAt(0)

        // Boucle

        // for index

        for(i in 0 until brands.size) {
            val brandName = brands[i]

            println("brand: $brandName")
        }

        // for each (Méthode conseillée)

        for(brandName in brands) {
            println("brand: $brandName")
            val index = brands.indexOf(brandName)
        }

        // Don't worry
        brands.forEachIndexed { index, brandName ->
            println("brand at $index = $brandName")
        }

        // Tri

        // Non destructive = récupération d'une copie du tableau triée

        val sortedBrands = brands.sorted()

        // Destructive = tri du tableau original

        brands.sort()

        // Map, filter, reduce

        // Map = transformation d'un tableau avec un type vers un tableau avec un autre type
        // List<Int> -> List<String>

        val mapBrands = brands.map { brandName ->
            "Marque $brandName"
        }

        // mapBrands = [Marque HTC, Marque Samsung, Marque Xiaomi, Marque Huawei, Marque One Plus]

        // Filter = filter le tableau (le tableau retourné pas la méthode filter
        // contient potentiellement moins d'éléments que le tableau d'origine)

        val values = arrayOf(1, 2, 4, 5, 6, 7, 10)

        // pour conserver les valeurs filtrées on doit retourner true
        val evenValues = values.filter {
            it%2==0
        }

        // evenValues = [2, 4, 6, 10]

        // Reduce : A partir de plusieurs éléments on va récupérer un seul élément

        // acc = valeur précédente accumulée
        // value = valeur courante
        val sum = values.reduce { acc, value ->
            acc + value
        }

        // sum = 35

        val sumWithInitialValue = values.fold(10, { acc, value ->
            acc + value
        })

        // sumWithInitialValue = 45


        // If
        val isValid = true

        if(isValid) {
            println("C'est valide")
        } else {
            println("C'est invalide")
        }

        // Switch
        // en Kotlin : when

        val number = 3

        when(number) {
            1 -> println("Cas un")
            2 -> println("Cas deux")
            3 -> {
                // Pour exécuter plusieurs lignes
                println("Cas trois")
            }
            else -> println("Cas raté")

        }

        val testPalindrome = isPalindrome("Kayak")
        val testPalindrome2 = isPalindrome("   ")

        println("testPalindrome2: $testPalindrome2")

        val testPalindrome3 = "Kayak".isPalindrome()

        // Une Classe commence toujours pas une majuscule
        // Un objet (une instance) ou un méthode commence toujours par une minuscule

        val credential1 = Credential("admin@admin.com", "12345678", 12)
        credential1.login //Ok
        credential1.validityDuration // Ok
        //credential1.password // Not ok

        credential1.validityDuration = 300

        credential1.displayPassword()

    }

    // kayak = kayak
    // radar = radar
    // Kayak
    fun isPalindrome(word: String): Boolean {
        if(word.trim().isEmpty()) return false

        val reversedWord = word.reversed()
        return reversedWord.toLowerCase()==word.toLowerCase()
    }

}
