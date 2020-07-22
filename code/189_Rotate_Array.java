/*
	对于数组的旋转，可通过将分割点左右两部分翻转即可，要做到这一步首先对这两部分单独做翻转，
	这样最后一次将整个数组完全翻转之后会保持为正
	
*/

class MinStack {

    // reverse an array from index i to j
    public void reverseArray(int[] nums,int i,int k){
        int tmp;
        for(int j=i;j<=(i+k)/2;++j){
            tmp = nums[j];
            nums[j] = nums[k-j+i];
            nums[k-j+i] = tmp;
        }
    }



    // solution for 189
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k %= N;
        k = N - k;
        reverseArray(nums,0,k-1);
        reverseArray(nums,k+1,N-1);
        reverseArray(nums,0,N-1);
    }
}
