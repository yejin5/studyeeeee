package javaStudy;

public class expectedLeague {

    /*
    * ㅁㅁ게임대회가 개최되었습니다.
    * 이 대회는 N명이 참가하고, 토너먼트 형식으로 진행됩니다.
    * N명의 참가자는 각각 1부터 N번을 차례대로 배정받습니다.
    * 그리고, 1<->2, 3<->4, ... , N-1<->N 번의 참가자끼리 게임을 진행합니다.
    * 각 게임에서 이긴 사람은 다음 라운드에 진출할 수 있습니다.
    * 이 때, 다음 라운드에 진출할 참가자의 번호는 다시 1번부터 N/2번을 차례대로 배정받습니다.
    * 만약 1<->2끼리 겨루는 게임에서 2번이 승리했다면 다음 라운드에서 1번을 부여받고,
    * 3<->4끼리 겨루는 게임에서 3번이 승리했다면 다음 라운드에서 2번을 부여받게 됩니다.
    * 게임은 최종 한명이 남을 때까지 진행됩니다.
    *
    * 이 때, 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 궁금해졌습니다.
    * 게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B가 함수 solution의 매개변수로 주어질 때,
    * 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 return하는 solution함수를 완성해 주세요.
    * 단, A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정합니다.
    *
    * 제한사항
    * N : 2의 1제곱 이상, 2의 20제곱 이하인 자연수(2의 지수 승으로 주어지므로 부전승은 발생하지 않습니다.)
    * A,B : N이하인 자연수(단, A!=B)
    *
    * input
    * N : 8
    * A : 4
    * B : 7
    *
    * return
    * 3
    */

    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        int answer = 0;

        while(a!=b) {
            a = (a/2) + (a%2);
            b = (b/2) + (b%2);

            answer++;
        }

        System.out.println("@@@ answer => " + answer);
    }
}
