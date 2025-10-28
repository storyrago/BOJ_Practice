import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strList = s.split(" ");
        ArrayList<Integer> numList = new ArrayList<>();
        for(int i = 0;i<strList.length;i++){
            numList.add(Integer.parseInt(strList[i]));
        }
        answer += Collections.min(numList) + " ";
        answer += Collections.max(numList);
        return answer;
    }
}