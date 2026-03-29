class MovieDoublyList {

    static class Node {
        String title, director;
        int year;
        double rating;
        Node next, prev;

        Node(String t, String d, int y, double r) {
            title = t; director = d; year = y; rating = r;
        }
    }

    Node head, tail;

    void add(String t, String d, int y, double r) {
        Node newNode = new Node(t, d, y, r);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.rating);
            temp = temp.next;
        }
    }

    void displayReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        MovieDoublyList list = new MovieDoublyList();
        list.add("Inception", "Nolan", 2010, 9.0);
        list.displayForward();
    }
}