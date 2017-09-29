package com.edutilos.step1



class RangeExample {
    void example1() {
        //inclusive range
        Range<Integer> inclusive = 1..10
        Integer from = inclusive.getFrom()
        Integer to = inclusive.getTo()
        boolean isInclusive = inclusive.getInclusive()
        Integer get = inclusive.get(3)
        boolean contains3 = inclusive.contains 3
        boolean contains11 = inclusive.contains 11

        println("""from = $from
to = $to
isInclusive = $isInclusive
get(3) = $get
contains3 = $contains3
contains11 = $contains11
""")

        inclusive.forEach {n ->
            printf "%d ; ", n
        }
        println()

        printf("subList(1, 4) = %s\n", inclusive.subList(1, 4).toString())
        printf("subList(4, 9) = %s\n", inclusive.subList(4, 9).toString())

    }

    void example2() {
        //exclusive range
        Range<Integer> exclusive = 1..<10
        Integer from = exclusive.getFrom()
        Integer to = exclusive.getTo()
        boolean isInclusive = exclusive.getInclusive()
        Integer get = exclusive.get(3)
        boolean contains3 = exclusive.contains 3
        boolean contains11 = exclusive.contains 11

        println("""from = $from
to = $to
isInclusive = $isInclusive
get(3) = $get
contains3 = $contains3
contains11 = $contains11
""")

        exclusive.forEach {n ->
            printf "%d ; ", n
        }
        println()

        printf("subList(1, 4) = %s\n", exclusive.subList(1, 4).toString())
        printf("subList(4, 9) = %s\n", exclusive.subList(4, 9).toString())
    }

}
