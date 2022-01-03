package structure.composite;

import java.util.ArrayList;
import java.util.List;

interface Node {
    void p();
}

class LeafNode implements Node {
    public String name;
    public LeafNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(this.name);
    }
}

class BranchNode implements Node {
    public String name;
    public List<Node> nodes = new ArrayList<>();
    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(this.name);
    }

    public void add(Node node) {
        nodes.add(node);
    }
}

public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");

        LeafNode leaf1 = new LeafNode("leaf1");
        LeafNode leaf2 = new LeafNode("leaf2");
        LeafNode leaf3 = new LeafNode("leaf3");
        LeafNode leaf4 = new LeafNode("leaf4");

        root.add(chapter1);
        root.add(chapter2);

        chapter1.add(leaf1);
        chapter1.add(leaf2);

        chapter2.add(leaf3);
        chapter2.add(leaf4);

        visitNode(root, 0);
    }

    private static void visitNode(Node node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        node.p();

        if (node instanceof BranchNode) {
            for (Node node1: ((BranchNode) node).nodes) {
                visitNode(node1, depth + 1);
            }
        }
    }
}
