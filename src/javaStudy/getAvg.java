package javaStudy;

import java.util.Scanner;

public class getAvg {

    /*
    * 세준이는 기말고사를 망쳤다. 그래서 점수를 조작해 집에 가져가기로 결심했다.
    * 일단 세준이는 자기 점수 중 최댓값을 골랐다. 그런 다음 최댓값을 M이라 할 때 모든 정수를 점수/M*100 으로 고쳤다.
    * 예를 들어 세준이의 최고점이 70점, 수학 점수가 50점이라면 수학 점수는 50/70*100 이므로 71.43이다.
    * 세준이의 성적을 이 방법으로 계산했을 때 새로운 평균을 구하는 프로그램을 작성하시오.
    *
    * 1번째 줄에 시험을 본 과목의 개수 N이 주어진다.
    * 해당 값은 1000보다 작거나 같다.
    * 2번째 줄에 세준이의 현재 성적이 주어진다.
    * 해당 값은 100보다 작거나 같은, 음이 아닌 정수이고, 적어도 1개의 값은 0보다 크다.
    *
    * 1번째 줄에 새로운 평균을 출력하시오.
    * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /*int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }*/

        long sum = 0;
        long max = 0;

        for(int i=0; i<n; i++) {
            int temp = sc.nextInt();
            if(temp > max) max = temp;
            sum += temp;

            //if(arr[i] > max) max = arr[i];
            //sum += arr[i];
        }

        System.out.println(" @@ avg ==> " + sum*100.0/max/n);

    }
}
