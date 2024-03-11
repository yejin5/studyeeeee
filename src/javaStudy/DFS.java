package javaStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS {

    /*
    * 깊이 우선 탐색(Depth First Search)은 그래프 완전 탐색 기법 중 하나이다.
    * DFS는 그래프의 시작 노드에서 출발하여 탐색할 한 쪽 분기를 정하여 최대 깊이까지 탐색을 마친 후,
    * 다른 쪽 분기로 이동하여 다시 탐색을 수행하는 알고리즘이다.
    * 재귀함수로 구현, 스택 자료구조를 이용한다.
    *
    * 방향 없는 그래프가 주어졌을 때 연결요소(connected component)의 개수를 구하는 프로그램을 작성하시오.
    * 1번째 줄에 노ㅡ의 개수 N(1<=N<=1,000)과 에지의 개수 M(0<=M<=N*(N-1)/2),
    * 2번째 줄부터 M개의 줄에 에지의 양 끝 점 u와 v가 주어진다(1<=u,v<=N, u!=v)
    * 같은 에지는 한 번만 주어진다.
    *
    * 1번째 줄에 연결 요소의 개수를 출력한다.
    *
    * input
    * 6 5
    * 1 2
    * 2 5
    * 5 1
    * 3 4
    * 4 6
    *
    * return
    * 2
    */

    static boolean visited[];
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 0번을 사용하지 않기 위해 N+1
        visited = new boolean[n+1];
        A = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) {
            // 인접 리스트
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++) {
            // 에지 정보를 인접 리스트에 담음
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end); A[end].add(start);   // 방향이 없기 때문에 양쪽 방향 모두 add
        }

        int count = 0;
        for(int i=1; i<n+1; i++) {
            if(!visited[i]) {
                // 방문하지 않은 노드이면
                count++;
                DFS(i);
            }
        }
        System.out.println(count);

    }
    private static void DFS(int v) {
        if(visited[v]) {
            return;
        }
        visited[v] = true;
        for(int i : A[v]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}
