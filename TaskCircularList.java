class TaskCircularList {

    static class Node {
        int id;
        String name;
        Node next;

        Node(int i, String n) {
            id = i; name = n;
        }
    }

    Node head;

    void add(int id, String name) {
        Node newNode = new Node(id, name);

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
            System.out.println(temp.id + " " + temp.name);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        TaskCircularList list = new TaskCircularList();
        list.add(1, "Task1");
        list.add(2, "Task2");

        list.display();
    }
}