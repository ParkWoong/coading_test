import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2178 {

    // 아래, 오른쪽, 위, 왼쪽 으로 가라
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    static boolean[][] visited;
    static int[][] A;

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) { // 행
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken(); // 예제가 공백이 없기 때문에 한줄을 다 받고 ex) 1011010101
            for (int j = 0; j < M; j++) { // 열
                A[i][j] = Integer.parseInt(line.substring(j, j + 1)); // 한줄의 한칸씩 끊어서 배열에 대입해준다.
            }
        } // 초기셋팅 완료

        bfs(0, 0);

        System.out.println(A[N - 1][M - 1]); // 최초 인덱스가 0,0 부터 시작하기 때문에
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });
        
        visited[i][j] = true;

        while (!queue.isEmpty()) { // 더이상 BFS를 탐색할 수 없을때 까지
            int now[] = queue.poll();

            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int x = now[0] + dx[k]; // x좌표 탐색
                int y = now[1] + dy[k]; // y좌표 탐색

                if (x >= 0 && y >= 0 && x < N && y < M) { // 배열을 넘어가면 안되고
                    if (A[x][y] != 0 && !visited[x][y]) { // 0이어서 갈 수 없거나, 방문한적이 있거나
                        // 이제 탐색 가능한 곳
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // 핵심 ! -> depth
                        queue.add(new int[] { x, y }); // 여기서 왜 1차원? A. x,y 의 좌표값을 하나의 int배열로 넣기 때문에 1차원
                    }
                }
            }
        }
    }
}
