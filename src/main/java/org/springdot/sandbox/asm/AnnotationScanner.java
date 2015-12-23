package org.springdot.sandbox.asm;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileInputStream;

public class AnnotationScanner extends ClassVisitor{

    public AnnotationScanner(int api){
        super(api);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible){
        System.out.println("visitAnnotation: desc="+desc+" visible="+visible);
        return super.visitAnnotation(desc,visible);
    }

    @Override
    public void visitAttribute(Attribute attr){
        System.out.println("visitAttribute: attr="+attr);
        super.visitAttribute(attr);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value){
        System.out.println("visitField: access="+access+" name="+name+" desc="+desc+" signature="+signature+" value="+value);
        return super.visitField(access,name,desc,signature,value);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions){
        System.out.println("visitMethod: access="+access+" name="+name+" desc="+desc+" signature="+signature+" exceptions="+exceptions);
        return super.visitMethod(access,name,desc,signature,exceptions);
    }

    public static void main(String[] args) throws Exception{
        for (String arg : args){
            FileInputStream in = new FileInputStream(new File(arg));
            ClassReader cr = new ClassReader(in);
            cr.accept(new AnnotationScanner(Opcodes.ASM4),0);
        }
    }
}
