package tms.lessons.lesson_20.task1;

import java.util.Scanner;

public class MainSimpleSort {
    static int maxValue;
    static int minValue;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Введите значения в массив, но не более 100. Для завершения программы нажмите Enter");
        Scanner input = new Scanner(System.in);

        int[] arr = new int[100];
        int size = 0;

        while (size < arr.length) {
            String line = input.nextLine();
            if (line.isEmpty()) break;
            arr[size] = Integer.parseInt(line);
            size++;
        }


        int[] finalArr = java.util.Arrays.copyOf(arr, size);


        Thread threadLookForMaxValue = new Thread(new Runnable() {
            @Override
            public void run() {
                maxValue = findMaxValue(finalArr);
            }
        });
        threadLookForMaxValue.start();

        Thread threadLookForMinValue = new Thread(new Runnable() {
            @Override
            public void run() {
                minValue = findMinValue(finalArr);
            }
        });
        threadLookForMinValue.start();

        threadLookForMinValue.join();
        threadLookForMaxValue.join();

        System.out.println("Максимальное значение :" + maxValue);
        System.out.println("Минимальное значение :" + minValue);
    }


    private static int findMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;

    }

    private static int findMinValue(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;

    }
}
