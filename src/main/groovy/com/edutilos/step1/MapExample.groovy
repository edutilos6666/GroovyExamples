package com.edutilos.step1


class MapExample {
    void example1() {
        def props = ["foo": 10 , "bar": 20, "bim": 30, "edu": 40]
        Set<String> keySet = props.keySet()
        Collection<Integer> values = props.values()
        int  getFoo = props.get("foo", 0)
        int getPako0 = props.get("pako0", 0)
        boolean containsKeyFoo = props.containsKey("foo")
        boolean containsKeyPako = props.containsKey("pako")
        boolean containsValue10 = props.containsValue(10)
        boolean containsValue100 = props.containsValue(100)
        int size = props.size()

        props.forEach {k, v ->
            println "$k => $v"
        }
        println()
        println("keySet = $keySet")
        println("values = $values")
        println("getFoo = $getFoo")
        println("getPako0 = $getPako0")
        println("containsKeyFoo = $containsKeyFoo")
        println("containsKeyPako = $containsKeyPako")
        println("containsValue10 = $containsValue10")
        println("containsValue100 = $containsValue100")
        println("size = $size")

    }
}
