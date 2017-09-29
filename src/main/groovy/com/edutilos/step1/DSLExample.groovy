package com.edutilos.step1

import groovy.transform.Canonical


class DSLExample {

    void example1() {
        def res  = EmailDSL.make {
            from "foo.bar@gmail.com"
            to "foo.bar@yahoo.com"
            title "testing groovy dsl"
            body """<h1>Heading1</h1>
       <h2>Heading2</h2>
       <h3>Heading3</h3>
       <h4>Heading4</h4>
       <h5>Heading5</h5>
       <h6>Heading6</h6>
"""
        }

        println res
    }


    @Canonical
    private static class EmailDSL {
        String fromText
        String toText
        String titleText
        String bodyText

        def static make(Closure clo) {
            EmailDSL instance = new EmailDSL()
            clo.delegate = instance
            clo()
            instance
        }

        def from (String fromText) {
            this.fromText = fromText
        }
        def to (String toText) {
            this.toText = toText
        }

        def title(String titleText) {
            this.titleText = titleText
        }

        def body(String bodyText) {
            this.bodyText = bodyText
        }

        @Override
        String toString() {
            """from = $fromText
to = $toText 
title = $titleText
body = $bodyText
"""
        }
    }
}
