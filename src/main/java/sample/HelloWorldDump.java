package sample;

import lsieun.classfile.ClassFile;
import lsieun.vs.ClassFileRawVisitor;
import lsieun.vs.Visitor;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.RecordComponentVisitor;

public class HelloWorldDump implements Opcodes {
    public static byte[] dump() throws Exception {

        ClassWriter classWriter = new ClassWriter(0);
        FieldVisitor fieldVisitor;
        RecordComponentVisitor recordComponentVisitor;
        MethodVisitor methodVisitor;
        AnnotationVisitor annotationVisitor0;

        classWriter.visit(V1_8, ACC_PUBLIC | ACC_SUPER, "sample/HelloWorld", null, "sample/SuperClass", null);

        classWriter.visitSource("HelloWorld.java", null);

        {
            fieldVisitor = classWriter.visitField(ACC_PRIVATE | ACC_FINAL | ACC_STATIC, "intValue", "I", null, new Integer(10));
            fieldVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(4, label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "sample/SuperClass", "<init>", "()V", false);
            methodVisitor.visitInsn(RETURN);
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLocalVariable("this", "Lsample/HelloWorld;", null, label0, label1, 0);
            methodVisitor.visitMaxs(1, 1);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "GuineaPig", "()V", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(8, label0);
            methodVisitor.visitInsn(ICONST_1);
            methodVisitor.visitVarInsn(ISTORE, 1);
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(9, label1);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitVarInsn(ISTORE, 2);
            Label label2 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(10, label2);
            methodVisitor.visitVarInsn(ILOAD, 1);
            Label label3 = new Label();
            methodVisitor.visitJumpInsn(IFLE, label3);
            Label label4 = new Label();
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLineNumber(12, label4);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitVarInsn(ISTORE, 3);
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLineNumber(14, label3);
            methodVisitor.visitFrame(Opcodes.F_APPEND, 2, new Object[]{Opcodes.INTEGER, Opcodes.INTEGER}, 0, null);
            methodVisitor.visitInsn(ICONST_0);
            methodVisitor.visitVarInsn(ISTORE, 3);
            Label label5 = new Label();
            methodVisitor.visitLabel(label5);
            methodVisitor.visitLineNumber(15, label5);
            methodVisitor.visitInsn(RETURN);
            Label label6 = new Label();
            methodVisitor.visitLabel(label6);
            methodVisitor.visitLocalVariable("this", "Lsample/HelloWorld;", null, label0, label6, 0);
            methodVisitor.visitLocalVariable("i", "I", null, label1, label6, 1);
            methodVisitor.visitLocalVariable("j", "I", null, label2, label6, 2);
            methodVisitor.visitLocalVariable("l", "I", null, label5, label6, 3);
            methodVisitor.visitMaxs(1, 4);
            methodVisitor.visitEnd();
        }
        classWriter.visitEnd();

        return classWriter.toByteArray();
    }

    public static void main(String[] args) {
        try {
            byte[] bytes = dump();
            // 第三步，处理数据
            ClassFile classfile = ClassFile.parse(bytes);
            // 可以使用 ClassFileRawVisitor、ClassFileSimpleVisitor 或者 ClassFileStandardVisitor
            Visitor v = new ClassFileRawVisitor();
            classfile.accept(v);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
