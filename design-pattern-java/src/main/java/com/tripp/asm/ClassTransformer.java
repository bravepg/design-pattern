package com.tripp.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import static org.objectweb.asm.Opcodes.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class ClassTransformer {
    public static void main(String[] args) throws IOException {
        ClassReader classReader = new ClassReader(Objects.requireNonNull(ClassTransformer.class.getClassLoader().getResourceAsStream("com/tripp/asm/Tank.class")));

        ClassWriter classWriter = new ClassWriter(0);

        // 责任链模式
        ClassVisitor classVisitor = new ClassVisitor(ASM4, classWriter) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);

                return new MethodVisitor(ASM4, methodVisitor) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC, "TimeProxy", "before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };

        classReader.accept(classVisitor, 0);

        byte[] bytes = classWriter.toByteArray();

        String path = (String) System.getProperties().get("user.dir");
        
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path + "com/tripp/asm/Tank_0.class"));
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
