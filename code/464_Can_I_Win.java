import java.util.*;


/**
 * 这道题给了我们一堆数字，然后两个人，每人每次选一个数字，看数字总数谁先到给定值，有点像之前那道 Nim Game，但是比那题难度大。
 * 我刚开始想肯定说用递归啊，结果写完发现 TLE 了，后来发现我们必须要优化效率，使用 HashMap 来记录已经计算过的结果。我们首先来看如果给定的数字范围大于等于目标值的话，
 * 直接返回 true。如果给定的数字总和小于目标值的话，说明谁也没法赢，返回 false。然后我们进入递归函数，首先我们查找当前情况是否在 HashMap 中存在，
 * 有的话直接返回即可。我们使用一个整型数按位来记录数组中的某个数字是否使用过，我们遍历所有数字，将该数字对应的 mask 算出来，
 * 如果其和 used 相与为0的话，说明该数字没有使用过，我们看如果此时的目标值小于等于当前数字，说明已经赢了，或者调用递归函数，如果返回 false，
 * 说明也是第一个人赢了。为啥呢，因为当前已经选过数字了，此时就该对第二个人调用递归函数，只有返回的结果是 false，我们才能赢，所以此时我们 true，
 * 并返回 true。如果遍历完所有数字，标记 false，并返回 false，参见代码如下：
 */

class Solution{

    // solution for 464
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal<=maxChoosableInteger) return true;
        if(maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal)  return false;
        Map<Integer,Boolean> dp = new HashMap<>();
        return canWin(maxChoosableInteger,desiredTotal,0,dp);
    }

    /**
     *
     * @param maxChoosableInteger   可使用的最大值
     * @param desiredTotal  目标值
     * @param use   由于maxChoosableInteger<=20，所以使用一个整数的位存储使用过的数字
     * @param dp    存储中间use对应的值
     * @return  是否可以赢
     */
    private boolean canWin(int maxChoosableInteger,int desiredTotal,int use,Map<Integer,Boolean> dp){
        if(dp.containsKey(use))    return dp.get(use);
        for(int i=1;i<=maxChoosableInteger;++i){
            if((1<<i&use)==0){
                if(desiredTotal<=i || !canWin(maxChoosableInteger,desiredTotal-i,(1<<i)|use,dp)){
                    dp.put(use,true);
                    return true;
                }
            }
        }
        dp.put(use,false);
        return false;
    }
}
