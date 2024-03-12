package javaStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BipartiteGraph {

    /*
    * 각 집합에 속한 노드끼리 서로 인접하지 않는 두 집합으로 그래프의 노드를 나눌 수 있을 때 이 그래프를 '이분 그래프(Bipartite Graph)라고 한다.
    * 그래프가 입력으로 주어졌을 때 이 그래프가 이분 그래프인지 여부를 판별하는 프로그램을 작성하시오.
    *
    * 입력을 여러 개의 사례로 구성되어 있는데,
    * 1번째 줄에 테스트 케이스의 개수 K(2<=K<=5)가 주어진다.
    * 각 사례의 1번째 줄에 그래프의 노드의 개수 V(1<=V<=20k,000)와 에지의 개수 E(1<=E<=200,000)가 빈칸을 사이에 두고 순서대로 주어진다.
    * 각 노드에는 1부터 V까지 차례로 번호가 붙어 있다.
    * 이어서 2번째 줄부터 E개의 줄에 걸쳐 에지와 관련된 정보가 주어지는데,
    * 각 줄에 인접한 두 노드의 번호가 공백 문자를 사이에 두고 주어진다.
    *
    * input
    * 2
    * 3 2
    * 1 3
    * 2 3
    * 4 4
    * 1 2
    * 2 3
    * 3 4
    * 4 2
    *
    * return
    * YES
    * NO
    */

    // @@@ tree 는 사이클이 없기 때문에 항상 이분 그래프가 된다

    static ArrayList<Integer>[] A;
    static int check[];
    static boolean visited[];
    static boolean isEven;
    public static void main(String[] args) throws IOException {
        // 모든 노드로 각각 DFS탐색 알고리즘을 적용해 탐색을 수행함
        // 모든 노드를 탐색하는 이유 -> 모든 그래프의 모든 노드가 이어져 있지 않기 때문
        // DFS를 실행할 때 현재 노드에서 연결된 노드 중 이미 방문한 노드가 나와 같은 집합이면 이분 그래프가 아닌 것으로 판별
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int t=0; t<testCase; t++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);     // node
            int E = Integer.parseInt(s[1]);     // edge

            A = new ArrayList[V+1];     // node가 1부터 존재하기 때문에 0은 사용하지 않음
            visited = new boolean[V+1];
            check = new int[V+1];
            isEven = true;

            for(int i=1; i<=V; i++) {
                A[i] = new ArrayList<Integer>();
            }

            // data set
            for(int i=0; i<E; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);

                // 방향이 없기 때문에 양쪽 모두 add
                A[start].add(end);
                A[end].add(start);
            }

            // 모든 노드에서 DFS
            for(int i=1; i<=V; i++) {
                if(isEven)
                    DFS(i);
                else
                    break;
            }

            if(isEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }

    public static void DFS(int start) {
        visited[start] = true;
        for(int i : A[start]) {
            if(!visited[i]) {
                check[i] = (check[start] + 1) % 2;
                DFS(i);
            } else {
                if(check[start] == check[i])
                    isEven = false;
            }
        }
    }

}
