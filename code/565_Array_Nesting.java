class Solution {

    // solution for 560
    public int arrayNesting(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;++i){
            System.out.println("i:  "+i);
            if(!map.containsKey(nums[i])){
                int num = getPathLength(nums[i], nums, set, map);
                map.put(i,num);
                set.clear();
            }
        }
        int max = 1;
        System.out.println(map);
        for(Integer key:map.keySet()){
            max = Math.max(max,map.get(key));
        }
        return max;
    }

    int getPathLength(int i,int[] nums,HashSet<Integer> set,HashMap<Integer,Integer> map){
        if(i<0||i>=nums.length||set.contains(i))
            return 0;
        if(map.containsKey(nums[i]))
            return map.get(nums[i])+1;
        else{
            set.add(i);
            map.put(nums[i],getPathLength(nums[i],nums,set,map));
            return map.get(nums[i])+1;
        }
    }
}