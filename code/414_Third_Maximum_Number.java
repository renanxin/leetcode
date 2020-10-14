class RandomizedCollection {

    // solution for 414
    int flag = -1;
    public int thirdMax(int[] nums) {
        int[] maxNum = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for(int num:nums){
            joinInNum(maxNum,num);
        }
        return flag==2?maxNum[2]:maxNum[0];
    }

    public void joinInNum(int[] maxNum,int num){
        int tmp;
        for(int i=0;i<maxNum.length;++i){
            if(num>maxNum[i]){
                tmp = maxNum[i];
                maxNum[i] = num;
                num = tmp;
                if(flag<i){
                    flag = i;
                    return;
                }
            }if(num==maxNum[i]){
                if(i==flag+1)
                    flag = i;
                return;
            }
        }
    }
}