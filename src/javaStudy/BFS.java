package javaStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {

    /*
    * 너비 우선 탐색(Breadth First Search)도 그래프를 완전 탐색하는 방법 중 하나로,
    * 시작 노드에서 출발해 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘이다.
    * 너비 우선 탐색은 탐색 시작 노드와 가까운 노드를 우선하여 탐색하므로 목표 노드에 도착하는 경로가 여러 개 일때 최단 경로를 보장한다.
    * FIFO 탐색이며 Queue 자료구조를 이용한다.
    *
    * 4 X 6 크기의 배열로 표현되는 다음과 같은 미로가 있다.
    *           1 0 1 1 1 1
    *           1 0 1 0 1 0
    *           1 0 1 0 1 1
    *           1 1 1 0 1 1
    * 미로의 각 칸에 들어있는 숫자 중 1은 이동할 수 있는 칸,
    * 0은 이동할 수 없는 칸을 나타낸다.
    * 한 칸에서 다른 칸으로 이동할 때는 서로 인접한 칸으로만 이동할 수 있다.
    * 이동한 칸을 셀 때는 시작 위치와 도착 위치를 포함한다.
    * 즉, (1,1)에서 (4,6)으로 이동하려면 총 15칸을 지나가야 한다.
    *
    * N X M 크기의 미로가 주어질 때 (1,1)에서 출발해 (N,M)의 위치로 이동하기 위해 지나야 하는 칸 수의 최솟값을 구하는 프로그램을 작성하시오.
    *
    * 1번째 줄에 두 정수 N,M(2<=N,M<=100),
    * 그 다음 N개의 줄에는 미로의 내용이 M개의 정수로 주어진다.
    * 각각의 수들은 붙어서 입력된다.
    *
    * 1번째 줄에 지나야 하는 칸 수의 최솟값을 출력한다.
    * 항상 도착 위치로 이동할 수 있을 때만 입력으로 주어진다.
    *
    * input
    * 2 25
    * 1011101110111011101110111
    * 1110111011101110111011101
    *
    * return
    * 38
    *
    * input
    * 4 6
    * 110110
    * 110110
    * 111111
    * 111101
    *
    * return 9
    */

    // 하, 우, 상, 좌 순서로 탐색하게 됨
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] A;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();   // ex)1101101
            for(int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }
    private static void BFS(int i, int j) {
        Queue<int[]>queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            for(int k=0; k<4; k++) {
                // 상하좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if(x>= 0 && y>=0 && x<N && y<M) {
                    if(A[x][y]!=0 && !visited[x][y]) {
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }
}
