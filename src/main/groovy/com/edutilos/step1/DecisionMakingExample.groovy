package com.edutilos.step1


class DecisionMakingExample {
    //if else if else
    void example1() {
        def age = 15
        def name = "foo"
        if(age > 0 && age < 10) {
            prinf("%s is a kid.\n", name)
        } else if(age >= 10 && age < 20) {
            printf("%s is a teenager.\n", name)
        } else if(age >= 20 && age < 60) {
            printf("%s is an elderly.\n", name)
        } else {
            printf("%s is too old.\n", name)
        }
    }


    //switch
    void example2() {
        def age = 15
        def name = "foo"
        switch(age) {
            case 0..9:
                printf("%s is a kid.\n", name)
                break
            case 10..19:
                printf("%s is a teenager.\n", name)
                break
            case 20..59:
                printf("%s is an elderly.\n", name)
                break
            default:
                printf("%s is too old.\n", name)
        }

        println()
        switch(name) {
            case "foo":
            case "bar":
            case "bim":
                println("Your name is known to the system.")
                break
            default:
                println("Your name is unknown to the system.")
        }
    }
}
