import java.util.Scanner;

public class Back9663 {

    static int n; // 체스판의 크기
    static int[] A; // 체스판
    static int cnt = 0; // 경우의 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        A = new int[n];
        back(0);
        System.out.println(cnt);
    }

    private static void back(int row) {
        if (row == n) { // 정답출력
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) { // 모든 경우의 수 탐색
            A[row] = i;
            if (check(row)) { // 가지치지 유효성 검사
                back(row + 1);
            }
        }
    }

    private static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if(A[i] == A[row]) return false; //일직선 공격
            if(Math.abs(row - i) == Math.abs(A[row] - A[i])) return false; //대각성 공격
        }
        return true;
    }
}
