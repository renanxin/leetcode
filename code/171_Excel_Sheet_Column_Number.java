/*
	与之前一题正好相反，给定一个字符串，求出对应的值
	可以参数16进制转10进制，不过需要注意的是这里的Z是26，不是0
	
*/

class MinStack {

    // solution for 171
    public int titleToNumber(String s){
        int res = 0;
        for(int i=0;i<s.length();++i){
            int tmp = s.charAt(i)=='Z'?26:s.charAt(i)- 'A'+1;
            res = res * 26 + tmp;
        }
        return res;
    }
}
