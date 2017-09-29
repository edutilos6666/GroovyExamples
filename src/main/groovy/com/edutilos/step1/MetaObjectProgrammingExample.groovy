package com.edutilos.step1



class MetaObjectProgrammingExample {


    //methodMissing
    void example3() {
        MyClazz3 clazz = new MyClazz3()
        clazz.sayHello("foo", 10, 100.0)
    }



    //meta class
    void example2() {
        MyClazz2 clazz = new MyClazz2()
        println("name = ${clazz.name}")
        println("age = ${clazz.age}")

        clazz.metaClass.setAttribute(clazz , "name", "foo")
        clazz.metaClass.setAttribute(clazz, "age", 10)
        println("name = ${clazz.name}")
        println("age = ${clazz.age}")
    }



    void example1() {
        MyClazz clazz = new MyClazz()
        clazz.name = "foo"
        clazz.age = 10
        println("name = ${clazz.name}")
        println("age = ${clazz.age}")
        println clazz.sayHello("foo", "bar", 10)
    }



}



class MyClazz3  {

    def methodMissing(String name, def args) {
        println "methodMissing for $name with args: $args"
    }
}

class MyClazz2 {
    private String name = "bar"
    private int age = 20

    String getName() {
        name
    }

    int getAge() {
        age
    }
}


class MyClazz implements GroovyInterceptable {
    protected dynamicProps = [:]
    void setProperty(String name, value) {
        dynamicProps[name] = value
    }
    def getProperty(String name) {
        dynamicProps[name]
    }

    def invokeMethod(String name, args) {
        return  "called method: $name with args: $args"
    }
}