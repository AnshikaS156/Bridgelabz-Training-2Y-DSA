class CircularTour {

    static int findStart(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0, deficit = 0, balance = 0;

        for (int i = 0; i < n; i++) {
            balance += petrol[i] - distance[i];

            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }

        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        System.out.println(findStart(petrol, distance)); // Output: 1
    }
}