package com.edutilos.step1

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor


@ToString
@TupleConstructor
@EqualsAndHashCode
//we could use @Canonical instead of above 3 annotations
class ComplexNumber {
   double re
   double im

   ComplexNumber add(ComplexNumber other) {
       ComplexNumber ret = new ComplexNumber()
       ret.re  = this.re + other.re
       ret.im = this.im + other.im
       ret
   }

   ComplexNumber sub(ComplexNumber other) {
       ComplexNumber ret = new ComplexNumber()
       ret.re = this.re - other.re
       ret.im = this.im - other.im
       ret
   }

    ComplexNumber mul(ComplexNumber other) {
        ComplexNumber ret = new ComplexNumber()
        ret.re = this.re*other.re - this.im*other.im
        ret.im = this.re*other.im + this.im*other.re
        ret
    }

    ComplexNumber mulByFactor(double factor) {
        ComplexNumber ret = new ComplexNumber()
        ret.re = this.re * factor
        ret.im = this.im * factor
        ret
    }

    ComplexNumber divByFactor(double factor) {
        ComplexNumber ret = new ComplexNumber()
        ret.re = this.re / factor
        ret.im = this.im / factor
        ret
    }

    ComplexNumber div(ComplexNumber other) {
        ComplexNumber ret = new ComplexNumber()
        double factor = Math.pow(other.re,2) + Math.pow(other.im, 2)
        ComplexNumber temp = new ComplexNumber(other.re, -other.im)
        ret = this.mul(temp)
        ret = ret.divByFactor(factor)
        ret
    }

    @Override
    String toString() {
        String.format("%.2f + i*(%.2f)", re, im)
    }

}
