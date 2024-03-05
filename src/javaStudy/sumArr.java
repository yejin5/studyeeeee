package javaStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sumArr {

    /*
    * 수 N개가 주어졌을 때 i 번째 수에서 j 번째 수까지의 합을 구하는 프로그램을 작성하시오.
    *
    * 1번째 줄에 수의 개수 N(1<=N<=100000), 합을 구해야 하는 횟수 M(1<=M<=100000)
    * 2번째 줄에 N개의 수가 주어진다.
    * 각 수는 1000보다 작거나 같은 자연수이다.
    * 3번째 줄부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다.
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        long[]S = new long[suNo+1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=1; i<=suNo; i++) {
            // 0번째 인덱스는 신경쓰지 않기 위해 1부터
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        // 구간합
        for(int q=0; q<quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(S[j] - S[i-1]);
        }

    }
}
