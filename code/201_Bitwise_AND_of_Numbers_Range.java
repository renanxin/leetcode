/*
	又是一道考察位操作Bit Operation的题，相似的题目在LeetCode中还真不少，比如Repeated DNA Sequences 求重复的DNA序列， Single Number 单独的数字, Single Number II 单独的数字之二 ， Grey Code 格雷码，和 Reverse Bits 翻转位 等等，那么这道题其实并不难，我们先从题目中给的例子来分析，[5, 7]里共有三个数字，分别写出它们的二进制为：	
	101　　110　　111
	相与后的结果为100，仔细观察我们可以得出，最后的数是该数字范围内所有的数的左边共同的部分，如果上面那个例子不太明显，我们再来看一个范围[26, 30]，它们的二进制如下：
	11010　　11011　　11100　　11101　　11110
	发现了规律后，我们只要写代码找到左边公共的部分即可，我们可以从建立一个32位都是1的mask，然后每次向左移一位，比较m和n是否相同，不同再继续左移一位，直至相同，然后把m和mask相与就是最终结果，代码如下：
	
*/

public class Solution {

   // solution for 201
    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while((m&mask)!=(n&mask))
            mask<<=1;
        return m&mask;
    }
}
