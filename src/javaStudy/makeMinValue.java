package javaStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class makeMinValue {

    /*
    * 길이가 같은 배열 A,B 두개가 있습니다.
    * 각 배열은 자연수로 이루어져 있습니다.
    * 배열 A,B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다.
    * 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다.
    * 이 때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다.
    * (단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)
    *
    * 예를 들어 A = [1,4,2], B = [5,4,4]라면,
    * 1*5 + 2*4 + 4*4 = 29 인 경우가 최소가 되므로 29를 return 합니다.
    * 배열 A,B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 함수를 완성해 주세요.
    *
    * 제한사항
    * 배열 A,B의 크기 : 1000 이하의 자연수
    * 배열 A,B의 원소의 크기 : 1000 이하의 자연수
    *
    * input
    * 3
    * 1 4 2
    * 5 4 4
    *
    * return
    * 29
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrLen = Integer.parseInt(st.nextToken());
        int []A = new int[arrLen];
        int []B = new int[arrLen];
        int answer = 0;

        for(int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<arrLen; j++) {
                if(i == 0)
                    A[j] = Integer.parseInt(st.nextToken());
                else
                    B[j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[A.length-i-1];
        }

        System.out.println(" @@ answer => " + answer);
    }
}
