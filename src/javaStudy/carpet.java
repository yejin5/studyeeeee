package javaStudy;

public class carpet {

    /*
    * Leo는 카펫을 사러 갔다가 아래와 같이 중앙에는 노란색으로 칠해져 있고,
    * 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
    *
    *       갈 갈 갈 갈
    *       갈 노 노 갈
    *       갈 갈 갈 갈
    *
    * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 수는 기억했지만,
    * 전체 카펫의 크기는 기억하지 못했습니다.
    * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때,
    * 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return하도록 solution함수를 작성해주세요.
    *
    * 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
    * 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
    * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
    *
    * input
    * brown 10 yellow 2
    *
    * return
    * [4,3]
    *
    * input
    * brown 24 yellow 24
    *
    * return
    * [8,6]
    */

    public static void main(String[] args) {
        int brown = 8;
        int yellow = 1;
        int[] answer = new int[2];

        int total = brown + yellow;

        for(int i=3; i<=total; i++) {
            int col = i;
            int row = total/i;

            if( (row >= 3) && (row >= col)) {
                if( (row-2) * (col-2) == yellow) {
                    answer[0] = row;
                    answer[1] = col;
                }
            }
        }

        System.out.println(answer[0]);
        System.out.println(answer[1]);

    }
}
