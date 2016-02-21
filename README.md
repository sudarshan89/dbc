Design By Contract for Java
===

![Badge](https://img.shields.io/shippable/5507a66a5ab6cc1352a0fe1d.svg)

A design by contract library for Java, leveraging the Bean Validation API.

What is design by contract ?

*Design By Contract (DbC) is a software correctness methodology. It uses preconditions and postconditions to document (or programmatically assert) the change in state caused by a piece of a program.*

What Wikipedia says about Design by Contract ?

> Similarly, if a routine from a class in object-oriented programming provides a certain functionality, it may:

> Expect a certain condition to be guaranteed on entry by any client module that calls it: the routine's precondition—an obligation for the client, and a benefit for the supplier (the routine itself), as it frees it from having to handle cases outside of the precondition.

> Guarantee a certain property on exit: the routine's postcondition—an obligation for the supplier, and obviously a benefit (the main benefit of calling the routine) for the client.

> Maintain a certain property, assumed on entry and guaranteed on exit: the class invariant.

> The contract is semantically equivalent to a Hoare triple which formalises the obligations. This can be summarised by the "three questions" that the designer must repeatedly answer in the contract:

> What does contract expect?
> What does contract guarantee?
> What does contract maintain?

> Many programming languages have facilities to make assertions like these. However, DbC considers these contracts to be so crucial to software correctness that they should be part of the design process. In effect, DbC advocates writing the assertions first. Contracts can be written by code comments, enforced by a test suite, or both, even if there is no special language support for contracts.

---

We have a few DbC libraries in the Java eco system already, Broadly they work based on Byte code instrumentation or AOP, but i could not find any which are compliant with the Bean Validation API.

All of them are a tricky to get started with, especially integrating it with a webapp built of out maven. 
For the AOP based libraries we need to include aspectj jars and that brings with it additional complexity.

The short comings in these libraries has prompted me to think about rolling out a simple library which leverages the Bean Validation API and provides helper methods to implement the DbC paradigm.

Desirable features of the proposed library.


* Leverage on the Bean Validation API
* Simple to add in to brown field projects
* Simple API with limited automagic

Central to this library is the Contract class.

![Contract class](http://4.bp.blogspot.com/-y93DNCviqT8/Uj8lDPOfpAI/AAAAAAAAA0A/Xoz-SyqLUIY/s1600/diagram.png)

* The over loaded requires method are meant to check the pre conditions
    > Preconditions specify conditions that must be true before a method can execute. These conditions can be imposed upon the arguments passed into the method or upon the state of the called class itself. Preconditions impose obligations on the client of the method; if the conditions are not met, it is a bug in the client.
* The over loaded ensures methods are meant to check the post conditions 
    > Postconditions specify conditions that must be true when a method is finished executing. These conditions can involve the current class state, the class state as it was before the method was called, the method arguments, and the method return value. Postconditions impose obligations on the method; if the conditions are not met, it is a bug in the method.
* The overloaded checkInvariants methods are meant to check if the class invariants are in tact.
    > Invariants specify conditions that must be true of a class whenever it is accessible to a client (specifically when the class has finished loading and whenever its methods are called).


Refer to the [test class](https://github.com/sudarshan89/dbc/blob/master/src/test/java/com/nthdimenzion/ShoppingCartTest.java) to understand API usage.

