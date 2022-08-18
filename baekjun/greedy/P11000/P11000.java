import java.io.*;
import java.util.*;

public class P11000 {
    static int N;
    static int[][] schedule;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            st =new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            schedule[i][0]=a; 
            schedule[i][1]=b; 
        }
        Arrays.sort(schedule, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(schedule[0][1]);
        int room_count = 1;
        for (int i = 1; i < N; i++) {
            int c_start = schedule[i][0];
            int c_end = schedule[i][1];
            if(c_start>=pq.peek()){
                pq.poll();
                pq.offer(c_end);
            }else{
                pq.offer(c_end);
                room_count++;
            }

        }
        System.out.println(room_count);

        };
    
}
