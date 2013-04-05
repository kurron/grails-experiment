package org.kurron.domain

class Lesson {

    static constraints = {
    }

    static hasMany = [units: Unit]

    String title
}
