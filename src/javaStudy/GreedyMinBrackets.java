package javaStudy;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyMinBrackets {

    /*
    * 세준이는 양수와 +, - 그리고 괄호를 이용해 어떤 수식을 만들었다.
    * 그리고 괄호를 모두 지우고, 다시 괄호를 적절히 넣어 이 수식의 값을 최소로 만들려고 한다.
    * 이렇게 수식의 괄호를 다시 적절하게 배치해 수식의 값을 최소로 만드는 프로그램을 작성하시오.
    *
    * 1번째 줄에 식이 주어진다.
    * 식은 '0'~'9', '+', '-' 만으로 이뤄져 있고,
    * 가장 처음과 마지막 문자는 숫자다.
    * 그리고 연속해서 2개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다.
    * 수는 0으로 시작할 수 있다.
    * 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
    *
    * 1번째 줄에 정답을 출력한다.
    *
    * input
    * 100-40+50+74-30+29-45+43+11
    *
    * return
    * -222
    */

    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String str[] = example.split("-");

        for(int i=0; i<str.length; i++) {
            int temp = mySum(str[i]);
            if(i == 0) {
                answer += temp;
            } else {
                answer -= temp;
            }
        }

        System.out.println(answer);

    }

    public static int mySum(String a) {
        int sum = 0;
        String temp[] = a.split("\\+");

        for(int i=0; i<temp.length; i++) {
            sum = sum + Integer.parseInt(temp[i]);
        }

        return sum;
    }
}
