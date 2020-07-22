/*
	对于一个数n，n-1与n在位上的差异是从最后一个1开始所有的位相反，二者做与操作便可以去除最后一个1，
	因此当n不为0的时候，一直做n&(n-1)，记录循环次数
	
*/

class MinStack {
	// solution for 191
    public int hammingWeight(int n){
        int res = 0;
        while(n!=0){
            n = (n-1)&n;
            ++ res;
        }
        return res;
    }
}
