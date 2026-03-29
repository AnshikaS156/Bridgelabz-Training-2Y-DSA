class InventoryList {

    static class Node {
        int id, qty;
        String name;
        double price;
        Node next;

        Node(int i, String n, int q, double p) {
            id = i; name = n; qty = q; price = p;
        }
    }

    Node head;

    void add(int id, String name, int qty, double price) {
        Node newNode = new Node(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    double totalValue() {
        double sum = 0;
        Node temp = head;
        while (temp != null) {
            sum += temp.qty * temp.price;
            temp = temp.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        InventoryList list = new InventoryList();
        list.add(1, "Item1", 2, 50);
        list.add(2, "Item2", 3, 100);

        System.out.println(list.totalValue());
    }
}