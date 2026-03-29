class RoundRobinScheduler {

    static class Node {
        int pid, burst;
        Node next;

        Node(int id, int b) {
            pid = id;
            burst = b;
        }
    }

    Node head;

    void add(int pid, int burst) {
        Node newNode = new Node(pid, burst);

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

    void execute(int quantum) {
        if (head == null) return;

        Node temp = head;

        do {
            if (temp.burst > 0) {
                int exec = Math.min(quantum, temp.burst);
                temp.burst -= exec;

                System.out.println("Process " + temp.pid + " executed for " + exec);
            }
            temp = temp.next;

        } while (!allDone());
    }

    boolean allDone() {
        Node temp = head;
        do {
            if (temp.burst > 0) return false;
            temp = temp.next;
        } while (temp != head);
        return true;
    }

    public static void main(String[] args) {
        RoundRobinScheduler rr = new RoundRobinScheduler();
        rr.add(1, 5);
        rr.add(2, 3);
        rr.add(3, 7);

        rr.execute(2);
    }
}