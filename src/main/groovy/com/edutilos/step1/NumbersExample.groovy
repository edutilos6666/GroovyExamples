package com.edutilos.step1


class NumbersExample {
   void example1() {
       byte n0 = 10
       short n01 = 10
       int n1 = 10
       long n2 = 10L
       float n3 = 10F
       double n4 = 10D
       BigInteger n5 = 10G
       BigDecimal n6 = 10.0G


       String str = """${n0.class.name} => $n0
${n01.class.name} => $n01
${n1.class.name} => $n1
${n2.class.name} => $n2
${n3.class.name} => $n3
${n4.class.name} => $n4 
${n5.class.name} => $n5 
${n6.class.name} => $n6
"""
       println str
   }


    void example2() {
        double a = 1.3
        double ceil = Math.ceil(a)
        double floor = Math.floor(a)
        long round =  Math.round(a)
        double rint = Math.rint(a)
        double abs = Math.abs(a)
        double pow = Math.pow(10, 2)
        double exp = Math.exp(10)
        double log  = Math.log(10)
        double log1p = Math.log1p(10)
        double log10 = Math.log10(10)
        double sqrt = Math.sqrt(100)
        double angle = Math.PI / 3
        double sin = Math.sin(angle)
        double cos = Math.cos(angle)
        double tan = Math.tan(angle)
        double asin = Math.asin(sin)
        double acos = Math.acos(cos)
        double atan = Math.atan(tan)
        double atan2 = Math.atan2(tan, tan)

        String str = """ceil = $ceil
floor = $floor 
round = $round 
rint = $rint 
abs = $abs 
pow = $pow 
exp = $exp
log = $log 
log1p = $log1p
log10 = $log10
sqrt = $sqrt 
sin = $sin 
cos = $cos 
tan = $tan
asin = $asin 
acos = $acos 
atan = $atan 
atan2 = $atan2 
"""
        println str
    }
}
