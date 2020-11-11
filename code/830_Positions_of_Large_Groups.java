import java.util.*;

/**
 * 对于寻找这种连续子串，我们可以每次寻找从当前遍历点向前搜寻满足条件的个数，设置pvc表示子串开始位置，
 * 这是因为遇到了值大于R的，肯定不能满足，如果遇到介于L和R之间的值，从当前节点可以有i-pvc+1个满足条件的字串
 * 遇到小于的值，则至少需要包含往前介于L和R之间的值开始的序列，所以是pvc
 */
class Solution{

    // solution for 825
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int begin = 0;
        for(int i=1;i<s.length();++i){
            if(s.charAt(i)!=s.charAt(i-1)) {
                if(i-begin>2){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(begin);
                    tmp.add(i-1);
                    begin = i;
                    res.add(tmp);
                }
                begin = i;
            }
        }
        if(s.length()-begin>2){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(begin);
            tmp.add(s.length()-1);
            res.add(tmp);
        }
        return res;
    }
}
