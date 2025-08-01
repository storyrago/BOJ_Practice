import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		String bombstr = br.readLine();
		
		Stack <Character> st = new Stack<>();
		
		for(int i = 0;i<str.length();i++) {
			st.push(str.charAt(i)); //문자열에 저장된 값 문자형으로 스택에 푸쉬
			if(st.size() >= bombstr.length()) { //스택의 사이즈가 폭탄문자열보다 같거나 커지면 검사시작
				boolean bomb = true;
				for(int j = 0;j<bombstr.length();j++) { //폭탄문자열 길이 만큼 검사
					if(st.get(st.size()-bombstr.length()+j) != bombstr.charAt(j)) { //(스택 사이즈 - 폭탄문자열의 길이)값에서부터 폭탄문자열길이만큼 검사
						bomb = false; 
						break;
					}
				}
				if(bomb) {
					for(int j = 0;j<bombstr.length();j++) { //폭탄문자열 존재시 폭탄문자열길이만큼 스택pop
						st.pop();
					}
				}
			}
		}
		if(st.empty()) System.out.println("FRULA");
		else {
			for(int i = 0;i<st.size();i++) {
				bw.write(st.get(i));
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
