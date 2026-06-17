package tms.lessons.lesson_20.task2;

import java.util.Arrays;

public class MainSortedType {

    public static void main(String[] args) {

        int[] arr = {10,50,58,6,7,6,8,10,69964,5,885};

        Thread threadInsertionSort = new Thread(() -> {
            int[] tempArr = Arrays.copyOf(arr,arr.length);
            insertionSort(tempArr);
        });
        Thread threadSelectionSort = new Thread(() -> {
            int[] tempArr = Arrays.copyOf(arr,arr.length);
            selectionSort(tempArr);
        });
        Thread threadBubbleSort = new Thread(() -> {
            int[] tempArr = Arrays.copyOf(arr,arr.length);
            bubbleSort(tempArr);
        });

        threadInsertionSort.start();
        threadBubbleSort.start();
        threadSelectionSort.start();
    }


    public synchronized static void printArr(String typeOfSorting, int[] sortedArr){

        System.out.println(typeOfSorting + Arrays.toString(sortedArr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        printArr("Cортировка вставками", arr);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        printArr("Cортировка выбором", arr);
    }

    public static void bubbleSort(int[] arr) {
        boolean swapped;

        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
        printArr("Cортировка пузырьком", arr);
    }



}
