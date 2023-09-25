package Java8;

import org.junit.Test;

class Solution {

    public int[] sortArray (int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        for(int num:nums){
            if(num % 2 == 0){
                res[left++] = num;
            }else{
                res[right--] = num;
            }
        }
        return res;
    }
}
