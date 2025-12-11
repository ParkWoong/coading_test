import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back17136 {

    static int[][] M = new int[10][10];
    static int[] s = { 0, 5, 5, 5, 5, 5 };
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 데이터 저장
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        back(0, 0); // 좌표, 몇개의 색종이 썼는지

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void back(int xy, int useCnt) {
        // 정답처리
        if (xy == 100) {
            result = Math.min(result, useCnt);
            return;
        }

        int x = xy % 10; // 나머지
        int y = xy / 10; // 몫

        // 가지치기
        if (result <= useCnt)
            return;
        if (M[x][y] == 1) {
            for (int i = 5; i > 0; i--) {
                if (s[i] > 0 && check(x, y, i)) {
                    s[i]--; // 종이사용
                    fill(x, y, i, 0);
                    back(xy + 1, useCnt + 1);
                    fill(x, y, i, 1);
                    s[i]++; // 종이회수
                }

            }

        } else {
            back(xy + 1, useCnt);
        }
    }

    private static boolean check(int x, int y, int size) {
        if(x+size > 10 || y+size>10) return false;
        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                if(M[i][j] != 1) return false;
            }
        }
        return true;

    }

    private static void fill(int x, int y, int size, int num) {
        for (int i = y; i < y+size; i++) {
            for (int j = x; j < x+size; j++) {
                M[i][j] = num;
            }
        }
    }

}