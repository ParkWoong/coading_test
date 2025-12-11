import java.util.Scanner;

public class Back11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int A[] = new int[n];

        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        // 그리드 알고리즘 -> 최대한 큰 동전 먼저 사용하기
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
                if (A[i] <= k) {
                    count += (k/A[i]);
                    k = k % A[i];
                }
        }

        System.out.println(count);
    }
}
