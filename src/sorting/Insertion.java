package sorting;

/**
 * https://www.geeksforgeeks.org/insertion-sort/ for a nicer implementation without a break and helper method;
 */
public class Insertion {
    public static void main(String[] args) {
        int[] a = new int[]{6, 5, 10, 9};
        insertion(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static void insertion(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[i]) {
                    swap(a, i, j);
                } else {
                    break;
                }
            }
        }
    }

}
