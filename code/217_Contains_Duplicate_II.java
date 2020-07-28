/*
	这里的两种方法都行，只是存储的数据结构不同，一个是使用set，跨度范围为k，只要连续k个数中出现重复则返回true，遍历nums的时候
	需要进行响应的增删，另一种是map存储，存储这当前数值最晚出现的位置，若与当前位置之差小于等于k，也返回true
*/

public class Solution {
	
    // solution for 219
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        if(k==0) return false;
//        HashSet<Integer> set = new HashSet<>();
//        for(int i=0;i<k&&i<nums.length;++i){
//            if(set.contains(nums[i]))
//                return true;
//            set.add(nums[i]);
//            System.out.println(set);
//        }
//        for(int i=k;i<nums.length;++i){
//            if(set.contains(nums[i]))
//                return true;
//            set.remove(nums[i-k]);
//            set.add(nums[i]);
//            System.out.println(set);
//        }
//        return false;
//    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;++i){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k)
                    return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
