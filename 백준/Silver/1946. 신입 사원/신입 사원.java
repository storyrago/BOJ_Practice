import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    public static class User{
        int sGrade;
        int iGrade;

        public User(int sGrade, int iGrade) {
            this.sGrade = sGrade;
            this.iGrade = iGrade;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        ArrayList<User>list = new ArrayList<>();
        for(int i = 0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            for(int j = 0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                list.add(new User(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())));
            }
            Collections.sort(list,(o1,o2)->{
                return Integer.compare(o1.sGrade,o2.sGrade);
            });
            int ans= 1;
            int max_grade = list.get(0).iGrade;
            for(int j =1;j<N;j++){
                if(list.get(j).iGrade <= max_grade){
                    max_grade = list.get(j).iGrade;
                    ans++;
                }
            }
            System.out.println(ans);
            list.clear();
        }
    }
}