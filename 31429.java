import java.io.*;
import java.util.*;
public class Main {
	static class Pair<X,Y>{
		public final X first;
		public final Y second;
		
		public Pair(X first, Y second) {
			this.first = first;
			this.second = second;
		}
		@Override
		public String toString() {
			return first + " " + second;
		}
	}
	public static void main(String[]args)throws IOException {
		HashMap <Integer, Pair<Integer,Integer>>map = new HashMap<>();
		map.put(1, new Pair<>(12,1600));
		map.put(2, new Pair<>(11,894));
		map.put(3, new Pair<>(11,1327));
		map.put(4, new Pair<>(10,1311));
		map.put(5, new Pair<>(9,1004));
		map.put(6, new Pair<>(9,1178));
		map.put(7, new Pair<>(9,1357));
		map.put(8, new Pair<>(8,837));
		map.put(9, new Pair<>(7,1055));
		map.put(10, new Pair<>(6,556));
		map.put(11, new Pair<>(6,773));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(map.get(n));
	}

}
//hashmap을 이용해서 pair클래스를 만든  풀이 (switch-case 사용해도 되고 배열로 풀어도 됨)
