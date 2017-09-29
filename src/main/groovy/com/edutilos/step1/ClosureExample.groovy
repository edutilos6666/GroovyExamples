package com.edutilos.step1


class ClosureExample {
   void example1() {
       def cloAdd = {n1, n2 ->
           n1 + n2
       }

       Closure cloSub = {n1, n2 ->
           n1 - n2
       }

       Closure cloMul = {n1, n2 ->
           n1 * n2
       }

       Closure cloDiv = {n1, n2 ->
           n1 / n2
       }


       double n1 = 10 , n2 = 3
       double resAdd = cloAdd.call(n1, n2)
       double resSub = cloSub(n1, n2)
       double resMul = cloMul(n1, n2)
       double resDiv = cloDiv(n1 , n2)

       println """$n1 + $n2 = $resAdd
$n1 - $n2 = $resSub
$n1 * $n2 = $resMul
$n1 / $n2 = $resDiv 
"""

   }



    void example2() {
        Closure complexClosure = {double n1,double n2, cloAdd, cloSub, cloMul , cloDiv ->
            double resAdd = cloAdd(n1, n2)
            double resSub = cloSub(n1, n2)
            double resMul = cloMul(n1, n2)
            double resDiv = cloDiv(n1, n2)
            println """$n1 + $n2 = $resAdd
$n1 - $n2 = $resSub 
$n1 * $n2 = $resMul
$n1 / $n2 = $resDiv
"""
        }


        complexClosure(10, 3, {x, y -> x +y}, {x, y-> x -y},
                {x, y-> x * y}, {x, y-> x / y})


        Closure printer = {id, name, age, wage, active ->
            println """id = $id
name = $name 
age = $age
wage = $wage
active = $active
"""
        }

        printer(1, "foo", 10, 100.0, true)

    }


    void example3() {
        def numbers = [10, 20, 30, 40, 50]
        numbers.each {n->
            printf("%d ; ", n)
        }
        println()

        def props = ["foo": true, "bar": false, "bim": true]
        props.each {k, v->
            println("$k => $v")
        }
        println()

        def find = numbers.find {n -> n > 10}
        def findAll = numbers.findAll {n-> n > 10 }
        def any = numbers.any {n -> n > 10 }
        def every = numbers.every {n->  n > 10}
        def collect = numbers.collect {n -> Math.pow(n , 3)}

        println("find = $find")
        println("findAll = $findAll")
        println("any = $any")
        println("every = $every")
        println("collect = $collect")
    }
}
