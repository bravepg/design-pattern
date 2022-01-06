package create.prototype;

interface Prototype {
    Prototype clone();
}

class Button implements Prototype {
    int x;
    int y;

    public Button(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Button(Button prototype) {
        this.x = prototype.x;
        this.y = prototype.x;
    }

    @Override
    public Prototype clone() {
        return new Button(this);
    }
    
}


public class Main {
    public static void main(String[] args) {
        Button btn1 = new Button(1, 2);
        Button btn2 = (Button) btn1.clone();

        btn1.x = 2;

        System.out.println(btn1.x + ", " + btn2.x);
    }
}
