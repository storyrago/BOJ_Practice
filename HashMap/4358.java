import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap <String,Double> map = new HashMap<>();
		String str;
		int cnt = 0;
		while((str=br.readLine())!=null) {
			cnt++;
			map.put(str,map.getOrDefault(str,0.0)+1);
		}
		ArrayList<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list);
		for(String key : list) {
			System.out.printf("%s %.4f\n", key,map.get(key)/cnt*100);
		}
	}
}

