import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList <Integer>list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int left = 0;
        int right = list.size() - 1;
        int Min = 0;
        int ansleft = 0, ansright = 0;
        int temp = list.get(left) + list.get(right);
        if(temp > 0){
            Min = Math.abs(temp);
            ansleft= left;
            ansright = right;
            right-=1;
        }
        else if(temp < 0){
            Min = Math.abs(temp);
            ansleft= left;
            ansright = right;
            left +=1;
        }
        else{  //temp 가 0이면 while문 실행이 안되게 left가 right 보다 크게 설정
            ansleft = left;
            ansright = right;
            left = right + 1;
        }
        while(left<right){
            temp = list.get(left) + list.get(right);
            if(temp == 0) {
                ansleft = left;
                ansright = right;
                break;
            }

            if(temp > 0){
                if(Min > Math.abs(temp)){
                    Min = Math.abs(temp);
                    ansleft = left;
                    ansright = right;
                }
                right--;
            }
            else if(temp < 0){
                if(Min > Math.abs(temp)){
                    Min = Math.abs(temp);
                    ansleft = left;
                    ansright = right;
                }
                left++;
            }
        }
        System.out.println(list.get(ansleft) + " " + list.get(ansright));
    }
}

