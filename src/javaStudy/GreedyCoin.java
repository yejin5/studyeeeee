package javaStudy;

import java.util.Scanner;

public class GreedyCoin {

    /*
    * 준규가 소유하고 있는 동전은 총 N종류이고, 각 동전의 개수가 많다.
    * 동전을 적절히 사용해 그 가격의 합을 K로 만들려고 한다.
    * 이 때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
    *
    * 1번째 줄에 N과 K(1<=N<=10, 1<=K<=100,000,000),
    * 2번째 줄부터 N개의 줄에 동전의 가격 A가 오름차순으로 주어진다(1<=Ai<=1,000,000, A1=1, i>=2일때 Ai는 Ai-1의 배수)
    *
    * 1번째 줄에 K원을 만드는 데 필요한 동전 개수의 최솟값을 출력한다.
    *
    * input
    * 10 4200
    * 1
    * 5
    * 10
    * 50
    * 100
    * 1000
    * 5000
    * 10000
    * 50000
    *
    * return
    * 6
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int A[] = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        // Greedy Algorithm
        int count = 0;
        for(int i=N-1; i>=0; i--) {
            if(A[i] <= K) {
                count += K/A[i];
                K = K % A[i];
            }
        }

        System.out.println(count);

    }
}
