/*
	首先判断结果的正负号，之后判断结果的整数部分的值，并得到remainder用于之后小数部分的获取
	当remainder不为0的时候，则进行循环，不断得到小数部分的值，对于那种无穷循环的结果可以使
	用hashmap，将remainder用键值对的方法存储起来，对应的值为此时builder的长度，这样便于添加括号
	
*/

public class Solution {
	// solution for 166
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) return "";
        StringBuilder builder = new StringBuilder();
        boolean flag = (numerator < 0) ^ (denominator < 0);

        long num = Math.abs(numerator);
        long den = Math.abs(denominator);
        num = Math.abs(num);
        den = Math.abs(den);

        long n = num / den;
        long remainder = (num % den) * 10;

        builder.append(flag ? "-" : "");
        builder.append(n);
        builder.append(remainder != 0 ? "." : "");
        HashMap<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int len = map.get(remainder);
                builder.insert(len, '(');
                builder.append(")");
                break;
            }
            map.put(remainder, builder.length());
            n = remainder / den;
            builder.append(n);
            remainder = (remainder % den) * 10;
        }
        return builder.toString();
    }
}
