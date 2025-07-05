import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0;i<n;i++) {
			String []str = br.readLine().split("\\.");
			String part = str[1];
			map.put(part,map.getOrDefault(part, 0) + 1); //getOrDefalut는 키가 있으면 값을 가져오고 없으면 디폴트로 설정해놓은 값 넣음
		}
		ArrayList<String> list = new ArrayList<>(map.keySet()); //map.keySet은 key값들을 세트로 바꿈
		Collections.sort(list);
		
		for(String key : list) {
			System.out.println(key+" " + map.get(key));
		}
	}
}
