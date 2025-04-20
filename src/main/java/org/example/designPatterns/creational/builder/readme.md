    The Builder Design Pattern is a creational pattern used in software design to construct a 
    complex object step by step. It allows the construction of a product in a step-by-step manner, 
    where the construction process can change based on the type of product being built. 
    This pattern separates the construction of a complex object from its representation, 
    allowing the same construction process to create different representations.


    The important part is that you don’t need to call all of the steps. You can call 
    only those steps that are necessary for producing a particular configuration of an object.

    Pros 
    You can construct objects step-by-step, defer construction steps or run steps recursively.
    You can reuse the same construction code when building various representations of products.
    Single Responsibility Principle. You can isolate complex construction code from the business logic of the product.

    Cons
    The overall complexity of the code increases since the pattern requires creating multiple new classes.
