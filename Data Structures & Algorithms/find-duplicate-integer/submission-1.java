class Solution {
    //negative marking
    public int findDuplicate(int[] nums) {
        for(int num : nums){
            int idx = num - 1;
            if(nums[idx] < 0){
                return num;
            }
            nums[idx] *= -1;
        }
        return -1;
    }
}
