class Solution {
    public int findMaxK(int[] nums) {
        boolean[] contains = new boolean[1001];
        for(int num:nums){
            if(num<0) contains[-1*num] = true;
        }
        int max = -1;
        for(int num:nums){
            if(num>0 && contains[num]) max = Math.max(max,num);
        }
        return max;
    }
}