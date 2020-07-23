/*
	直接暴力循环，但是需要注意的是，对于任意一个m位的n，做位平方和之后结果不大于81*n，所以总结果的情况
	小于1000，对于非Happy Number的数，必会出现循环，用一个set存储即可
	
*/

class MinStack {
	
   // solution for 202
    public boolean isHappy(int n) {
        if(n<=0)
            return false;
        HashSet<Integer> set = new HashSet<>();
        while(n!=1&&!set.contains(n)){
            int res = 0;
            set.add(n);
            while(n>0){
                res += (n%10)*(n%10);
                n /=10;
            }
            n = res;
        }
        return n==1;
    }
}
