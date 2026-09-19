package com.example.soal2

import javax.swing.text.StyledEditorKit

class Enemy (
    var type: String,
    var damage: Int,
    var health: Int,
    var maxhp : Int
)

fun main() {

    var enemies = ArrayList<Enemy>()
    enemies.add(Enemy("Fire", 10, 50, 50))
    enemies.add(Enemy("Water", 10, 50, 50))
    enemies.add(Enemy("Grass", 10, 50, 50))

    var hp: Int = 50
    var mana: Int = 30
    var kill: Int = 0
    var mPot: Int = 5
    var hPot: Int = 5
    var lifesteal: Int = 0
    var damage: Int = 10

    var maxhp: Int = 50
    var maxmana: Int = 30


    var active: Boolean = true

    while (active) {

        print("What's your name?: ")
        var playerName = readln()

        var alive: Boolean = true

        while (alive) {
            println("Good luck, $playerName! You're gonna need it!")
            println("What are you going to do?")
            println("1. View Stats")
            println("2. Enter Battle")


            try {
                print("Option: ")
                var choices = readln().toInt()

                if (choices == 1) {

                    var option1: Boolean = true

                    while (option1) {
                        println("----- $playerName's STATS -----")
                        println("HP: $hp / $maxhp")
                        println("Mana: $mana / $maxmana")
                        println("Kills need to Evolve: $kill / 5")
                        println("Mana Potion Held: $mPot")
                        println("Health Potion Held: $hPot")
                        println("Lifesteal: $lifesteal")
                        println("-------------------------------")
                        println("a. Drink Mana Potion")
                        println("b. Drink Health Potion")
                        println("c. Rename Self")
                        println("d. Back")
                        print("Option: ")
                        var choices1 = readln()

                        if (choices1 == "a") {
                            if (maxhp - hp >= 25) {
                                hp = hp + 25
                                hPot = hPot - 1
                            } else {
                                hp = maxhp
                                hPot = hPot - 1
                            }

                        } else if (choices1 == "b") {

                            if (maxmana - mana >= 15) {
                                mana = mana + 15
                                mPot = mPot - 1
                            } else {
                                mana = maxmana
                                mPot = mPot - 1
                            }

                        } else if (choices1 == "c") {

                            print("Rename Your Self: ")
                            var newName = readln()
                            playerName = newName

                        } else if (choices1 == "d") {
                            option1 = false
                        }
                    }
                } else if (choices == 2) {

                    var option2 : Boolean = true
                    val angka = (0..2).random()

                    if (kill == 5){
                        damage = 15
                        maxmana = 45
                        maxhp = 75
                        mana = maxmana
                        hp = maxhp
                    }



                    enemies[0].health = 50
                    enemies[1].health = 50
                    enemies[2].health = 50


                    while (option2){

                        println("----- BATTLE -----")
                        println("$playerName")
                        println("HP: $hp / $maxhp")
                        println("Mana: $mana / $maxmana")
                        println("Mana Potion Held: $mPot")
                        println("Health Potion Held: $hPot")

                        println()
                        println("${enemies[angka].type} Mon")
                        println("HP: ${enemies[angka].health} / ${enemies[angka].maxhp}")
                        println("Type: ${enemies[angka].type}")
                        println("------------------")
                        println("a. Fire Attack")
                        println("b. Water Attack")
                        println("c. Grass Attack")
                        println("d. Drink Potion")
                        println("e. Run")
                        print("Option: ")
                        var choices3 = readln()

                        if (choices3 == "a") {

                            if (mana < 10){
                                println("You Dont Have Any Mana Left")
                            } else{

                                if (enemies[angka].type == "Grass"){
                                    enemies[angka].health = enemies[angka].health - (damage*2)
                                    mana = mana - 10

                                    if (kill >= 5){
                                        hp = hp + lifesteal
                                    }

                                    if (enemies[angka].health <= 0){
                                        println("Enemy Defeated")
                                        kill = kill + 1
                                        if (kill >= 5){
                                            lifesteal = lifesteal + 1
                                        }
                                        break
                                    }
                                } else {
                                    enemies[angka].health = enemies[angka].health - damage
                                    mana = mana - 10
                                    if (kill >= 5){
                                        hp = hp + lifesteal
                                    }

                                    if (enemies[angka].health <= 0){
                                        println("Enemy Defeated")
                                        kill = kill + 1
                                        if (kill > 5){
                                            lifesteal = lifesteal + 1
                                        }
                                        break
                                    }
                                }


                                hp = hp - enemies[angka].damage

                                if (hp <= 0){
                                    println("YOU LOSE")
                                    option2 = false
                                    alive = false
                                }

                            }



                        } else if (choices3 == "b") {

                            if (mana < 10){
                                println("You Dont Have Any Mana Left")
                            } else {

                                if (enemies[angka].type == "Fire") {
                                    enemies[angka].health = enemies[angka].health - (damage * 2)
                                    mana = mana - 10
                                    if (kill >= 5) {
                                        hp = hp + lifesteal
                                    }

                                    if (enemies[angka].health <= 0) {
                                        println("Enemy Defeated")
                                        kill = kill + 1
                                        if (kill > 5) {
                                            lifesteal = lifesteal + 1
                                        }
                                        break
                                    }
                                } else {
                                    enemies[angka].health = enemies[angka].health - damage
                                    mana = mana - 10
                                    if (kill >= 5) {
                                        hp = hp + lifesteal
                                    }

                                    if (enemies[angka].health <= 0) {
                                        println("Enemy Defeated")
                                        kill = kill + 1
                                        if (kill > 5) {
                                            lifesteal = lifesteal + 1
                                        }
                                        break
                                    }
                                }


                                hp = hp - enemies[angka].damage

                                if (hp <= 0) {
                                    println("YOU LOSE")
                                    option2 = false
                                    alive = false
                                }
                            }

                        } else if (choices3 == "c") {

                            if (mana < 10){
                                println("You Dont Have Any Mana Left")
                            } else {

                                if (enemies[angka].type == "Water") {
                                    enemies[angka].health = enemies[angka].health - (damage * 2)
                                    mana = mana - 10
                                    if (kill >= 5) {
                                        hp = hp + lifesteal
                                    }

                                    if (enemies[angka].health <= 0) {
                                        println("Enemy Defeated")
                                        kill = kill + 1
                                        if (kill > 5) {
                                            lifesteal = lifesteal + 1
                                        }
                                        break
                                    }
                                } else {
                                    enemies[angka].health = enemies[angka].health - damage
                                    mana = mana - 10
                                    if (kill >= 5) {
                                        hp = hp + lifesteal
                                    }

                                    if (enemies[angka].health <= 0) {
                                        println("Enemy Defeated")
                                        kill = kill + 1
                                        if (kill > 5) {
                                            lifesteal = lifesteal + 1
                                        }
                                        break
                                    }
                                }


                                hp = hp - enemies[angka].damage

                                if (hp <= 0) {
                                    println("YOU LOSE")
                                    option2 = false
                                    alive = false
                                }
                            }

                        } else if (choices3 == "d") {

                            println("----- Potion -----")
                            println("Mana Potion Held: $mPot")
                            println("Health Potion Held: $hPot")
                            println("-------------------")
                            println("a. Mana Pot")
                            println("b. Health Pot")
                            println("c. back")
                            print("Option: ")
                            var choices4 = readln()

                            if (choices4 == "a"){

                                if (maxmana - mana >= 15) {
                                    mana = mana + 15
                                    mPot = mPot - 1
                                } else {
                                    mana = maxmana
                                    mPot = mPot - 1
                                }

                            } else if (choices4 == "b"){

                                if (maxhp - hp >= 25) {
                                    hp = hp + 25
                                    hPot = hPot - 1
                                } else {
                                    hp = maxhp
                                    hPot = hPot - 1
                                }

                            } else if (choices4 == "c"){
                                println("Back to Battle")
                            }

                        } else if (choices3 == "e"){
                            option2 = false
                        }

                    }

                } else {
                    println("Pilihan Tidak Sesuai")
                }
            } catch (e: NumberFormatException) {
                println("Pilihan Harus Berupa Angka!")
            }

        }
    }
}