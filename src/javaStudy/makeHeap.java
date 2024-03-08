package javaStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class makeHeap {

    /*
    * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조다.
    *
    * 1. 배열에 정수 x(x!=0)을 넣는다.
    * 2. 배열에서 절댓값이 가장 작은 값을 출력한 후 그 값을 배열에서 제거한다.
    * 절댓값이 가장 작은 값이 여러 개일 경우에는 그 중 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
    *
    * 프로그램은 처음에 비어 있는 배열에서 시작한다.
    * 절댓값 힙을 구현하시오.
    *
    * 1번째 줄에 연산의 개수 N(1<=N<=100,000)이 주어진다.
    * 다음 N개의 줄에는 연산과 관련된 정보를 나타내는 정수 x가 주어진다.
    * 만약 x가 0이 아니라면 배열에 x라는 값을 추가하고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
    * 입력되는 정수는 -231보다 크고, 231보다 작다.
    *
    * 입력에서 0이 주어진 횟수만큼 답을 출력한다.
    * 만약 배열이 비어 있는데 절댓값이 가장 작은 값을 출력하라고 할 때는 0을 출력하면 된다.
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐
        PriorityQueue<Integer> myQ = new PriorityQueue<>((o1,o2)->{
            // 절댓값 작은 데이터 우선
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            // 절댓값이 같은 경우 음수 우선
            if(first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }
            return first_abs-second_abs;
        });

        for(int i=0; i<N; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0) {
                if(myQ.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(myQ.poll());
            } else {
                myQ.add(request);
            }
        }

    }
}
