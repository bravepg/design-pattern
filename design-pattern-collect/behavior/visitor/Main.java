package behavior.visitor;

interface Visitor {
    void visitCpu(ComputerPart computerPart);
    void visitMemory(ComputerPart computerPart);
}

abstract class ComputerPart {
    abstract void accept(Visitor visitor);
    abstract double getPrice();
}

class Cpu extends ComputerPart {

    @Override
    void accept(Visitor visitor) {
        visitor.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 200;
    }
}

class Memory extends ComputerPart {

    @Override
    void accept(Visitor visitor) {
        visitor.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class StudentVisitor implements Visitor {
    public int totalPrize;

    @Override
    public void visitCpu(ComputerPart computerPart) {
        totalPrize += computerPart.getPrice() * 0.5;
    }

    @Override
    public void visitMemory(ComputerPart computerPart) {
        totalPrize += computerPart.getPrice() * 0.5;
    }
}


public class Main {
    Cpu cpu = new Cpu();
    Memory memory = new Memory();

    public void accept(Visitor visitor) {
        cpu.accept(visitor);
        memory.accept(visitor);
    }
    public static void main(String[] args) {
        StudentVisitor studentVisitor = new StudentVisitor();
        new Main().accept(studentVisitor);
        System.out.println(studentVisitor.totalPrize);
    }
}