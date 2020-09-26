/*
    本题的目标主要是得到一个字符串表达式在任意添加括号之后的所有运算结果
    无论表达式怎么添加括号，改变的知识运算的顺序，而运算的顺序可以看做表达式中每个运算符执行的顺序，所以我们可以
    对字符串表达式中的字符串两边部分递归，首先对传入的字符串进行判断，如果之时一个数字的话，则直接返回一个包含该
    数字的List，否则就是对字符串中的表达式进行递归，对于其中的每个操作符，对其左右的字符串进行递归，得到对应的List，
    再将左右两个List的值使用当前的运算符进行计算
    为了提高程序的运行速度和减小递归深度，可以定义一个Map结构对中间结果进行保存
*/

public class Solution {

   // solution for leetcode 241
    Map<String, List<Integer>> cache = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(input==null)    return ret;
        if(cache.containsKey(input))
            return cache.get(input);
        boolean isDigital = true;
        for(char ch:input.toCharArray()){
            if(ch=='+'||ch=='*'||ch=='-'){
                isDigital=false;
                break;
            }
        }
        if(isDigital)
            return Arrays.asList(Integer.valueOf(input));
        for(int i=0;i<input.length();++i){
            char ch = input.charAt(i);
            if(ch=='*'||ch=='+'||ch=='-'){
                List<Integer> l1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> l2 = diffWaysToCompute(input.substring(i+1));
                for(Integer i1:l1){
                    for(Integer i2:l2){
                        switch (ch) {
                            case '+': ret.add(i1 + i2); break;
                            case '-': ret.add(i1 - i2); break;
                            case '*': ret.add(i1 * i2); break;
                            default: break;
                        }
                    }
                }
            }
        }
        cache.put(input,ret);
        return ret;
    }
}
