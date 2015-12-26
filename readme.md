# Playing with [ASM bytecode library](http://asm.ow2.org/)

## build

```
$ mvn clean package
```

## run

```
$ ./run.sh

visitAnnotation: desc=Lorg/springdot/sandbox/asm/MyClass;
A.visitEnum: name=number desc=Lorg/springdot/sandbox/asm/MyEnum; value=TWO
Ar.visit: value=abc
Ar.visit: value=def

visitField: name=aStringField desc=Ljava/lang/String;
F.visitAnnotation: desc=Lorg/springdot/sandbox/asm/MyField;

visitMethod: name=<init> desc=()V

visitMethod: name=aMethod desc=()V
M.visitAnnotation: desc=Lorg/springdot/sandbox/asm/MyMethod;
```
