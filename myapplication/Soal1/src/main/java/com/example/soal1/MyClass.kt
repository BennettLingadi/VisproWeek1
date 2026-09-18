package com.example.soal1

class Menu(
    var name: String,
    var description: String,
    var price: Int
)

class Orderitems(
    var menu: Menu,
    var jumlah: Int
)

class Order(
    var namaPembeli: String
){
    var items = ArrayList<Orderitems>()
}

fun main() {

    var active: Boolean = true
    val menuList = ArrayList<Menu>()
    val orderList = ArrayList<Order>()

    menuList.add(Menu("Nasi Goreng", "Nasi Goreng Merah dengan Ayam Suwir", 20000))
    menuList.add(Menu("Mie Goreng", "Mie Goreng Jawa Pedas", 25000))


    while (active){
        println("Order System")
        println("1. Make Orders")
        println("2. View Orders")
        println("3. View Menu")
        println("4. Add Menu")
        println("5. Edit Menu")
        println("6. Delete Menu")
        println("7. Exit")

        while (true){
            try {
                print("Pilihan: ")
                val pil = readln().toInt()

                if (pil == 1){

                    print("Nama Pembeli: ")
                    var namaPembeli = readln()

                    var order = Order(namaPembeli)

                    while (true) {

                        var tampung: Int = 1

                        for (menu in menuList){
                            println("$tampung. ${menu.name} | ${menu.description} | ${menu.price}")
                            tampung++
                        }

                        print("Pilih Menu: ")
                        var pilihanMenu = readln().toInt()

                        print("Jumlah: ")
                        var jumlah = readln().toInt()

                        var item = Orderitems(menuList[pilihanMenu - 1], jumlah)

                        order.items.add(item)

                        var total : Int = 0
                        total = total + (jumlah * item.menu.price)

                        print("Tambah menu lagi? (y/n): ")
                        var lagi = readln()

                        if (lagi == "n") {
                            println("total: $total")
                            break
                        }
                    }

                    orderList.add(order)

                    break


                } else if (pil == 2){

                    for (order in orderList) {
                        println("${order.namaPembeli}'s ORDER")

                        for (item in order.items) {
                            println("- ${item.menu.name} x${item.jumlah}")
                        }

                        println("----------------")
                    }

                    break

                } else if (pil == 3){

                    var tampung: Int = 1
                    for (menu in menuList){
                        println("$tampung. ${menu.name} | ${menu.description} | ${menu.price}")
                        tampung++
                    }

                    break

                } else if (pil == 4){

                    println("Add Menu: ")
                    print("Nama Menu: ")
                    var namaBaru = readln()
                    print("Deskripsi Menu: ")
                    var deskBaru = readln()
                    print("Harga Menu: ")
                    var hargaBaru = readln().toInt()

                    menuList.add(Menu(namaBaru, deskBaru, hargaBaru))

                    break

                } else if (pil == 5){


                    var tampung: Int = 1
                    for (menu in menuList){
                        println("$tampung. ${menu.name} | ${menu.description} | ${menu.price}")
                        tampung++
                    }
                    print("Pilih Menu yang mau di Edit: ")
                    var choice = readln().toInt()

                    choice = choice - 1

                    print("Edited Name: ")
                    var namaEdit = readln()
                    print("Edited Description: ")
                    var deskEdit = readln()
                    print("Edited Price: ")
                    var hargaEdit = readln().toInt()

                    menuList[choice].name = namaEdit
                    menuList[choice].description = deskEdit
                    menuList[choice].price = hargaEdit

                    break

                } else if (pil == 6){

                    var tampung: Int = 1
                    for (menu in menuList){
                        println("$tampung. ${menu.name} | ${menu.description} | ${menu.price}")
                        tampung++
                    }
                    print("Pilih Menu yang mau di Delete: ")
                    var choice = readln().toInt()

                    choice = choice - 1

                    menuList.removeAt(choice)

                    break

                } else if (pil == 7){
                    active = false
                    break
                } else {
                    println("Pilihan Tidak Sesuai!")
                }

            } catch (e: NumberFormatException){
                println("Pilihan Harus Berupa Angka!")
            }
        }


    }


}