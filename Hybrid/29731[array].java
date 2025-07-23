import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[]args)throws IOException {
		String[] meme = {
	            "Never gonna give you up",
	            "Never gonna let you down",
	            "Never gonna run around and desert you",
	            "Never gonna make you cry",
	            "Never gonna say goodbye",
	            "Never gonna tell a lie and hurt you",
	            "Never gonna stop"
	        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean check = true;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            boolean found = false;
            for (String s : meme) {
                if (str.equals(s)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                check = false;
                break;
            }
        }

        System.out.println(check ? "No" : "Yes");
	}
}
