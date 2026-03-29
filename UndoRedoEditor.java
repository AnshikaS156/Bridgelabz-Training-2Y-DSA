class UndoRedoEditor {

    static class Node {
        String text;
        Node prev, next;

        Node(String t) {
            text = t;
        }
    }

    Node current;

    void type(String newText) {
        Node newNode = new Node(newText);

        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        }

        current = newNode;
    }

    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    void display() {
        if (current != null)
            System.out.println("Current: " + current.text);
    }

    public static void main(String[] args) {
        UndoRedoEditor editor = new UndoRedoEditor();

        editor.type("Hello");
        editor.type("Hello World");

        editor.undo();
        editor.display();

        editor.redo();
        editor.display();
    }
}