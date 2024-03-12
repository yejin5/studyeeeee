package javaStudy;

import java.util.Scanner;

public class getPrimeNumber {

    /*
    * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
    *
    * 1번째 줄에 자연수 M과 N이 빈칸을 사이에 두고 주어진다(1<=M<=N<=1,000,000)
    * M이상 N이하의 소수가 1개 이상 있는 입력만 주어진다.
    *
    * 1줄에 1개씩, 증가하는 순서대로 소수를 출력한다.
    *
    * input
    * 3 16
    *
    * return
    * 3
    * 5
    * 7
    * 11
    * 13
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int A[] = new int[N+1];

        for(int i=1; i<=N; i++) {
            A[i] = i;
        }

        // N 제곱근까지만 계산하면 됨
        // N이 a*b라고 가정했을 때, a와 b 모두 N의 제곱근보다 클 수 없음
        // 따라서 N의 제곱근까지만 확인하면 전체 범위의 소수 판별 가능
        for(int i=2; i<=Math.sqrt(N); i++) {
           if(A[i]==0)
               continue;
           for(int j=i+i; j<=N; j+=i) {
               A[j] = 0;
           }
        }

        for(int i=M; i<=N; i++) {
            if(A[i] != 0)
                System.out.println(A[i]);
        }
    }
}
