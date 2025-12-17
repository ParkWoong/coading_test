import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Back1707 {

    static ArrayList<Integer>[] A; // 인접리스트
    static int[] check; // 0 or 1 -> 이분 그래프인지 판별
    static boolean[] visited;
    static boolean isEven; // true -> 이분 / flase -> 이분x

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        // 주어진 테스트 케이스 만큼 돌림
        for (int i = 0; i < testCase; i++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);

            // V+1 -> 0번째 인덱스를 사용하지 않기 위해서
            A = new ArrayList[V + 1];
            visited = new boolean[V + 1]; // 최초 초기화시 전부 false
            check = new int[V + 1];
            isEven = true;

            for (int j = 1; j <= V; j++) {
                A[j] = new ArrayList<Integer>();
            }

            // 에지 데이터 저장하기
            for (int j = 0; j < E; j++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);

                // 에지의 방향이 정해져있기 않기 때문에
                A[start].add(end);
                A[end].add(start);
            }

            // 모든 노드에서 DFS 실행해야 함
            for (int j = 1; j <= V; j++) {
                if (!visited[j]) {
                    dfs(j);
                    if (!isEven) break;
                }
            }
            

            if (isEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }

    private static void dfs(int start) {
       visited[start] = true;

       // 현재 start를 가진 노드에서 연결되어 있는 모든 노드를 탐색 -> 인접 리스트로 우리가 데이터를 초기화하였기 때문에
       for (int i : A[start]) {
            if(!visited[i]){ // 방문 안한 노드면
                // 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는것이 필요
                check[i] = (check[start] + 1) % 2; // 직전이 1이면 0이 되고 직전이 0이면 1이 된다. 
                dfs(i);
            }else{ //이미 방문한 노드면
                if (check[start] == check[i]) {
                    isEven = false;
                    return;
                }
            }
       }
    }
}
