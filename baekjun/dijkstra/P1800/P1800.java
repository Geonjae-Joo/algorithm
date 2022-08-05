import java.io.*;
import java.util.*;

public class P1800 {
	static int N,P,K;
	static ArrayList<int[]>[] adj;
	static int[] d_arr;
	static boolean[] check;

	
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("./input1800.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int min,max;
		adj = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			adj[i]=new ArrayList<>();
		}
		d_arr = new int[N+1];
		Arrays.fill(d_arr,Integer.MAX_VALUE);
		check = new boolean[N+1];
		min = Integer.MAX_VALUE;
		max = 0;
		System.out.print(0);
		
		for (int p = 0; p < P; p++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			min = Math.min(min, c);
			max = Math.max(max,c);
			adj[a].add(new int[] {b,c});
			adj[b].add(new int[] {a,c});
		}
		if(N==1)System.out.print(0);
		else {
			int result = Integer.MIN_VALUE;
			//binary // dijkstra
//			int mid = (min+max)/2;
			while(min<=max) {
				int mid = (min+max)/2;
                System.out.println("pre_cost+cost");

				if(dijkstra(mid)) {
                    System.out.println("b");
					max = mid-1;
					result =mid;
				}else {
					min = mid+1;
				}
			
			}
			if(result==Integer.MIN_VALUE) {
				System.out.print(-1);
				return;
			}else {
				System.out.print(result);
			}
		}
		
	}
	static boolean dijkstra(int x) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
//		System.out.println(x);

		Arrays.fill(d_arr,Integer.MAX_VALUE);
		check = new boolean[N+1];
		pq.offer(new int[] {1,0});
		d_arr[1]=0;
		while(!pq.isEmpty()) {

			int[] cur_node = pq.poll();
			int cur_idx = cur_node[0];
			if(check[cur_idx]) continue;
			check[cur_idx]=true;
			for (int i = 0; i < adj[cur_idx].size(); i++) {
				int[] next_node = adj[cur_idx].get(i);
				int next_idx = next_node[0];
				int pre_cost = cur_node[1];
				int cost = (next_node[1]<=x)?0:1;
//				System.out.println(pre_cost+cost);

				if(pre_cost+cost<d_arr[next_idx]) {
					d_arr[next_idx]=pre_cost+cost;
					pq.offer(new int[] {next_idx,pre_cost+cost});
					
				}
			}
			
			
		}
//		System.out.println(Arrays.toString(d_arr));

		return d_arr[N]<=K;

		
		
	}
}









