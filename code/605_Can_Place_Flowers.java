class Solution {

    // solution for 605
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int nums = 0;
        for(int i=0;i<flowerbed.length;++i){
            if(isValid(flowerbed,i) && flowerbed[i]!=1){
                nums++;
                flowerbed[i] = 1;
            }
        }
        return nums >= n;
    }
    
    public boolean isValid(int[] flowerbed, int index){
        if(index-1>=0){
            if(flowerbed[index-1]==1)
                return false;
        }
        if(index+1<flowerbed.length){
            if(flowerbed[index+1]==1)
                return false;
        }
        return true;
    }
}