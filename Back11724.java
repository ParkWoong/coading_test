import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back11724 {
    
    static boolean visited[]; //방문배열
    static ArrayList<Integer> A[]; //인접리스트
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = 
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 0 사용을 안하려구
        visited = new boolean[n+1];
        A = new ArrayList[n+1];

        for (int i = 1; i < n+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            
            int s = Integer.parseInt(st.nextToken()); //시작점
            int e = Integer.parseInt(st.nextToken()); //종료점

            // 시작점 -> 종료점
            // 종료점 -> 시작점
            A[s].add(e);
            A[e].add(s);
        }

        int count = 0;

        for (int i = 1; i < n+1; i++) {
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    public static void dfs(int v){
        if(visited[v]) return;
        visited[v] = true; // 노드 방문

        for (int i : A[v]) {
            if(!visited[i]){
                dfs(i); //재귀함수
            }
        }
    }
   
}
