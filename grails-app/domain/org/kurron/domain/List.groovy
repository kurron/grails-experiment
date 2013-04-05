package org.kurron.domain

class List {

    static constraints = {
    }

    static hasMany = [cards: Card]

    String name
}
