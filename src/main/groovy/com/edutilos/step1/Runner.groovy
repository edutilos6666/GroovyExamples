package com.edutilos.step1


class Runner {
    static void main(String[] args) {
//        testComplexNumber()
//        testInterfaceExample()
//        testInheritanceExample()
//        testOperatorsExample()
//        testLoopsExample()
//        testDecisionMakingExample()
//        testMethodsExample()
//        testFileIOExample()
//        testDefExample()
//        testNumbersExample()
//        testStringsExample()
//        testRangeExample()
//        testListExample()
//        testMapExample()
//        testDateTimeExample()
        testGenericsExample()
    }



    private static void testGenericsExample() {
        GenericsExample runner = new GenericsExample()
        runner.example1()
        println()
        runner.example2()
    }

    private static void testDateTimeExample() {
        DateTimeExample runner = new DateTimeExample()
//        runner.example1()
        runner.example2()
    }

    private static void testMapExample() {
        MapExample runner = new MapExample()
        runner.example1()
    }

    private static void testListExample() {
        ListExample runner = new ListExample()
        runner.example1()
    }


    private static void testRangeExample() {
        RangeExample runner = new RangeExample()
//        runner.example1()
        runner.example2()
    }

    private static void testStringsExample() {
        StringsExample runner = new StringsExample()
        runner.example1()
    }

    private static void testNumbersExample() {
        NumbersExample runner = new NumbersExample()
//        runner.example1()
        runner.example2()
    }


    private static void testDefExample()  {
        def runner = new DefExample()
        runner.example1()
    }


    private static void testFileIOExample() {
        FileIOExample runner = new FileIOExample()
//        runner.example1()
//        runner.example2()
//        runner.example3()
//        runner.example4()
        runner.example5()
    }

    private static void testMethodsExample() {
        MethodsExample runner = new MethodsExample()
//        runner.example1()
        runner.example2()
    }

    private static void testDecisionMakingExample() {
        DecisionMakingExample runner = new DecisionMakingExample()
//        runner.example1()
        runner.example2()
    }

    private static void testLoopsExample() {
        LoopsExample runner = new LoopsExample()
//        runner.example1()
//        runner.example2()
//        runner.example3()
//        runner.example4()
        runner.example5()
    }

    private static void testOperatorsExample() {
        OperatorsExample.ArithmeticOps arithmeticOps = new OperatorsExample.ArithmeticOps()
//        arithmeticOps.example1()
        OperatorsExample.RelationalOps relationalOps = new OperatorsExample.RelationalOps()
//        relationalOps.example1()
        OperatorsExample.LogicalOps logicalOps = new OperatorsExample.LogicalOps()
        logicalOps.example1()
    }


    private static void testInheritanceExample() {
        InheritanceExample.Shape s1, s2 , s3
        s1 =  new InheritanceExample.Triangle(8, 9, 10)
        s2 = new InheritanceExample.Rectangle(10, 20)
        s3 = new InheritanceExample.Circle(10)
        printf("<<infos on %s>>\n", s1.toString())
        printf("perimeter = %.2f\n", s1.perimeter())
        printf("area = %.2f\n", s1.area())
        println()
        printf("<<infos on %s>>\n", s2.toString())
        printf("perimeter = %.2f\n", s2.perimeter())
        printf("area = %.2f\n", s2.area())
        println()
        printf("<<infos on %s>>\n", s3.toString())
        printf("perimeter = %.2f\n", s3.perimeter())
        printf("area = %.2f\n", s3.area())
        println()
    }

    private static void testInterfaceExample() {
        InterfaceExample.CustomFile cf1 , cf2, cf3, cf4
        cf1 = new InterfaceExample.CustomFile("foo.read")
        cf2 = new InterfaceExample.CustomFile("foo.write")
        cf3 = new InterfaceExample.CustomFile("foo.exe")
        cf4 = new InterfaceExample.CustomFile("foo.read.write.exe")
        printf("<<infos on %s>>\n", cf1.filename)
        printf("%s is readable = %s\n", cf1.filename, cf1.isReadable())
        printf("%s is writable = %s\n", cf1.filename, cf1.isWritable())
        printf("%s is executable = %s\n", cf1.filename, cf1.isExecutable())
        cf1.read()
        cf1.write()
        cf1.execute()

        println()
        printf("<<infos on %s>>\n", cf2.filename)
        printf("%s is readable = %s\n", cf2.filename, cf2.isReadable())
        printf("%s is writable = %s\n", cf2.filename, cf2.isWritable())
        printf("%s is executable = %s\n", cf2.filename, cf2.isExecutable())
        cf2.read()
        cf2.write()
        cf2.execute()
        println()

        printf("<<infos on %s>>\n", cf3.filename)
        printf("%s is readable = %s\n", cf3.filename, cf3.isReadable())
        printf("%s is writable = %s\n", cf3.filename, cf3.isWritable())
        printf("%s is executable = %s\n", cf3.filename, cf3.isExecutable())
        cf3.read()
        cf3.write()
        cf3.execute()
        println()

        printf("<<infos on %s>>\n", cf4.filename)
        printf("%s is readable = %s\n", cf4.filename, cf4.isReadable())
        printf("%s is writable = %s\n", cf4.filename, cf4.isWritable())
        printf("%s is executable = %s\n", cf4.filename, cf4.isExecutable())
        cf4.read()
        cf4.write()
        cf4.execute()
        println()
    }

    private static void testComplexNumber() {
        ComplexNumber cn1, cn2;
        cn1 = new ComplexNumber(3, 3)
        cn2 = new ComplexNumber(2, 2)
        def cnAdd = cn1.add(cn2)
        def cnSub = cn1.sub(cn2)
        def cnMul = cn1.mul(cn2)
        def cnDiv = cn1.div(cn2)
        printf("cn1 = %s\n", cn1.toString())
        printf("cn2 = %s\n", cn2.toString())
        printf("cn1 + cn2 = %s\n", cnAdd.toString())
        printf("cn1 - cn2 = %s\n", cnSub.toString())
        printf("cn1 * cn2 = %s\n", cnMul.toString())
        printf("cn1 / cn2 = %s\n", cnDiv.toString())
    }

}
