package javaStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class slidingWindow {

    /*
    * 슬라이딩 윈도우 알고리즘은 2개의 포인터로 범위를 지정한 다음 다음 범위(window)를 유지한 채로 이동(sliding)하며 문제를 해결한다.
    * 투 포인터 알고리즘과 매우 비슷하고 원리도 간단한 것이 특징이다.
    *
    * 평소 문자열을 이용해 노는 것을 좋아하는 민호는 DNA 문자열을 알게 됐다.
    * DNA 문자열은 모든 문자열에 등장하는 문자가 {'A', 'C', 'G', 'T'}인 문자열을 말한다.
    * 예를 들어 'ACKA'는 DNA 문자열이 아니지만, 'ACCA'는 DNA 문자열이다.
    * 이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분 문자열을 비밀번호로 사용하기로 마음먹었다.
    *
    * 하지만 민호는 이 방법에는 큰 문제가 있다는 것을 발견했다.
    * 임의의 DNA 문자열의 부분 문자열을 뽑았을 때 'AAAA'와 같이 보안에 취약한 비밀번호가 만들어질 수 있기 때문이다.
    * 그래서 민호는 부분 문자열에서 등장하는 문자의 개수가 특정 개수 이상이어야 비밀번호로 사용할 수 있다는 규칙을 만들었다.
    * 예를 들어 임의의 DNA 문자열이 'AAACCTGCCAA'이고, 민호가 뽑을 부분 문자열의 길이를 4라고 가정해보자.
    * 그리고 부분 문자열에 'A'는 1개 이상, 'C'는 1개 이상, 'G'는 1개 이상, 'T'는 0개 이상 등장해야 비밀번호로 사용할 수 있다고 가정해보자.
    * 이 떄 'ACCT'는 'G'가 1개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용할 수 없지만, 'GCCA'는 모든 조건을 만족하므로 비밀번호로 사용할 수 있다.
    *
    * 민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분 문자열의 길이 그리고 {'A', 'C', 'G', 'T'}가 각각 몇 번 이상 등장해야 비밀번호로 사용할 수 있는지,
    * 순서대로 주어졌을 때 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하시오.
    * 단, 부분 문자열이 등장하는 위치가 다르면 부분 문자열의 내용이 같더라도 다른 문자열로 취급한다.
    *
    * 1번째 줄에 민호가 임의로 만든 DNA 문자열의 길이 |S|와 비밀번호로 사용할 부분 문자열의 길이 |P|가 주어진다.(1<=|P|<=|S|<=1,000,000)
    * 2번째 줄에 민호가 임의로 만든 DNA 문자열이 주어진다.
    * 3번째 줄에 부분 문자열에 포함돼야 할 {'A', 'C', 'G', 'T'}의 최소 개수가 공백 문자를 사이에 두고 각각 주어진다.
    * 각각의 수는 |S|보다 작거나 같은 음이 아닌 정수로 총합은 |S|보다 작거나 같다는 것이 보장된다.
    *
    * input
    * 4 2
    * GATA
    * 1 0 0 1
    *
    * result
    * 2
    */

    static int chkArr[];    // 입력받은 조건 arr
    static int myArr[];     // 실제 부분문자열이 얼마나 부합하는지 체크하는 arr
    static int chkSecret;   // 4개 모두 부합하는지 확인하기 위한 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char A[] = new char[S];
        int result = 0;

        chkArr = new int[4];
        myArr = new int[4];
        chkSecret = 0;

        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<4; i++) {
           chkArr[i] = Integer.parseInt(st.nextToken());
           if(chkArr[i] == 0) {
               // 0이면 확인할 필요 X -> 이미 만족한 것으로 간주함
               chkSecret++;
           }
        }

        for(int i=0; i<P; i++) {
            // 부분 문자열을 처음 받고 setting
            Add(A[i]);
        }
        if(chkSecret == 4) result++;

        // sliding window
        for(int i=P; i<S; i++) {
            int j = i-P;

            // 가장 오른쪽 i와 가장 끝 j만 체크한다 (위에서 초기화 작업을 한번 했기 때문에)
            Add(A[i]);
            Remove(A[j]);

            if(chkSecret == 4) result++;
        }

        System.out.println(" @@@ result ==> " + result);

    }

    private static void Add(char c) {
        switch (c) {
            case 'A' :
                myArr[0]++;
                if(myArr[0] == chkArr[0]) chkSecret++;
                break;
            case 'C' :
                myArr[1]++;
                if(myArr[1] == chkArr[1]) chkSecret++;
                break;
            case 'G' :
                myArr[2]++;
                if(myArr[2] == chkArr[2]) chkSecret++;
                break;
            case 'T' :
                myArr[3]++;
                if(myArr[3] == chkArr[3]) chkSecret++;
                break;
        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A' :
                if(myArr[0] == chkArr[0]) chkSecret--;
                myArr[0]--;
                break;
            case 'C' :
                if(myArr[1] == chkArr[1]) chkSecret--;
                myArr[1]--;
                break;
            case 'G' :
                if(myArr[2] == chkArr[2]) chkSecret--;
                myArr[2]--;
                break;
            case 'T' :
                if(myArr[3] == chkArr[3]) chkSecret--;
                myArr[3]--;
                break;
        }
    }

}
