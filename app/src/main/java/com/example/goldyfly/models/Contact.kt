package com.example.goldyfly.models

class Contact {

    var name:String = ""
    var description:String = ""
    var id:String = ""
    var userId:String = ""

    constructor(name: String, description: String, id: String, userId: String) {
        this.name = name
        this.description = description
        this.id = id
        this.userId = userId
    }

    constructor()
}