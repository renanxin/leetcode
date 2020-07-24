/*
	可以使用一个present数组用来存储哪些对应索引是否为素数，首先当n小于2的时候直接返回0，大于等于2的时候，
	从2开始遍历，遇到值为1的，则返回值加1，同时将所以该索引整数倍的索引位置的值设置为0，最终返回res即可
	
*/

public class Solution {
	
   // solution for 204
    public int countPrimes(int n){
        if(n<2) return 0;
        int[] present = new int[n];
        int res = 0;
        for(int i=0;i<n;++i)
            present[i] = 1;
        present[0]=0;
        present[1]=0;
        for(int i=2;i<n;++i){
            if(present[i]==1){
                ++ res;
                int k = i*2;
                while(k<n){
                    present[k] = 0;
                    k+=i;
                }
            }
        }
        return res;
    }
}
