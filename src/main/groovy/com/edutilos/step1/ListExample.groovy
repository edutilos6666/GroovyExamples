package com.edutilos.step1



class ListExample {
    void example1() {
        def numbers= [1, 2, 3]
        numbers.add 4 
        numbers.add 5 
        numbers.plus([6, 7])
        println("numbers = $numbers")
        boolean contains4 = numbers.contains 4
        boolean contains10 = numbers.contains 10
        boolean isEmpty = numbers.isEmpty()
        List<Integer> reverse = numbers.reverse()
        println("numbers = $numbers")
        List<Integer> sort = numbers.sort()
        println("sort = $sort")
        int size =  numbers.size()
        List<Integer> minus = numbers.minus([1, 2])
        List<Integer> plus = numbers.plus([10, 11])
        int pop = numbers.pop()
        println("contains4 = $contains4")
        println("contains10 = $contains10")
        println("isEmpty = $isEmpty")
        println("reverse = $reverse")
        println("sort = $sort")
        println("size = $size")
        println("minus = $minus")
        println("plus = $plus")
        println("pop = $pop")
        println("numbers after pop = $numbers")

    }
}
