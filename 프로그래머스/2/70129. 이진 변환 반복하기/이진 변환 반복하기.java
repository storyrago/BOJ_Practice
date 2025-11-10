class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")){
            int zeroCnt = 0;
            for (char c : s.toCharArray()) {
                if(c == '0') zeroCnt++;
            }
            int op = s.length() - zeroCnt;
            answer[1]+=zeroCnt;
            s = Integer.toBinaryString(op);
            answer[0]++;
        }

        return answer;
    }
}