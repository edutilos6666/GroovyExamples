package com.edutilos.step1

import java.io.BufferedReader
import java.io.InputStreamReader

class OperatorsExample {
   static class ArithmeticOps {
       void example1() {
           def n1 = 10.0, n2 = 3.0
           def resAdd = n1 + n2
           def resSub = n1 - n2
           def resMul = n1 * n2
           def resDiv = n1 / n2
           def resMod = n1.toInteger() % n2.toInteger()
           def resInc1 = n1++
           def resInc2 = ++n1
           def resDec1 = n1--
           def resDec2 = --n1
           printf("n1 = %.2f, n2 = %.2f\n", n1, n2)
           printf("n1 + n2 = %.2f\n", resAdd)
           printf("n1 - n2 = %.2f\n", resSub)
           printf("n1 * n2 = %.2f\n", resMul)
           printf("n1 / n2 = %.2f\n", resDiv)
           printf("n1 %% n2 = %d\n", resMod)
           printf("n1++ = %.2f\n", resInc1)
           printf("++n1 = %.2f\n", resInc2)
           printf("n1-- = %.2f\n", resDec1)
           printf("--n1 = %.2f\n", resDec2)
       }
   }

    static class RelationalOps {
        void example1() {
            double n1 = 10.0, n2 = 3.0
            boolean eq = (n1 == n2)
            boolean ne = (n1 != n2)
            boolean gt = (n1 > n2)
            boolean ge = (n1 >= n2)
            boolean lt = (n1 < n2)
            boolean le = (n1 <= n2)
            printf("n1 = %.2f, n2 = %.2f\n", n1, n2)
            printf("n1 == n2 = %s\n", eq)
            printf("n1 != n2 = %s\n", ne)
            printf("n1 > n2 = %s\n", gt)
            printf("n1 >= n2 %s\n", ge)
            printf("n1 < n2 = %s\n", lt)
            printf("n1 <= n2 = %s\n", le)
        }
    }


    static class LogicalOps  {
        void example1() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
            long id
            String name
            int age
            double wage
            boolean active
            println("Insert your id: ")
            id = reader.readLine().toLong()
            println("Insert your name: ")
            name = reader.readLine().toString()
            println("Insert your age: ")
            age = reader.readLine().toInteger()
            println("Insert your wage: ")
            wage = reader.readLine().toDouble()
            println("Insert whether you are active: ")
            active = reader.readLine().toBoolean()
            println("<<Your inputs>>")
            printf("id = %d\n", id)
            printf("name = %s\n", name)
            printf("age = %d\n", age)
            printf("wage = %.2f\n", wage)
            printf("active = %s\n", active)

            boolean ageFilter = (age > 18) && (age < 60)
            boolean wageFilter = (wage >= 100.0) && (wage <= 1000.0)
            boolean admin = (id == 1) && (name.equals("foo")) && ageFilter && wageFilter && active
            boolean user = (id == 2) && (name.equals("bar")) && ageFilter && wageFilter && active
            boolean passiveUser = (id == 3) && (name.equals("bim")) && ageFilter && wageFilter && !active
            if(admin || user || passiveUser) {
                println("Login succeeded.")
            } else {
                println("Login failed.")
            }
        }
    }


}
