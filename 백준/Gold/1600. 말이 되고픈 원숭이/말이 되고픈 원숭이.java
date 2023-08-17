import java.util.*;
import java.io.*;

public class Main {

	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int cnt;
	
	static int[] dr = {-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dc = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[H][W][K+1];
		
		bfs();

	}
	
	static void bfs() {

		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 0, 0, 0 });
		visited[0][0][0]=true;
		
		int move=0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size--> 0) {
				
				int[] val = queue.poll();
				int r = val[0];
				int c = val[1];
				int horsecnt = val[2];

				if(r==H-1 && c==W-1) {
					System.out.println(move);
					System.exit(0);
				}
				
				int length = (horsecnt==K?4:12);

				for (int d = 0; d < length; d++) {
					int nextr = r + dr[d];
					int nextc = c + dc[d];

					if(d==4) ++horsecnt;
					
					if (nextr < 0 || nextc < 0 || nextr >= H || nextc >= W || map[nextr][nextc] == 1 || visited[nextr][nextc][horsecnt]) continue;
					
					queue.add(new int[] { nextr, nextc, horsecnt });
					visited[nextr][nextc][horsecnt]=true;
				}
			}
			++move;
		}
		
		System.out.println(-1);

	}

}
