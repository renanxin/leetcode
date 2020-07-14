int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    int *result = NULL;
    for(int i=0;i<numsSize&&!result;++i){
        for(int j=i+1;j<numsSize&&!result;++j){
            if(nums[i]+nums[j]==target){
                result = (int*)malloc(sizeof(int)*2);
                result[0] = i;
                result[1] = j;
            }
        }
    }
    return result;
}

// If you want to more quick，you can use binary search which cost O(nlogn)
