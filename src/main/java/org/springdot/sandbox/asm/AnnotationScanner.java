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

    static class AnnotationMethodsScanner extends AnnotationVisitor{

        static class AnnotationMethodsArrayValueScanner extends AnnotationVisitor{
            AnnotationMethodsArrayValueScanner(){ super(Opcodes.ASM4); }

            @Override
            public void visit(String name, Object value){
                System.out.println("Ar.visit: value="+value);
                super.visit(name, value);
            }
        }

        AnnotationMethodsScanner(){ super(Opcodes.ASM4); }

        @Override
        public void visitEnum(String name, String desc, String value){
            System.out.println("A.visitEnum: name="+name+" desc="+desc+" value="+value);
            super.visitEnum(name, desc, value);
        }

        @Override
        public AnnotationVisitor visitAnnotation(String name, String desc){
            System.out.println("A.visitAnnotation: name="+name+" desc="+desc);
            return super.visitAnnotation(name, desc);
        }

        @Override
        public AnnotationVisitor visitArray(String name){
            return new AnnotationMethodsArrayValueScanner();
        }
    }

    static class FieldAnnotationScanner extends FieldVisitor{
        FieldAnnotationScanner(){ super(Opcodes.ASM4); }

        @Override
        public AnnotationVisitor visitAnnotation(String desc, boolean visible){
            System.out.println("F.visitAnnotation: desc="+desc);
            return new AnnotationMethodsScanner();
        }
    }

    static class MethodAnnotationScanner extends MethodVisitor{
        MethodAnnotationScanner(){ super(Opcodes.ASM4); }

        @Override
        public AnnotationVisitor visitAnnotation(String desc, boolean visible){
            System.out.println("M.visitAnnotation: desc="+desc);
            return super.visitAnnotation(desc, visible);
        }
    }

    public AnnotationScanner(int api){
        super(api);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible){
        System.out.println("\nvisitAnnotation: desc="+desc);
        return new AnnotationMethodsScanner();
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value){
        System.out.println("\nvisitField: name="+name+" desc="+desc);
        return new FieldAnnotationScanner();
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions){
        System.out.println("\nvisitMethod: name="+name+" desc="+desc);
        return new MethodAnnotationScanner();
    }

    public static void main(String[] args) throws Exception{
        for (String arg : args){
            FileInputStream in = new FileInputStream(new File(arg));
            ClassReader cr = new ClassReader(in);
            cr.accept(new AnnotationScanner(Opcodes.ASM4),0);
        }
    }
}
