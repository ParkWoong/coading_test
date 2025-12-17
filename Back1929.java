import java.util.Scanner;

public class Back1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[] A = new int[n+1];

        // 인덱스 초기화
        for (int i = 2; i <= n; i++) {
            A[i] = i;
        }

        // 에라토스테네스의 체 -> N의 제곱근까지
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(A[i]==0) continue;
            for (int j=i+i; j <= n; j=j+i) {
                A[j] = 0;
            }
        }

        for (int i = m; i <= n; i++) {
            if (A[i]!=0) {
                System.out.println(A[i]);
            }
        }
    }
}
