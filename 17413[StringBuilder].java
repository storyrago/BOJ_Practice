import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder("");
		String str = br.readLine();
		boolean opencheck = false;
		for(char c: str.toCharArray()) {
			if(c == '<') {
				opencheck = true;
				bw.write(sb.reverse()+"<");
				sb.setLength(0);
				continue;
			}
			else if(c == '>') {
				opencheck = false;
				bw.write(">");
				continue;
				}
			else if(opencheck) {
				bw.write(c);
				continue;
			}
			else if(c == ' ') {
				bw.write(sb.reverse().toString());
				bw.write(" ");
				sb.setLength(0);
			}
			else sb.append(c);
		}
		bw.write(sb.reverse().toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
