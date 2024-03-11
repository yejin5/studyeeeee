package javaStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nextBigNum {

    /*
    * 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의합니다.
    * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수입니다.
    * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
    * 조건 3. n의 다음 큰 숫자는 조건 1,2를 만족하는 수 중 가장 작은 수 입니다.
    *
    * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
    * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 함수를 완성해주세요.
    *
    * n은 1,000,000 이하의 자연수입니다.
    *
    * input
    * 15
    *
    * return
    * 23
    */

    public static void main(String[] args) {
        int n = 78;
        int answer = 0;
        int count = Integer.bitCount(n);
        int chkCount = 0;

        while(true) {
            // Integer.bitCount(n) -> n을 이진법으로 변환하여 1의 개수 return
             chkCount = Integer.bitCount(++n);
            if(chkCount == count) {
                answer = n;
                break;
            }
        }
        System.out.println(" @@ answer => " + answer);
    }
}
