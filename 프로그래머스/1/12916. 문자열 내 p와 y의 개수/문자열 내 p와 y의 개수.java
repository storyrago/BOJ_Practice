class Solution {
    boolean solution(String s) {
        int p =0;
        int y = 0;
        for(char c: s.toCharArray()){
            if(c-80 == 0 || c-112 == 0) p++;
            else if(c-89==0 || c-121 == 0) y++;
        }
        return p == y;
    }
}