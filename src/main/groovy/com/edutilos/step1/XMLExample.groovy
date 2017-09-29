package com.edutilos.step1

import groovy.transform.Canonical
import groovy.xml.MarkupBuilder

class XMLExample {

    //MarkupBuilder
    void example1()  {
        def stringWriter = new StringWriter()
        def workers = generateData()
        def builder = new MarkupBuilder(stringWriter)
        builder.Workers {
            workers.each {w ->
                builder.Worker("id": w.id) {
                    Name(w.name)
                    Age(w.age)
                    Wage(w.wage)
                    Active(w.active)
                }
            }
        }


        File f = new File("Workers.xml")
        f.withWriter {writer ->
            writer.write(stringWriter.toString())
        }

        println stringWriter.toString()

    }


    //XmlParser
    void example2() {
        def parser = new XmlParser()
        def doc = parser.parse("Workers.xml")
        doc.Worker.each { worker ->
            long id = worker["@id"].toLong()
            String name = worker.Name[0].text()
            int age = worker.Age[0].text().toInteger()
            double wage = worker.Wage[0].text().toDouble()
            boolean active = worker.Active[0].text().toBoolean()
            println("id = $id")
            println("name = $name")
            println("age = $age")
            println("wage = $wage")
            println("active = $active")
            println()
        }

    }



    private List<WorkerXML> generateData() {
        [
                new WorkerXML(1,"foo",10, 100.0, true),
                new WorkerXML(2, "bar", 20, 200.0, false),
                new WorkerXML(3, "bim", 30, 300.0, true),
                new WorkerXML(4, "pako", 40, 400.0, false)
        ]
    }


    @Canonical
    class WorkerXML {
        long id
        String name
        int age
        double wage
        boolean active


        @Override
        String toString()  {
            "$id,$name,$age,$wage,$active"
        }
    }
}
