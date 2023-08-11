import org.w3c.dom.Node;

import java.lang.reflect.Array;
import java.util.*;

//1916

public class Main {
    static int map[][];
    static int distance[];
    static int MAX = 100000;
    static int start;
    static boolean visited[];
    static int end;
    public static void dijkstra(){


        //초기화
        Arrays.fill(distance, Integer.MAX_VALUE-1);
        //처음 노드 초기화
        distance[start] = 0;
        visited[start] = true;
        //처음노드를 기준으로 인접노드를 방문한다
        for(int i=1;i<map.length;i++){
            if(map[start][i]!=-1){
                //인접노드라면 값을 업데이트 해준다
                if(distance[i] > map[start][i]) distance[i] = map[start][i];
            }
        }

        for(int j=0;j<map.length-1;j++){
            int min = Integer.MAX_VALUE;
            int minIdx = 1;
            for(int i =1;i<map.length;i++){//map.length만큼 해도되는이유는?
                //최솟값 찾기
                if(!visited[i]&&distance[i] < min){
                    min = distance[i];
                    minIdx = i;
                }
            }
            visited[minIdx] = true;//최솟값을 방문
            //최솟값노드에 대한 인접노드들을 방문한다
            for(int i=1;i<map.length;i++){
                if(!visited[i]&&map[minIdx][i] != -1){//방문안한거고, 이어져있는곳 == 인접노드
                    if(distance[i] > map[minIdx][i] + distance[minIdx]){
                        distance[i] = map[minIdx][i] + distance[minIdx];
                    }
                }

            }
        }

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int city = s.nextInt();
        int bus = s.nextInt();
        map = new int[city+1][city+1];
        distance = new int[city+1];
        visited = new boolean[city+1];

        //가중치가 0일수도 있어서 -1로 초기화
        for(int y =0;y<map.length;y++){
            for(int x =0;x<map.length;x++){
                map[y][x] = -1;
            }
        }
        for(int i =0;i<bus;i++){
            int x = s.nextInt();
            int y = s.nextInt();
            int c = s.nextInt();

            //시작, 도착이 같은데 c가 다를 수 있다 이부분도 이해가 안가 TODO
            if(map[x][y] == -1) map[x][y] = c;
            else if(map[x][y] > c) map[x][y] = c;


        }

        start = s.nextInt();
        end = s.nextInt();
        dijkstra();

        System.out.println(distance[end]);

    }

}
