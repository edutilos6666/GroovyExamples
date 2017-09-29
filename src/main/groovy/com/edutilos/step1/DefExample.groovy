package com.edutilos.step1

import groovy.transform.Canonical

class DefExample {

    void example1() {
        def x = 10.0 , y = 3.0
        def sm = new SimpleMath(x, y)
        def resAdd = sm.add()
        def resSub = sm.sub()
        def resMul = sm.mul()
        def resDiv = sm.div()

        def str = """$x + $y = $resAdd 
$x - $y = $resSub 
$x * $y = $resMul 
$x / $y = $resDiv
"""
        println str
    }

    @Canonical
    private class SimpleMath {
        double x
        double y

        double add() {
            x +y
        }

        double sub() {
            x -y
        }

        double mul() {
            x * y
        }
        double div() {
            x /  y
        }
    }
}
