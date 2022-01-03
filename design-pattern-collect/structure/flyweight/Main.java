package structure.flyweight;

import java.util.ArrayList;
import java.util.List;

interface Tree {
    void plant(int x, int y);
}

class TreeFactory {
    static List<TreeType> treeTypes = new ArrayList<>();

    public static TreeType getTreeType(String name, String color) {
        for (TreeType treeType : treeTypes) {
            if (treeType.getName() == name && treeType.getColor() == color) {
                return treeType;
            }
        }
        TreeType newTreeType = new TreeType(name, color);
        treeTypes.add(newTreeType);
        return newTreeType;
    }
}

class TreeType implements Tree {
    private String name;
    private String color;

    public TreeType(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
      return name;
    }

    public String getColor() {
      return color;
    }

    @Override
    public void plant(int x, int y) {
        System.out.println(name + ", " + color + ", " + x + ", " + y);
    }

}

class TreeLocation {
    private TreeType treeType;

    public TreeLocation(TreeType treeType) {
        this.treeType = treeType;
    }

    public void plant(int x, int y) {
        treeType.plant(x, y);
    }

}

public class Main {
    public static void main(String[] args) {
        TreeType treeType = TreeFactory.getTreeType("tree1", "yellow");
        new TreeLocation(treeType).plant(100, 100);
    }
}