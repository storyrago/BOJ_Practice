class Solution {
    public int solution(int n) {
        int answer = 0;
        String bin = Integer.toBinaryString(n);
        int oneCnt = 0;
        for(char c:bin.toCharArray()) if(c == '1') oneCnt++;
        int nextOneCnt = 0;
        for(int i = n+1;i<=1000000;i++){
            nextOneCnt = 0;
            String nextBin = Integer.toBinaryString(i);
            for(char c : nextBin.toCharArray()) if(c=='1') nextOneCnt++;
            if(oneCnt == nextOneCnt){
                answer = i;
                break;
            }
        }
        return answer;
    }
}