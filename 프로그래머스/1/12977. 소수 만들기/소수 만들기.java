import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        //에라토스테네스의 체 쓰는게 빠를거 같음 ㅇㅇ
        boolean[] eratos = new boolean[1000 + 999 + 998 + 1];
        Arrays.fill(eratos,true);
        eratos[0] = false; eratos[1] = false;
        for(int i = 2;i*i<=eratos.length;i++){
            if(eratos[i]){
                for(int j = i*i;j<eratos.length;j+=i){
                    eratos[j] = false;
                }
            }
        }
        int answer = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = i + 1;j<nums.length;j++){
                for(int k = j + 1;k<nums.length;k++){
                    int sum = nums[i] + nums[j] + nums[k];

                    if(eratos[sum]) answer++;
                }
            }
        }
        return answer;
    }
}