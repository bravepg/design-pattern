package behavior.memento;

class Editor {
    private String text;
    private int selectionWidth;

    public void setText(String text) {
        this.text = text;
    }

    public void setSelectionWidth(int selectionWidth) {
        this.selectionWidth = selectionWidth;
    }

    public SnapShot createSnapShot() {
        return new SnapShot(this, this.text, this.selectionWidth);
    }
}

class SnapShot {
    private Editor editor;
    private String text;
    private int selectionWidth;

    public SnapShot(Editor editor, String text, int selectionWidth) {
        this.editor = editor;
        this.text = text;
        this.selectionWidth = selectionWidth;
    }

    public void restore() {
        editor.setText(text);
        editor.setSelectionWidth(selectionWidth);
    }
}


public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        SnapShot snapShot = editor.createSnapShot();
        snapShot.restore();
    }
}
