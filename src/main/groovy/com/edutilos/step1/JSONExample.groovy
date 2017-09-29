package com.edutilos.step1


import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import groovy.transform.Canonical

class JSONExample {


    //JsonParser
    void example2() {
        List<WorkerJson> workers = [
                new WorkerJson(1, "foo", 10, 100.0, true),
                new WorkerJson(2, "bar", 20, 200.0, false),
                new WorkerJson(3, "bim", 30, 300.0, true),
                new WorkerJson(4, "pako", 40, 400.0, false)
        ]

        String generated = JsonOutput.toJson(workers)
        File f = new File("Workers.json")
        f.withWriter {writer ->
            writer.write generated
        }
    }

    //JsonSlurper
    void example1() {
        def jsonSlurper = new JsonSlurper()
        def workers = jsonSlurper.parseText(generateJsonData())
        println("<<all workers>>")
        workers.each {worker ->
            println convertMapToWorker(worker)
        }

        println()

        def data = "[10, 20, 30, 40,50]"
        def numbers = jsonSlurper.parseText(data)
        println("numbers = ${numbers.join("; ")}")

        data = """
{
"id": 1 , 
"name": "foo", 
"age": 10, 
"wage": 100.0, 
"active": true
}
"""
        def props = jsonSlurper.parseText(data)
        println("<<props>>")
        props.each {k, v ->
            println "$k => $v"
        }
        println()
    }


    private WorkerJson convertMapToWorker(Map<String, Object> props) {
        WorkerJson ret = new WorkerJson()
        ret.id = props["id"].toLong()
        ret.name = props["name"]
        ret.age = props["age"].toInteger()
        ret.wage = props["wage"].toDouble()
        ret.active = props["active"].toBoolean()
        ret
    }

    private String generateJsonData() {
        List<WorkerJson> workers = [
                new WorkerJson(1, "foo", 10, 100.0, true),
                new WorkerJson(2, "bar", 20, 200.0, false),
                new WorkerJson(3, "bim", 30, 300.0, true),
                new WorkerJson(4, "pako", 40, 400.0, false)
        ]


        JsonOutput.toJson(workers)
    }


    @Canonical
    private class WorkerJson {
        long id
        String name
        int age
        double wage
        boolean active

        @Override
        String toString() {
            "$id,$name,$age,$wage,$active"
        }
    }
}
