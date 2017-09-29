package com.edutilos.step1

import groovy.text.SimpleTemplateEngine
import groovy.text.StreamingTemplateEngine
import groovy.text.XmlTemplateEngine

class TemplateEngineExample {


    void example4() {
            def text = '''<Person id = "$id">
<Name>$name</Name>
<Age>$age</Age>
<Wage>$wage</Wage>
<Active>$active</Active>
</Person>
'''
            def engine = new XmlTemplateEngine()
            def template = engine.createTemplate(text)
            def binding = ["id": 1, "name": "foo",
                           age: 10, wage: 100.0, active: true]
            def writable = template.make(binding)

            println writable
        }


    //StreamingTemplateEngine
    void example3() {
        def text = '''<Person id = <% out.print id %>>
<Name>$name</Name>
<Age>$age</Age>
<Wage>$wage</Wage>
<Active>$active</Active>
</Person>
'''
        def engine = new StreamingTemplateEngine()
        def template = engine.createTemplate(text)
        def binding = ["id": 1, "name": "foo",
                       age: 10, wage: 100.0, active: true]
        def writable = template.make(binding)

        println writable
    }



    void example2() {
        File f = new File("Person.xml")
        def text = '''<Person id = $id>
<Name>$name</Name>
<Age>$age</Age>
<Wage>$wage</Wage>
<Active>$active</Active>
</Person>
'''

        f.withWriter {writer ->
            writer.write text
        }

        f = new File("Person.xml")

        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(f)
        def binding = [id : 2, name : "bar", age: 20,
        wage :200.0, active: false]
        def writable = template.make(binding)
        println writable
    }

     void example1() {
         def text = '''<Person id = $id>
<Name>$name</Name>
<Age>$age</Age>
<Wage>$wage</Wage>
<Active>$active</Active>
</Person>
'''
         def engine = new SimpleTemplateEngine()
         def template = engine.createTemplate(text)
         def binding = ["id": 1, "name": "foo",
         age: 10, wage: 100.0, active: true]
         def writable = template.make(binding)

         println writable
     }
}
