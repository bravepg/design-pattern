package com.tripp.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM4;

import java.io.IOException;
import java.util.Objects;

public class Visitor extends ClassVisitor {

    public Visitor() {
        super(ASM4);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println(name + " extends " + superName + " {");
    }

    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        System.out.println("    " + name);
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        System.out.println("    " + name + "()");
        return null;
    }

    public void visitEnd() {
        System.out.println("}");
    }


    public static void main(String[] args) throws IOException {
        // ClassReader classReader = new ClassReader("java.lang.Runnable");
        ClassReader classReader = new ClassReader(Objects.requireNonNull(Visitor.class.getClassLoader().getResourceAsStream("com/tripp/asm/Visitor.class")));
        classReader.accept(new Visitor(), 0);
    }
}
