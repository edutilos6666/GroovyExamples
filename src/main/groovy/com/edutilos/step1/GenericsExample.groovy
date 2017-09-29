package com.edutilos.step1

import groovy.transform.Canonical


class GenericsExample {

    void example1() {
        GenericsWorker<Long, String , Integer, Double, Boolean> w1
        GenericsWorker<String, String, String, String, String> w2
        w1 = new GenericsWorker<>(1, "foo", 10, 100.0, true)
        w2 = new GenericsWorker<>("2", "bar", "20", "200.0", "false")
        println w1.toString()
        println w2.toString()
    }

    void example2() {
        printProps(1, "foo", 10, 100.0, true)
        println()
        printProps("2", "bar", "20", "200.0", "false")
    }

    private <T1, T2, T3, T4, T5> void printProps(T1 id , T2 name, T3 age, T4 wage, T5 active) {
        println """id = $id
name = $name 
age = $age 
wage = $wage 
active = $active 
"""
    }




  @Canonical
  private class GenericsWorker<T1, T2, T3, T4, T5> {
      T1 id
      T2 name
      T3 age
      T4 wage
      T5 active

      @Override
      String toString() {
          "GenericWorker($id, $name, $age, $wage, $active)"
      }
  }
}
