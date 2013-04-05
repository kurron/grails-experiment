package org.kurron.domain

class Instructor {

    static constraints = {
    }

    static hasMany = [lessons: Lesson]

    String firstName
    String lastName
}
