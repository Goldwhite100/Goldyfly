package com.example.goldyfly.models

class Book {

    var name:String = ""
    var currentlocation:String = ""
    var phone:String = ""
    var destination:String = ""
    var date:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, currentlocation: String,phone: String,destination: String,date: String,  imageUrl: String, id: String) {
        this.name = name
        this.currentlocation = currentlocation
        this.destination = destination
        this.date = date
        this.phone = phone
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}