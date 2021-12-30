package com.tripp.asm;

import org.objectweb.asm.ClassWriter;
import static org.objectweb.asm.Opcodes.*;

public class WriteVisitor {
    public static class MyClassLoader extends ClassLoader {
        public Class<?> defineClass(String name, byte[] bytes) {
            return defineClass(name, bytes, 0, bytes.length);
        }
    }
    public static void main(String[] args) {
        ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(V1_5, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE, "pkg/Comparable", null, "java/lang/Object", null);
        classWriter.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I", null, -1).visitEnd();
        classWriter.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();

        classWriter.visitEnd();

        byte[] bytes = classWriter.toByteArray();

        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> c = myClassLoader.defineClass("pkg.Comparable", bytes);
        System.out.println(c.getMethods()[0].getName());

    }
}
