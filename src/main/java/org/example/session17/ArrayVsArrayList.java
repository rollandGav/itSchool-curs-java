package org.example.session17;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayVsArrayList {
    public static void main(String[] args) {

        int[] array = new int[5];
        array[0] = 10;
        array[1] = 20;
        array[2] = 30;
        System.out.println("elements from array: " + Arrays.toString(array));
        for(int i = 0; i < 5; i++) {
            System.out.println("element from array from position: " + i + " with value: " + array[i]);
        }
        for (int value : array){
            System.out.println("element from array: " + value);
        }

        ArrayList<Integer> arrayList =  new ArrayList<>();

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println(arrayList);
        System.out.println("value at position 1: " + arrayList.get(1));
        arrayList.add(1, 15);
        System.out.println("value at position 1: " + arrayList.get(1));
        System.out.println(arrayList);
        arrayList.remove(2);
        System.out.println(arrayList);

    }
}
