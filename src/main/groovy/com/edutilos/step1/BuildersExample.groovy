package com.edutilos.step1

import groovy.swing.SwingBuilder
import groovy.transform.Canonical

import javax.swing.*
import java.awt.GridLayout

import groovy.xml.DOMBuilder
import groovy.json.JsonBuilder
import groovy.util.NodeBuilder
import groovy.util.FileTreeBuilder

class BuildersExample {


    //FileTreeBuilder
    void example6() {
        def tmpDir = File.createTempDir()
        def builder = new FileTreeBuilder(tmpDir)
        builder.dir("src") {
            dir("main") {
                dir("groovy") {
                    file("Example1.txt", "Example1: hello world!")
                    file("Example2.txt", "Example2: hello world!")
                }
            }
        }

        def baseDir = tmpDir.getAbsolutePath() + "/src/main/groovy/"
        def file1 = new File(baseDir +"Example1.txt")
        println file1.text
        def file2 = new File(baseDir + "Example2.txt")
        println file2.text
    }

    //node builder
    void example5() {
        NodeBuilder builder = new NodeBuilder()
        def people = builder.people {
            person(id: 1, name: "foo", age:10 , wage: 100.0, active:true)
            person(id: 2, name: "bar", age: 20, wage: 200.0, active:false)
            person(id:3 , name: "bim", age: 30, wage: 300.0, active: true)
        }

        println people
    }

    //json builder
    void example4() {
        def builder = new JsonBuilder()
        def root = builder.People {
            "Person1" {
                Id 1
                Name("foo")
                Age 10
                Wage 100.0
                Active true
                Activities(["Reading", "Writing"])
            }

            "Person2" {
                Id 2
                Name("bar")
                Age 20
                Wage 200.0
                Active false
                Activities(["Speaking", "Listening", "Reading"])
            }
        }

        println(builder.toString())



        root = builder([
               new Person(1, "foo", 10, 100.0, true),
                new Person(2, "bar", 20, 200.0, false)
        ])

        println builder.toString()



        def data = [
                new Person(1, "foo", 10, 100.0, true),
                new Person(2, "bar", 20, 200.0, false)
        ]
        root = builder data , {Person person-> name person.name }

        println builder.toString()
    }


    //dom builder
    void example3() {
        def listPeople = generateData()
        def str = """<People>
"""
        listPeople.each {person ->
            def part = """<Person id = "${person.id}">
<Name>${person.name}</Name>
<Age>${person.age}</Age>
<Wage>${person.wage}</Wage>
<Active>${person.active}</Active>
</Person>
"""
            str += part
        }

        str += """</People>"""

//        println str
        def rd = new StringReader(str)
        def doc = DOMBuilder.parse(rd)
//        println doc
        def people =  doc.getElementsByTagName("Person")
        people.each {person->
            println convertXmlFragmentToPerson(person)
        }

    }

    private Person convertXmlFragmentToPerson(def fragment) {
        long id = fragment.getAttribute("id").toLong()
        String name = fragment.getElementsByTagName("Name").item(0).getTextContent()
        int age = fragment.getElementsByTagName("Age").item(0).getTextContent().toInteger()
        double wage = fragment.getElementsByTagName("Wage").item(0).getTextContent().toDouble()
        boolean active = fragment.getElementsByTagName("Active").item(0).getTextContent().toBoolean()

        new Person(id, name, age, wage, active)
    }

    private List<Person> generateData()  {
        [
                new Person(1, "foo", 10, 100.0, true),
                new Person(2, "bar", 20, 200.0, false),
                new Person(3, "bim", 30, 300.0, true)
        ]
    }


    //swing builder
    void example2() {
        def app = new SwingBuilder()
        def fieldId, fieldName, fieldAge, fieldWage, fieldActive
        def btnOk , btnClear

        def mainPanel = {
            app.panel (layout: new GridLayout(7, 2, 1, 1)) {
                //title
                lblEmpty = label(text: "")
                lblTitle = label(text: "Simple Form Example")
                //id
                lblId = label(text: "Id:")
                fieldId = textField()
                //name
                lblName = label(text: "Name: ")
                fieldName = textField()
                //age
                lblAge = label(text: "Age: ")
                fieldAge = textField()
                //wage
                lblWage = label(text:"Wage: ")
                fieldWage = textField()
                //active
                lblActive = label(text: "Active: ")
                fieldActive = textField()
                //buttons
                btnOk = button(text: "Ok")
                btnClear = button(text: "Clear")
            }
        }


        def frame = app.frame(
                title: "Simple Form Example",
                location: [10, 10],
                size: [500, 500],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
        ) {
             mainPanel()
        }

        btnOk.addActionListener { event->
            try {
                String msg = """
id = ${fieldId.text.toLong()}
name = ${fieldName.text}
age = ${fieldAge.text.toInteger()}
wage = ${fieldWage.text.toDouble()}
active = ${fieldActive.text.toBoolean()}
"""
                String title = "<<Information>>"
                JOptionPane.showMessageDialog(frame, msg, title, JOptionPane.INFORMATION_MESSAGE)
            } catch(Exception ex) {
                String msg = ex.message
                String title = "<<Error>>"
                JOptionPane.showMessageDialog(frame, msg, title, JOptionPane.ERROR_MESSAGE)
            }

        }

        btnClear.addActionListener {event ->
            fieldId.text = ""
            fieldName.text =  ""
            fieldAge.text = ""
            fieldWage.text = ""
            fieldActive.text = ""
        }

        frame.setVisible true
    }

    //swing builder
    void example1() {
        def app = new SwingBuilder()
        def fieldId, fieldName, fieldAge, fieldWage, fieldActive
        def btnOk , btnClear
        def frame = app.frame(
                title: "Simple Form Example",
                location: [10, 10],
                size: [500, 500],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
        ) {
            panel (layout: new GridLayout(7, 2, 1, 1)) {
                //title
                lblEmpty = label(text: "")
                lblTitle = label(text: "Simple Form Example")
                //id
                lblId = label(text: "Id:")
                fieldId = textField()
                //name
                lblName = label(text: "Name: ")
                fieldName = textField()
                //age
                lblAge = label(text: "Age: ")
                fieldAge = textField()
                //wage
                lblWage = label(text:"Wage: ")
                fieldWage = textField()
                //active
                lblActive = label(text: "Active: ")
                fieldActive = textField()
                //buttons
                btnOk = button(text: "Ok")
                btnClear = button(text: "Clear")
            }
        }

        btnOk.addActionListener { event->
            try {
                String msg = """
id = ${fieldId.text.toLong()}
name = ${fieldName.text}
age = ${fieldAge.text.toInteger()}
wage = ${fieldWage.text.toDouble()}
active = ${fieldActive.text.toBoolean()}
"""
                String title = "<<Information>>"
                JOptionPane.showMessageDialog(frame, msg, title, JOptionPane.INFORMATION_MESSAGE)
            } catch(Exception ex) {
                String msg = ex.message
                String title = "<<Error>>"
                JOptionPane.showMessageDialog(frame, msg, title, JOptionPane.ERROR_MESSAGE)
            }

        }

        btnClear.addActionListener {event ->
            fieldId.text = ""
            fieldName.text =  ""
            fieldAge.text = ""
            fieldWage.text = ""
            fieldActive.text = ""
        }

        frame.setVisible true
    }




    @Canonical
    private class Person {
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
