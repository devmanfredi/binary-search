package main.java;

import java.util.Arrays;

public class BinarySearchApplication {

    public static boolean binarySearchIterative(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (key < array[middle]) {
                right = middle - 1;
            } else if (key > array[middle]) {
                left = middle + 1;
            } else if (key == array[middle]) {
                return true;
            }
        }

        return false;
    }

    public static boolean binarySearchRecursive(int[] array, int key, int left, int right) {
        int middle = (left + right) / 2;

        if (right < left) return false;

        if (key < array[middle]) {
            return binarySearchRecursive(array, key, left, middle - 1);
        } else if (key > array[middle]) {
            return binarySearchRecursive(array, key, middle + 1, right);
        } else return key == array[middle];
    }


    public static void main(String[] args) {
        System.out.println("\tBinary Search\t");

        int[] array = {1, 8, 34, 67, 9, 6, 78, 12, 56, 41, 90};
        int key1 = 12, key2 = 91;
        Arrays.sort(array);

        System.out.println("Array : ");
        System.out.println(Arrays.toString(array));

        System.out.println();
        System.out.println("Using binary search iterative : ");
        System.out.println(binarySearchIterative(array, key1) ? key1 + " Found" : key1 + " Not found");
        System.out.println(binarySearchIterative(array, key2) ? key2 + " Found" : key2 + " Not found");

        System.out.println();
        System.out.println("Using binary search recursive : ");
        System.out.println(binarySearchRecursive(array, key1, 0, array.length - 1) ? key1 + " Found" : key1 + " Not found");
        System.out.println(binarySearchRecursive(array, key2, 0, array.length - 1) ? key2 + " Found" : key2 + " Not found");

    }
}
