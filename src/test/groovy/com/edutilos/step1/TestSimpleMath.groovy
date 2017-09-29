package com.edutilos.step1

import org.junit.BeforeClass


class TestSimpleMath extends GroovyTestCase{
    private SimpleMath sm
    private double x , y

    @BeforeClass
    void setUp() {
        sm = new SimpleMath()
        x = 10
        y = 3
    }

    void testAdd() {
        def resAdd = sm.add(x, y)
        assertEquals(13.0, resAdd, 0.0)
    }

    void testSub()  {
        def resSub = sm.sub(x, y)
        assertEquals(7.0, resSub, 0.0)
    }

    void testMul() {
        def resMul = sm.mul(x, y)
        assertEquals(30.0, resMul, 0.0)
    }

    void testDiv() {
        def resDiv = sm.div(x, y)
        assertEquals(3.3, resDiv, 0.1)
    }

}
