package silantyevmn.ru.developerinterview.lesson3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silan on 29.11.2018.
 */

public class Calculate {

    public int[] insertSortingMaxToMin(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] < temp) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = temp;
        }
        return array;
    }

    public int[] insertSortingMinToMax(int[] arr) {
        int temp, j;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                j = i;
                while (j > 0 && temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
        }
        return arr;
    }

    public int[] fib(int[] array) {
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array;
    }

    public List<Integer> eratosfena(int num) {
        List<Integer> list = initListNumbers(num);
        int digit = 2;
        while (digit <= list.size()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != digit && list.get(i) % digit == 0) {
                    list.remove(i);
                    i--;
                }
            }
            digit++;
        }
        return list;
    }

    //заполняем числами список от 2 до num
    private List<Integer> initListNumbers(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            list.add(i);
        }
        return list;
    }

}
