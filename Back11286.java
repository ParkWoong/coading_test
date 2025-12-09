import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Back11286 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> myQ = new PriorityQueue<>((o1,o2)->{
            // 절대값이 작은 데이터 우선 
            int first = Math.abs(o1);
            int second = Math.abs(o2);

            // 절대값이 같은 경우 음수 우선
            if(first == second)
                return o1 > o2 ? 1 : -1;

            return first - second;
        });

        for (int i = 0; i < n; i++) {
            int request = Integer.parseInt(bf.readLine());
            if(request == 0){
                if(myQ.isEmpty()) System.out.println("0");
                else {
                    System.out.println(myQ.poll());
                }
            }else{
                myQ.add(request);
            }
        }

    }

}