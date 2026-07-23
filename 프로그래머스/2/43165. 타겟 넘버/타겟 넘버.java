import java.util.*;
import java.io.*;

class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);    
        
        return answer;
    }
    
    public void dfs(int[] nums, int target, int sum, int idx){
        
        if(idx == nums.length) {
            if(sum == target) answer++;
            return;    
        }
       
        
        dfs(nums, target, sum + nums[idx], idx+1);
        dfs(nums, target, sum - nums[idx], idx+1);
        
    }
}