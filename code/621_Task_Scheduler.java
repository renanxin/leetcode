class Solution {

    // solution for 621
    public int leastInterval(char[] tasks, int n) {
        if(n==0)
            return tasks.length;
        int[] occ = new int[26];
        int maxOcc = 0;             //  任务出现最大次数
        int maxOccTaskNum = 0;      //  出现最大次数次的任务数
        for(char task:tasks){
            occ[task-'A'] += 1;
            int lmax = occ[task-'A'];
            if(lmax==maxOcc){
                ++maxOccTaskNum;
            }else if(lmax>maxOcc){
                maxOcc = lmax;
                maxOccTaskNum = 1;
            }
        }
        
        int unit = (n+1)*(maxOcc-1) + maxOccTaskNum;
        return unit>tasks.length?unit: tasks.length;
    }
}