package javaStudy;

import java.util.Scanner;
import java.util.Stack;

public class stackNum {

    /*
    * 임의의 수열을 스택에 넣었다가 출력하는 방식으로 오름차순 수열을 출력할 수 있는지 확인하고,
    * 출력할 수 있다면 push와 pop연산을 어떤 순서로 수행해야 하는지를 알아내는 프로그램을 작성한다.
    *
    * 1번째 줄에 수열의 개수 n(1<=n<=100,000)이 주어진다.
    * 2번째 줄에서 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 1개씩 순서대로 주어진다.
    * 이때 같은 정수가 두 번 이상 나오지는 않는다.
    *
    * 오름차순 수열을 만들기 위한 연산 순서를 출력한다.
    * push 연산은 +, pop 연산은 -로 출력하고, 불가능할 때는 NO를 출력한다.
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;        // 오름차순
        boolean result = true;

        StringBuffer bf = new StringBuffer();
        for(int i=0; i<A.length; i++) {
            int su = A[i];
            if(su >= num) {
                while(su>=num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if(n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }
        if(result)
            System.out.println("@@ answer => " + bf.toString());
    }
}
