import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;



public class task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        

        ArrayList<Integer> road = new ArrayList<>();
        road.add(1);

        int[] subArray = new int[m];
        int i;
        boolean flag = false;

        for(int j = 0; j < m; j++) { // получение первого подмассива размера размера m
            subArray[j] = 1 + (j + 1 + m - 2) % n;
        }
        road.add(subArray[0]);
        if (subArray[m-1] == 1) { flag = true; } // проверка подмассива

        while(!flag) { // если в первом подмассиве последний элемент не 1, продолжаем поиск используя предыдущий подмассив
            for (int k = 0; k < m; k++) {
                i = subArray[k];
                subArray[k] = 1 + (i + m - 2) % n;
            }
            road.add(subArray[0]);
            if (subArray[m-1] == 1) { flag = true; } // проверка подмассива
        }

        for(int elements : road) {
            System.out.print(elements);
        }
        
    }
}


