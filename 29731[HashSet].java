import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args)throws IOException {
		HashSet<String>set = new HashSet<>();
		set.add("Never gonna give you up");
		set.add("Never gonna let you down");
		set.add("Never gonna run around and desert you");
		set.add("Never gonna make you cry");
		set.add("Never gonna say goodbye");
		set.add("Never gonna tell a lie and hurt you");
		set.add("Never gonna stop");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean check = true;
		for(int i = 0;i<n;i++) {
			String str = br.readLine();
			if(!set.contains(str)) {
				check = false; 
				break;
			}
		
		}
		System.out.println(check?"No":"Yes");
	}
}
