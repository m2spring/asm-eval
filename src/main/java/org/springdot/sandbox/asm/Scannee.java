package org.springdot.sandbox.asm;

@MyClass(name="annotation scanner", number=MyEnum.TWO, values={"abc","def"})
public class Scannee{

    @MyField(name="a string field")
    public String aStringField;

    @MyMethod(name="a method")
    public void aMethod(){}
}
