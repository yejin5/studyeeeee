package javaStudy;

import java.util.Scanner;

public class selectionSort {

    /*
    * 배열을 정렬하는 것은 쉽다.
    * 수가 주어지면 그 수의 각 자릿수를 내림차순으로 졍렬하시오.
    *
    * 1번째 줄에 정렬할 수 N이 주어진다.
    * N은 1,000,000,000보다 작거나 같은 자연수이다.
    *
    * 1번째 줄에 자릿수를 내림차순 정렬한 수를 출력한다.
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int arr[] = new int[N.length()];

        for(int i=0; i<N.length(); i++) {
            arr[i] = Integer.parseInt(N.substring(i,i+1));
        }

        // selection sort
        for(int i=0; i<N.length(); i++) {
            int Max = i;
            for(int j=i+1; j<N.length(); j++) {
                if(arr[j]>arr[Max])
                    Max = j;
            }
            if(arr[i] < arr[Max]) {
                int temp = arr[i];
                arr[i] = arr[Max];
                arr[Max] = temp;
            }
        }
        for(int i=0; i<N.length(); i++) {
            System.out.print(arr[i]);
        }
    }
}
