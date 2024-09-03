package rtu;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void meth(int[] ars) {
        System.out.println("Vvedite chislo dla poiska:");
        Scanner scan = new Scanner(System.in);
        int numToFind = scan.nextInt();
        int low = 0;
        int high = ars.length - 1;
        int midlle;
        int loop = 0;
        while (low <= high) {
            midlle = (low + high) / 2;
            int num = ars[midlle];
            loop++;
            if (num == numToFind) {
                System.out.println("Znacenie naideno pod indeksom: " + midlle);
                System.out.println("Kol loops: " + loop);
                return;
            } else if (num > numToFind) {
                high = midlle - 1;
            } else {
                low = midlle + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] numberArray;
        int[] third1;
        int[] third2;
        int arrayLength;
        int thirdLength;
        System.out.println("Vvedite razmer pervogo massiva:");
        System.out.println("Vvedite razmer massiva 3zadania:");
        Scanner scanner = new Scanner(System.in);
        arrayLength = scanner.nextInt();
        thirdLength = scanner.nextInt();
        numberArray = new int[arrayLength];
        third1 = new int[thirdLength];
        third2 = new int[thirdLength];
        Random random = new Random();

        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = random.nextInt(-100, 100);
        }
        for (int i = 0; i < third1.length; i++) {
            third1[i] = random.nextInt(-100, 100);
        }
        for (int i = 0; i < third2.length; i++) {
            third2[i] = random.nextInt(-100, 100);
        }

        System.out.println("massiv 1: " + Arrays.toString(third1));
        System.out.println("massiv 2: " + Arrays.toString(third2));
        Arrays.sort(numberArray);
        System.out.println("Otsort massiv 1: " + Arrays.toString(numberArray));
        meth(numberArray);


        int[] matchedValues = new int[Math.min(third1.length, third2.length)];
        int matchIndex = 0;

        for (int i = 0; i < third1.length; i++) {
            for (int j = 0; j < third2.length; j++) {
                if (third1[i] == third2[j]) {

                    if (!contains(matchedValues, matchIndex, third1[i])) {
                        matchedValues[matchIndex++] = third1[i];
                    }
                }
            }
        }


        int[] result = Arrays.copyOf(matchedValues, matchIndex);
        System.out.println("Masyv s sovpadeniami: " + Arrays.toString(result));
    }


    private static boolean contains(int[] array, int length, int value) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
}
