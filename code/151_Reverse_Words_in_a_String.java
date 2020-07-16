import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
	本题的主要目标是将字符串中的每个单词逆序排列，同时忽略字符串首位空格，而每个单词间只用单个单词隔开
	首先利用string自身提供的trim和split方法将字符串切割成若干个单词，再利用StringBuilder将这些单词逆向拼接起来
	最后使用StringBuilder的toString方法得到目标字符串
*/

public class Solution {
    // solution for 151
    public String reverseWords(String s) {
        String[] split = s.trim().split(" +");
        StringBuilder builder = new StringBuilder();
        for(int i=split.length-1;i>0;--i)
            builder.append(split[i]+" ");
        return builder.append(split[0]).toString();
    }
}
