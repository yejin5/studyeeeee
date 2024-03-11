package javaStudy;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {

    /*
    * 이진 탐색(Binary Search)은 데이터가 정렬돼 있는 상태에서 원하는 값을 찾아내는 알고리즘이다.
    * 대상 데이터의 중앙값과 찾고자 하는 값을 비교해 데이터의 크기를 절반씩 줄이면서 대상을 찾는다.
    *
    * N개의 정수 A[1],A[2],...,A[N]이 주어져 있을 때 이 안에 x라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
    * 1번째 줄에 자연수 N(1<=N<=100,000), 그 다음 줄에 N개의 정수 A[1],A[2],...,A[N]이 주어진다.
    * 그 다음 줄에 M(1<=M<=100,000), 그 다음 줄에 M개의 수들이 주어지는데,
    * 이 수들이 A안에 존재하는지 알아내면 된다.
    * 모든 정수의 범위는 -231보다 크거나 같고, 231보다는 작다.
    *
    * M개의 줄에 답을 출력한다.
    * 존재하면 1, 존재하지 않으면 0을 출력한다.
    *
    * input
    * 5
    * 4 1 5 2 3
    * 5
    * 1 3 7 9 5
    *
    * return
    * 1
    * 1
    * 0
    * 0
    * 1
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();

        for(int i=0; i<M; i++) {
            boolean isFind = false;
            int target = sc.nextInt();
            int start = 0;
            int end = A.length - 1;

            while(start <= end) {
                int midIndex = (start + end) / 2;
                int midValue = A[midIndex];

                if (midValue > target) {
                    end = midIndex - 1;
                } else if (midValue < target) {
                    start = midIndex + 1;
                } else {
                    isFind = true;
                    break;
                }
            }

            if(isFind)
                System.out.println(1);
            else
                System.out.println(0);

        }

    }
}
