/*
	由于这是对位的翻转操作，所以可以位操作，首先对于一个数n，n&1代表着n的最后一个位，我们可以将其左移
	若干个单位与res做或操作，表示该位的翻转
	
*/

public class Solution {

    // solution for 190
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int times = 31;
        int res = 0;
        while(times>=0){
            int lastDigital = n&1;
            if(lastDigital==1) res|=lastDigital<<times;
            -- times;
            n>>=1;
        }
        return res;
    }
}
