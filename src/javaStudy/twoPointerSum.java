package javaStudy;

import java.util.Scanner;

public class twoPointerSum {

    /*
    * 어떠한 자연수 N은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
    * 당신은 어떤 자연수 N(1<=N<=10000000)을 몇 개의 연속된 자연수의 합으로 나타내는 가짓수를 알고싶다.
    * 이 때 사용하는 자연수는 N 이어야 한다.
    * 예를 들어 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5 이다.
    * 반면, 10을 나타내는 방법은 10, 1+2+3+4 이다.
    * N을 입력받아 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램을 작성하시오.
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;

        while(endIndex!=N) {
            if(sum == N) {
                count++;
                endIndex++;
                sum += endIndex;
            } else if(sum > N) {
                sum -= startIndex;
                startIndex++;
            } else {
                endIndex++;
                sum += endIndex;
            }
        }

        System.out.println(" @@@ count ==> " + count);

    }
}
