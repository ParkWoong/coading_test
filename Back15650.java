import java.util.Scanner;

public class Back15650 {
    
    static int n, m;

    static boolean visited[];
    static int[] s;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n];
        s = new int[n];

        back(0);
    }

    private static void back(int length){
        if(length == m){
            printArray();
            return;
        }
        for (int i = 0; i < n; i++) { // 갈 수 있는 모든 선택지
            if(!visited[i]){
                visited[i] = true;
                s[length] = i;
                back(length + 1);
                visited[i] = false;
            }
        }
    }

    private static void printArray(){
        for (int i = 0; i < m; i++) {
            System.out.print(s[i]+1+" ");
        }
    }
}
