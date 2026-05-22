import java.io.*;
import java.util.*;

public class Main {
    static class Plate {
        int num;
        int x;
        int ymin;
        int ymax;

        Plate(int num, int x, int ymin, int ymax) {
            this.num = num;
            this.x = x;
            this.ymin = ymin;
            this.ymax = ymax;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int power = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());

        Plate[] plates = new Plate[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int ymin = Integer.parseInt(st.nextToken()) * 2;
            int ymax = Integer.parseInt(st.nextToken()) * 2;

            plates[i] = new Plate(num, x, ymin, ymax);
        }

        Arrays.sort(plates, new Comparator<Plate>() {
            @Override
            public int compare(Plate a, Plate b) {
                return a.x - b.x;
            }
        });

        int[] count = new int[2001];
        ArrayList<Integer> safe = new ArrayList<>();

        for (Plate p : plates) {
            boolean isSafe = true;

            for (int y = p.ymin; y <= p.ymax; y++) {
                if (count[y] < power) {
                    isSafe = false;
                    break;
                }
            }

            if (isSafe) {
                safe.add(p.num);
            }

            for (int y = p.ymin; y <= p.ymax; y++) {
                count[y]++;
            }
        }

        Collections.sort(safe);

        if (safe.isEmpty()) {
            System.out.println(0);
        } else {
            StringBuilder sb = new StringBuilder();

            for (int num : safe) {
                sb.append(num).append(' ');
            }

            System.out.println(sb.toString().trim());
        }
    }
}
