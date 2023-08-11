//1446

import java.io.PrintStream;
import java.util.*;

public class Main {
    public static class minHeap{
        private ArrayList<Long> heap;
        public minHeap(){
            heap = new ArrayList<>();
            heap.add(0L);
        }
        public void add(long val){
            //힙에 추가하는건 맨마지막 자리에 추가한다
            heap.add(val);
            int p = heap.size()-1;  
            while(p>1 && heap.get(p/2)>heap.get(p)) {
                long tmp = heap.get(p/2);
                heap.set(p/2, val);
                heap.set(p, tmp);

                p /= 2;
            }
        }
        public long delete(){
            if(heap.size()-1 < 1) return 0;
            //일단 루트를 제거한다
            long root = heap.get(1);
            //맨마지막값을 루트에 넣고 맨마지막 값을 없앤다
            heap.set(1, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            //
            int pos = 1;//일단 넣은 노드의 인덱스
            //이부분 생각못함 -> 왼쪽자식의 인덱스가 size보다 크다는 것은 더이상 내려갈 수가 없다는것임
            while(pos*2 < heap.size()){
                long min = heap.get(pos*2);
                int minIdx = pos * 2;
                if(pos*2+1 < heap.size()&&min > heap.get(pos*2 +1)){
                    min = heap.get(pos*2+1);
                    minIdx = pos*2 +1;
                }
                //이렇게 부모랑 자식을 교환했는데
                //그니까 자식>부모 면 맞는거잖아 그니까 그만하는거임
                if(min > heap.get(pos)) break;
                //그리고 그경우가 아니면 이제 부모자식을 교환해야지
                heap.set(minIdx, heap.get(pos));
                heap.set(pos, min);
                //교환한다음에 pos를 이제 교환한 그것의 pos로 바꿔주어야한다
                pos = minIdx;

            }


            return root;
        }

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =s.nextInt();
        minHeap minHeap1 = new minHeap();
        for(int i =0;i<n;i++){
            long k = s.nextLong();
            if(k==0) System.out.println(minHeap1.delete());
            else minHeap1.add(k);
        }

    }
}
