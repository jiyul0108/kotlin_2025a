package com.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        //week02Variables()
        //week02Functions()
        week03Classes()
        //week03Collections()
    }
}

private fun week03Collections(){
    println("== kotlin Collections ==")

    val fruits = listOf("apple","banana","orange")
    val mutableFruits = mutableListOf("kiwi","wetermelon")

    //fruits.add("kiwi")
    println("Fruits : $fruits")
    mutableFruits.add("banana")
    println("mutable Fruits : $mutableFruits")

    val scores = mapOf("kim" to 100, "Park" to 97, "Lee" to 99)
    println("Scores : $scores")

    for(fruit in mutableFruits){
        println("I like $fruit")
    }

    scores.forEach{(name, score) -> println("$name scores $score")}
}

private fun week03Classes(){
    Log.d("kotlinWeek03", "== kotlin Classes ==")

    class Person(val name: String, var age: Int){
        fun introduce(){
            Log.d("kotlinWeek03", "안녕하세요, $name ($age 세)입니다")
        }
        fun birthday(){
            age++
            Log.d("kotlinWeek03", "$name 의 생일! 이제 ($age 세)입니다")
        }
    }
    val person1 = Person("홍길동", 27)
    person1.introduce()
    person1.birthday()

    open class Animal(var species: String){
        var weight: Double = 0.0
        constructor(species: String, weight: Double) : this(species){
            this.weight
            Log.d("kotlinWeek03", "$species 의 무게 : $weight kg")
        }
        fun makeSound(){
            Log.d("kotlinWeek03","$species 가 소리를 냅니다")
        }

        open fun makeSount() {}
    }
    val puppy = Animal("강아지",10.5)
    puppy.makeSound()

    class Dog(species: String, weight: Double, val breed: String) : Animal(species, weight){
        override fun makeSount(){
            Log.d("kotlinWeek03", "$breed($species)가 멍멍 짖습니다!")
        }
    }

    val dog = Dog("개", 12.5, "골든리트리버")
    dog.makeSount()

    data class Book(val title: String, val author: String, val pages: Int)

    val book1 = Book("코틀린 입문", "kim", 400)
    val book2 = Book("코틀린 입문", "kim", 400)

    Log.d("kotlinWeek03","book1 == book2: ${book1 == book2}")
    Log.d("kotlinWeek03","book1: $book1")
}

private fun week02Functions(){
//    println("Week 02: Functions")
//
//    fun greet(name: String) = "Hello, $name!"
//
//    println(greet("Android developer"))

    println("== kotlin Functions ==")

    fun greet(name: String): String {
        return "Hello, $name!"
    }

    fun add(a: Int, b: Int) = a + b

    fun introduce(name: String, age: Int = 20){
        println("My name is $name and I'm $age years old")
    }

    println(greet("kotlin"))
    println("sum: ${add(5,-71)}")
    introduce("kim", 7)
    introduce("Park")

}

private fun week02Variables(){
//    println("Week 02: variables")
//
//    val courseName = "Mobile Programing"
//    //courseName = "IOT Programing"
//    var week = 1
//    week = 2
//    println("Course : $courseName")
//    println("Week : $week")

    println("== kotlin Variables ==")

    // val(immutable) vs var(mutable)
    val name = "Android"
    var version = 8

    println("Hello $name $version")

    val age: Int = 24
    val height: Double = 177.7
    val isStudent: Boolean = true

    println("Age: $age, Height: $height, student: $isStudent")

//    var nickname: String = null
    var nickname: String? = null
    nickname = "mirae"
    println("Nickname: $nickname ${nickname?.length}")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsTheme {
        Greeting("Android")
    }
}