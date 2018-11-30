package silantyevmn.ru.developerinterview.lesson3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by silan on 29.11.2018.
 */

public class Main {
    public static void main(String[] args) {
        Calculate cal=new Calculate();
        //1.Разработать и написать на Java алгоритм сортировки методом вставки (поиском максимума или минимума). Определить сложность алгоритма.
        int[] arr1=new int[]{5,2,3,5,9,12,4,1};
        print("Сортировка вставками исх.массив: "+getArrToString(arr1));
        print("По возрастанию: "+getArrToString(cal.insertSortingMinToMax(arr1)));
        print("По убыванию: "+getArrToString(cal.insertSortingMaxToMin(arr1)));
        //2. Разработать и написать на Java алгоритм вычисления чисел Фибоначчи. Определить сложность алгоритма.
        print("Фибонначи :"+ getArrToString(cal.fib(new int[10])));

        //3. Разработать и написать двунаправленный связанный список
        print("Двухнаправленный список :");
        DirectedList directedList=new DirectedList();
        print(directedList.getStringList());
        //4. *Разработать и написать на Java алгоритм вычисления простых чисел до 100 (например, с помощью решета Эратосфена).
        int numberEra=100;
        print("Решето Эратосфена до "+numberEra);
        print(Arrays.toString(cal.eratosfena(numberEra).toArray()));

    }

    private static String getArrToString(int[] arr){
        return Arrays.toString(arr);
    }
    private static void print(String text){
        System.out.println(text);
    }
}
