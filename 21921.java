import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int []visitors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int max = 0;
	
		int sum =0;
		for (int i = 0; i < x; i++) {
		    sum += visitors[i];
		}
		max = sum;
		int cnt = 1;
		int left = 0;
		int right = left+x;
		while(right < n) {
			sum = sum - visitors[left] + visitors[right];
			if(sum > max) {
				max = sum;
				cnt = 1;
			}
			else if(sum == max) {
				cnt++;
			}
			left++;
			right++;
		}
		if(max == 0) System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
