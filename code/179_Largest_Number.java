/*
	此题的主要目标是从一个int数组中找到一个排列，使得合并起来所对应的数值最大
	既然目标是得到一个最大的排列，那么可以联想到排序，但是这里的排序需要特殊化，判断两个数字谁排在前面，可以由首位依次排列判断大小，谁出现了大的数谁就在前面，但是可能长度不同，而短的与长的前部分相同
	可以想到比这两个数首部大的数字都在它们的前面，就算短的部分可以拼接，其值也是小于等于当前首部的，所以可以比较a+b与b+a值的大小，哪边大就是哪个顺序
	
*/

public class Solution {

    // solution for 179
    public String largestNumber(int[] nums) {
        StringBuilder builder = new StringBuilder();
        List<String> strings = Arrays.stream(nums).boxed().map(Object::toString).collect(Collectors.toList());
        Collections.sort(strings, (s1,s2)->{return -(s1+s2).compareTo(s2+s1);});
        for(String s:strings)
            builder.append(s);
        if(builder.charAt(0)=='0')
            return "0";
        else
            return builder.toString();
    }
}
