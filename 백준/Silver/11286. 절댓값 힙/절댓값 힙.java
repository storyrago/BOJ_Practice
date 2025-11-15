import java.util.*;
import java.io.*;

public class Main {
    static class IntSet{
        int index;
        int isMinus;
        public IntSet(int index, int isMinus) {
            this.index = index;
            this.isMinus = isMinus;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<IntSet> pq = new PriorityQueue<>((o1,o2) -> {
            int compIndex = Integer.compare(Math.abs(o1.index),Math.abs(o2.index));
            if(compIndex == 0){
                return Integer.compare(o1.isMinus,o2.isMinus);
            }
            else{
                return compIndex;
            }
        });
        for(int i = 0;i<n;i++){
            int op = Integer.parseInt(br.readLine());
            if(op != 0){
                if(op < 0){
                    pq.offer(new IntSet(op,-1));
                }
                else{
                    pq.offer(new IntSet(op,1));
                }
            }
            else{
                if(pq.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(pq.poll().index);
                }
            }
        }
    }
}