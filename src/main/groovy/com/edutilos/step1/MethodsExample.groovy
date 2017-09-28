package com.edutilos.step1


class MethodsExample {
    //default parameters example
    void example1()  {
        printProps()
        printProps(1, "new bar", 10, 100.0, true)
    }

    //closure example
    void example2() {
        def cloAdd =  {double x, double y -> return x + y}
        def cloSub = {x, y -> x -y}
        def cloMul = {x, y -> x * y}
        def cloDiv = {x, y -> x /y}

        applyClosure(10.0, 3.0,
                  cloAdd , cloSub, cloMul, cloDiv)

        println()
        applyClosure(10.0, 3.0,
                {x,y -> x + y},
                {x, y -> x - y },
                {x, y -> x * y},
                {x, y -> x /y})


        println()
        applyClosure2(10.0, 3.0, {x+y}, {x-y}, {x*y}, {x/y})

    }

    private void applyClosure(double x, double y,
                              Closure cloAdd, cloSub, cloMul, cloDiv) {
        double resAdd = cloAdd(x, y)
        double resSub = cloSub(x, y)
        double resMul = cloMul(x, y)
        double resDiv = cloDiv(x, y)
        printf("x = %.2f, y = %.2f\n", x, y)
        printf("x + y = %.2f\n", resAdd)
        printf("x - y = %.2f\n", resSub)
        printf("x * y = %.2f\n", resMul)
        printf("x / y = %.2f\n", resDiv)
    }

    private void applyClosure2(double x, double y,
                              Closure cloAdd, cloSub, cloMul, cloDiv) {
        def data = [x:x , y:y]
        cloAdd.delegate = data
        cloSub.delegate = data
        cloMul.delegate = data
        cloDiv.delegate = data
        printf("x = %.2f, y = %.2f\n", x, y)
        printf("x + y = %.2f\n", cloAdd())
        printf("x - y = %.2f\n", cloSub())
        printf("x * y = %.2f\n", cloMul())
        printf("x / y = %.2f\n", cloDiv())
    }


    private void printProps(long id = 0, String name = "", int age = 0,
                            double wage = 0.0, boolean active = false) {
        println("<<Properties>>")
        printf("id = %d\n", id)
        printf("name = %s\n", name)
        printf("age = %d\n", age)
        printf("wage = %.2f\n", wage)
        printf("active = %s\n", active)
        println()
    }
}
