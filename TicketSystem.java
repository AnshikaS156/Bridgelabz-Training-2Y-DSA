class TicketSystem {

    static class Node {
        int id;
        String name, movie;
        Node next;

        Node(int i, String n, String m) {
            id = i;
            name = n;
            movie = m;
        }
    }

    Node head;

    void add(int id, String name, String movie) {
        Node newNode = new Node(id, name, movie);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node temp = head;
        while (temp.next != head) temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    void display() {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.println(temp.id + " " + temp.name + " " + temp.movie);
            temp = temp.next;
        } while (temp != head);
    }

    int count() {
        if (head == null) return 0;

        int c = 0;
        Node temp = head;
        do {
            c++;
            temp = temp.next;
        } while (temp != head);

        return c;
    }

    public static void main(String[] args) {
        TicketSystem ts = new TicketSystem();
        ts.add(1, "A", "Movie1");
        ts.add(2, "B", "Movie2");

        ts.display();
        System.out.println("Total: " + ts.count());
    }
}