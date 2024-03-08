package javaStudy;

import java.util.Scanner;

public class bubbleSort {

    /*
    * N개의 수가 주어졌을 때 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    *
    * 1번째 줄에 수의 개수 N(1<=N<=1,000), 2번째 줄수터 N개의 줄에 숫자가 주어진다.
    * 이 수는 절댓값이 1,000보다 작거나 같은 정수다.
    * 수는 중복되지 않는다.
    *
    * 1번째 줄부터 N개의 줄에 오름차순 정렬한 결과를 1줄에 1개씩 출력한다.
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int bubbleArr[] = new int[N];

        for(int i=0; i<N; i++)
            bubbleArr[i] = sc.nextInt();

        // bubble sort
        for(int i=0; i<N-1; i++) {
            for(int j=0; j<N-1-i; j++) {
                if(bubbleArr[j]>bubbleArr[j+1]) {
                    int temp = bubbleArr[j];
                    bubbleArr[j] = bubbleArr[j+1];
                    bubbleArr[j+1] = temp;
                }
            }
        }

        for(int i=0; i<N; i++)
            System.out.println(bubbleArr[i]);

    }
}
