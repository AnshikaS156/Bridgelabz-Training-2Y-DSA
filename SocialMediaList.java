import java.util.*;

class SocialMediaList {

    static class User {
        int id;
        String name;
        List<Integer> friends;
        User next;

        User(int i, String n) {
            id = i;
            name = n;
            friends = new ArrayList<>();
        }
    }

    User head;

    void addUser(int id, String name) {
        User newUser = new User(id, name);
        newUser.next = head;
        head = newUser;
    }

    User find(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.id == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    void addFriend(int u1, int u2) {
        User a = find(u1);
        User b = find(u2);

        if (a != null && b != null) {
            a.friends.add(u2);
            b.friends.add(u1);
        }
    }

    void mutualFriends(int u1, int u2) {
        User a = find(u1);
        User b = find(u2);

        if (a == null || b == null) return;

        for (int f : a.friends) {
            if (b.friends.contains(f)) {
                System.out.println("Mutual: " + f);
            }
        }
    }

    public static void main(String[] args) {
        SocialMediaList sm = new SocialMediaList();
        sm.addUser(1, "A");
        sm.addUser(2, "B");
        sm.addUser(3, "C");

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);

        sm.mutualFriends(2, 3);
    }
}