package com.example.goldyfly.models

class Account {
    var name:String = ""
    var email:String = ""
    var plate:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, email: String, plate: String,imageUrl: String, id: String) {
        this.name = name
        this.email = email
        this.plate= plate
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}