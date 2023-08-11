import java.util.*;
import java.io.*;
public class Main{
    static class MaxHeap{
        ArrayList<Long> list;
        public MaxHeap(){
            list = new ArrayList<>();
            list.add(0L);
        }
        public void add(Long x){
            list.add(x);
            int idx = list.size()-1;//x의 인덱스
            while(idx>1 &&list.get(idx/2) < x){
                    list.set(idx, list.get(idx/2));
                    list.set(idx/2, x);
                    idx /= 2;
            }
        }
        public Long delete(){
            if(list.size() <= 1) return 0L;
            Long result = list.get(1);

            Long x = list.get(list.size()-1);

            int idx = 1;
            list.set(idx,x);//그리고 내려간다

            //맨마지막이었던 애 삭제
            list.remove(list.size()-1);


            while(idx *2 < list.size()){
                Long max = list.get(idx*2);
                int maxIdx = idx*2;
                if(list.size() > idx * 2 + 1&&list.get(idx*2 + 1) > max){
                    max = list.get(idx*2+1);
                    maxIdx = idx*2+1;
                }
                //끝나는 조건을 추가
                if(list.get(idx) > max) break;
                //자식이 더 큰 경우에 교환을
                
                list.set(maxIdx, list.get(idx));
                list.set(idx, max);
                idx = maxIdx;//내려가는거니까 단순히 2를 곱해선안됨
            }


            return result;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        MaxHeap maxHeap = new MaxHeap();
        for(int i=0;i<n;i++){
            Long x = s.nextLong();
            if(x==0L) System.out.println(maxHeap.delete());
            else maxHeap.add(x);
        }
    }
}