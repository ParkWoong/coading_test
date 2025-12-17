import java.util.Scanner;

public class Back1717 {
    static int parent[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1]; // 대표 노드 저장 배열

        for (int i = 0; i <= n; i++) {
            parent[i] = i; // 초기화
        }
        // 질의
        for (int i = 0; i < m; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (question == 0) { // union
                union(a, b);
            } else { // 두 원소 같은지 보기
                boolean result = check(a, b);
                if (result)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }

    private static void union(int a, int b) {
        // 대표노드를 찾아서 연결하기
        a = find(a);
        b = find(b);

        if (a != b)
            parent[b] = a; // 두개 연결

    }

    private static int find(int a) {
        if (a == parent[a]) { // index 값과 value 값이 같은지 확인
            return a;
        } else {
            // value값을 index로 바꿔서 찾아보기
            // 경로 압축 해주기(value값을 업데이트)
            return parent[a] = find(parent[a]);
        }
    }

    private static boolean check(int a, int b) {
        a = find(a);
        b = find(b);

        return a==b;
    }
}
