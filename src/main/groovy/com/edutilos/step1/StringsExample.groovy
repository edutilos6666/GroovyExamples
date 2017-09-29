package com.edutilos.step1


class StringsExample {
    void example1() {
        String str1 = "foo", str2 = "bar"
        String str3 = str1 + " " + str2
        String str4 = str1 * 3
        int compareTo = str1.compareTo str1.toUpperCase()
        int compareToIgnoreCase = str1.compareToIgnoreCase str1.toUpperCase()

        boolean startsWith = str3.startsWith str1
        boolean endsWith = str3.endsWith str2
        String str3Reversed = str3.reverse()
        String previous = str3.previous()
        String next = previous.next()
        String substring  = str3.substring 0 , 3


        String str = """str1 = $str1 
str2 = $str2
str3 = $str3
str4 = $str4
compareTo = $compareTo
compareToIgnoreCase = $compareToIgnoreCase
startsWith = $startsWith
endsWith = $endsWith
str3Reversed = $str3Reversed
previous = $previous
next = $next 
substring = $substring"""


        println str
        println("<<eachMatch()>>")
        str3.eachMatch("foo") {regex->
            println regex
        }



        String upper = str3.toUpperCase()
        String lower = str3.toLowerCase()
        println "upper = $upper"
        println "lower = $lower"


    }
}
