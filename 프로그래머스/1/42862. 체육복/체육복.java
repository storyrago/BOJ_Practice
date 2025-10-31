class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int [] clo = new int[n+2]; // ArrayIndexOutOfBoundsException 방지
        for(int i : reserve) clo[i]++;
        for(int i : lost) clo[i]--;
        //1이면 여분있는 애들, 0이면 자기꺼 가지고 있는 애들, -1이면 없는 애들
        for(int i = 1;i<=n;i++){
            if(clo[i] == -1){
                if(clo[i-1] == 1){
                    clo[i-1]--;
                    clo[i]++;
                }
                else if(clo[i+1]==1){
                    clo[i+1]--;
                    clo[i]++;
                }
            }
        }
        for(int i = 1;i<=n;i++){
            if(clo[i] == 0 || clo[i] == 1) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[]lost = {2,4};
        int[]reserve = {1,3,5};
        System.out.println(solution(5,lost,reserve));
    }
}
