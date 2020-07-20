/*
	此题相当于求26进制的数字
	首先判断n是否为26的整数倍，如果是，就将n/26-1添加到builder的尾部，如果不是，直接将n%26所对应的单个字符
	添加到builder的尾部，最后在返回时将builder倒序输出即可
	
*/

class MinStack {

       // solution for 168
    public String convertToTitle(int n){
        StringBuilder builder = new StringBuilder();
        int tmp;
        while(n!=0){
            if(n%26==0){
                builder.append('Z');
                n = n / 26 - 1;

            }else{
                builder.append((char)(n%26-1+'A'));
                n = n/26;
            }
        }
        return builder.reverse().toString();
    }
}
