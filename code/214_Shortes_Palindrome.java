/*
	这道题让我们求最短的回文串，LeetCode 中关于回文串的其他的题目有 Palindrome Number，
	Validate Palindrome，Palindrome Partitioning，Palindrome Partitioning II 和 Longest 
	Palindromic Substring。题目让在给定字符串s的前面加上最少个字符，使之变成回文串，来看题目中
	给的两个例子，最坏的情况下是s中没有相同的字符，那么最小需要添加字符的个数为 s.size() - 1 个，
	第一个例子的字符串包含一个回文串，只需再在前面添加一个字符即可，还有一点需要注意的是，前面添
	加的字符串都是从s的末尾开始，一位一位往前添加的，那么只需要知道从s末尾开始需要添加到前面的个数。
	首先还是先将待处理的字符串s翻转得到t，然后比较原字符串s和翻转字符串t，从第一个字符开始逐一比较，
	如果相等，说明s本身就是回文串，不用添加任何字符，直接返回即可；如果不相等，s去掉最后一位，t去掉
	第一位，继续比较，以此类推直至有相等，或者循环结束，这样就能将两个字符串在正确的位置拼接起来了，
	代码请参见评论区5楼。但这种写法却会超时 TLE，无法通过 OJ，所以需要用一些比较巧妙的方法来解
	这里使用双指针来找出字符串s的最长回文前缀的大概范围，这里所谓的最长回文前缀是指从开头开始到某个
	位置为止是回文串，比如 "abbac" 这个子串，可以知道前四个字符组成的回文串 "abba" 就是最长回文前缀。
	方法是指针i和j分别指向s串的开头和末尾，若 s[i] 和 s[j] 相等，则i自增1，j自减1，否则只有j自减1。
	需要注意的是，这样遍历一遍后，得到的范围 [0, i) 中的子串并不一定就是最大回文前缀，也可能还需要
	添加字符，举个例子来说，对于 "adcba"，在 for 循环执行之后，i=2，可以发现前面的 "ad" 并不是最长
	回文前缀，其本身甚至不是回文串，需要再次调用递归函数来填充使其变为回文串，但可以确定的是可以添
	加最少的字符数让其变为回文串。而且可以确定的是后面剩余的部分肯定不属于回文前缀，此时提取出剩下
	的字符，翻转一下加到最前面，而对范围 [0, i) 内的子串再次递归调用本函数，这样，在子函数最终会组
	成最短的回文串，从而使得整个的回文串就是最短的，参见代码如下：
*/

public class Solution {
	
   // solution for 214
    public String shortestPalindrome(String s){
        int i=0,n = s.length();
        for(int j=n-1;j>=0;--j){
            if(s.charAt(i)==s.charAt(j))
                ++i;
        }
        if(i==n)    return s;
        String rem = s.substring(i);
        String rem_reverse = new StringBuilder(rem).reverse().toString();
        return rem_reverse+shortestPalindrome(s.substring(0,i))+rem;
    }
}
