import java.util.*;



class Solution{

    // solution for 1643
    public String kthSmallestPath(int[] destination, int k) {
        StringBuilder res = new StringBuilder();
        int count = destination[0]+destination[1];
        for(int i=0;i<count;++i){
            if(destination[1]==0||destination[0]==0)
                break;
            int num = computeC(count-1-i,destination[1]-1);
            System.out.println(num);
            if(num>=k) {
                res.append('H');
                destination[1] -= 1;
            }else{
                k-=num;
                res.append('V');
                destination[0] -= 1;
            }
        }
        while(destination[1]-->0)
            res.append('H');
        while(destination[0]-->0)
            res.append('V');

        return res.toString();
    }


    public int computeC(int all,int num){
        if(num==0)
            return 1;
        if(num==1)
            return all;
        long res = 1;
        for(int i=all-num+1;i<=all;++i)
            res *= i;
        for(int i=2;i<=num;++i)
            res /= i;
        return (int) res;
    }
}
