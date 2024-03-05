package javaStudy;

import java.util.Scanner;

public class calSum {

    /*
    * N개의 숫자가 공백 없이 써 있다.
    * 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.
    *
    * 1번째 줄에 숫자의 개수 N(1<=N<=100)
    * 2번째 줄에 숫자 N개가 공백 없이 주어진다.
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String sNum = sc.next();

        char[] cNum = sNum.toCharArray();
        int sum = 0;

        for(int i=0; i<cNum.length; i++) {
            sum += cNum[i] - '0';
        }
        System.out.println(" @@ sum => " + sum);
    }
}
