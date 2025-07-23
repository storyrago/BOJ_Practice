import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []armor = new int[n];
		for(int i = 0;i<n;i++) {
			armor[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(armor);
		int cnt = 0;
		int left = 0;
		int right = n -1;
		while(left < right) {
			if(armor[left] + armor[right] == m) {
				cnt++;
				left++;
				right--;
			}
			else if(armor[left] + armor[right] > m) {
				right--;
			}
			else if(armor[left] + armor[right] < m) {
				left++;
			}
		}
		
		System.out.println(cnt);
	}
}
