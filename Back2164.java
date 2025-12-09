import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Back2164 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);//

        final int n = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();


        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.poll();
            int secondNum = q.poll();
            q.add(secondNum);
        }

        System.out.println(q.poll());
    }
}