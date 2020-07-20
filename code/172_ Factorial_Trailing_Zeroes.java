/*
	此题的主要目标是根据给定的n，请求n的阶乘中所包含的0元素个数
	要产生0，则必须是2*5,10也可以看成2*5，而2的元素个数又远大于5，所以此题可以看成寻找5的个数
	当n不为0的时候。n/5表示的是小于等于n且是5的一次倍的个数，循环操作，可以得到n次方的倍数
	
*/

class MinStack {

    // solution for 172
    public int trailingZeroes(int n){
        int res = 0;
        while(n>0){
            res += n/5;
            n/=5;
        }
        return res;
    }
}
