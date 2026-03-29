class StudentLinkedList {

    static class Node {
        int roll;
        String name;
        int age;
        String grade;
        Node next;

        Node(int r, String n, int a, String g) {
            roll = r;
            name = n;
            age = a;
            grade = g;
        }
    }

    Node head;

    // Add at end
    void add(int r, String n, int a, String g) {
        Node newNode = new Node(r, n, a, g);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    // Delete by roll
    void delete(int roll) {
        if (head == null) return;

        if (head.roll == roll) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    // Search
    void search(int roll) {
        Node temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println(temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not found");
    }

    // Update grade
    void update(int roll, String grade) {
        Node temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = grade;
                return;
            }
            temp = temp.next;
        }
    }

    // Display
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.roll + " " + temp.name + " " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();
        list.add(1, "A", 20, "A");
        list.add(2, "B", 21, "B");

        list.display();
    }
}