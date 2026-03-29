class LibraryDoublyList {

    static class Node {
        int id;
        String title;
        Node next, prev;

        Node(int i, String t) {
            id = i; title = t;
        }
    }

    Node head, tail;

    void add(int id, String title) {
        Node n = new Node(id, title);
        if (head == null) {
            head = tail = n;
            return;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.title);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LibraryDoublyList list = new LibraryDoublyList();
        list.add(1, "Book1");
        list.display();
    }
}