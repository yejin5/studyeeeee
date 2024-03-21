package javaStudy;

public class jumpDP {

    /*
    * 효진이는 멀리 뛰기를 연습하고 있습니다.
    * 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다.
    * 칸이 총 4개일 때, 효진이는
    * (1 1 1 1)
    * (1 2 1)
    * (1 1 2)
    * (2 1 1)
    * (2 2)
    * 의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다.
    * 멀리뛰기에 사용될 칸의 수 n이 주어질 때,
    * 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내,
    * 여기에 1234567을 나눈 나머지를 리턴하는 함수 solution을 완성하세요.
    * 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
    *
    * n은 1이상, 2000이하인 정수입니다.
    *
    * input
    * n 4
    *
    * result
    * 5
    *
    * input
    * n 3
    *
    * result
    * 3
    */

    public static void main(String[] args) {
       int n = 4;
       long answer = 0;
       long[] db = new long[n+2];       // 동적계획법 Dynamic programming 이용

       db[0] = 0;
       db[1] = 1;
       db[2] = 2;

       for(int i=3; i<n+2; i++) {
           db[i] = (db[i-2] + db[i-1]) % 1234567;
       }

        System.out.println("n => " + db[n]);
    }
}
