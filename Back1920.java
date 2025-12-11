import java.util.Arrays;
import java.util.Scanner;

public class Back1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A); // 오름차순 정렬 O(NlogN)

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            boolean isFind = false;
            int target = sc.nextInt();

            int start = 0; // 시작 인덱스
            int end = A.length - 1; // 끝 인덱스

            while (start <= end) {
                int midIndex = (start + end) / 2;
                int midValue = A[midIndex];
                if (midValue > target) {
                    end = midIndex - 1;
                } else if (midValue < target) {
                    start = midIndex + 1;
                } else {
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
