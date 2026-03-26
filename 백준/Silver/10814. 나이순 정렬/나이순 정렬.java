import java.util.*;
import java.io.*;
import java.io.IOException;

public class Main {
    static class UserInfo{
        int age;
        String name;
        public UserInfo(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<UserInfo> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new UserInfo(age,name));
        }
        Collections.sort(list,(o1,o2)->{
           return Integer.compare(o1.age, o2.age);
        });
        for (UserInfo userInfo : list) {
            System.out.print(userInfo.age + " " + userInfo.name + '\n');
        }
    }
}