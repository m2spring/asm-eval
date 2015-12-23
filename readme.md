# Playing with [ASM bytecode library](http://asm.ow2.org/)

## build

```
$ mvn clean package
```

## run

```
$ ./run.sh
visitAnnotation: desc=Lorg/springdot/sandbox/asm/MyClass; visible=true
visitField: access=1 name=aStringField desc=Ljava/lang/String; signature=null value=null
visitMethod: access=1 name=<init> desc=()V signature=null exceptions=null
visitMethod: access=1 name=aMethod desc=()V signature=null exceptions=null
```
