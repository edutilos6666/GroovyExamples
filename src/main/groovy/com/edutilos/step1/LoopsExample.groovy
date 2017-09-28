package com.edutilos.step1


class LoopsExample {
    //while loop
    void example1()  {
        int i = 0
        while(i < 10 ) {
            printf("number = %d\n", i)
            i++
        }

        println()
    }


    //for loop
    void example2() {
        for(int i=0; i< 10; ++i) {
            printf("number = %d\n", i)
        }
        println()
    }

    //for in loop
    void example3() {
        def names = ["foo", "bar", "bim", "pako"]
        for(def name in names) {
            printf("name = %s\n", name)
        }
        println()
        for(def age in 18..30) {
            printf("age = %d\n", age)
        }
        println()

        def props = ["foo":10 , "bar":20, "bim":30]
        for(def prop in props) {
            printf("%s => %d\n", prop.key, prop.value)
        }
        println()
    }

    //continue and break keyword
    void example4() {
        for(int i = 0; i< 10 ; ++i) {
            if(i == 4) continue
            if(i == 8) break
            printf("number = %d\n", i)
        }
    }


    //nested for loop
    void example5() {
        int [][] numbers = [
                [1, 2, 3, 4, 5] ,
                [6, 7, 8, 9, 10],
                [11, 12, 13, 14, 15],
                [16, 17, 18, 19, 20]
        ]

        for(int i=0; i< numbers.length; ++i) {
            for(int j=0; j< numbers[i].length; ++j) {
                printf("%d ; ", numbers[i][j])
            }
            println()
        }
    }
}
