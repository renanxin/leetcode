/*

*/

public class Solution {
	
   // 存储的变量
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        // n的取值过小或者过大，或者k的取值大于9，导致无法保证每个元素均不相同
        if(n<((1+k)*k/2) || k >9 || n>((19-k)*k/2))
            return res;
        // 开始从这k的元素的可能取值依次遍历
        addElement(k,n,9);
        return res;
    }

    /**
     * 用于将合适的数组添加进res
     * @param k     可用元素的个数
     * @param remain        剩余的求和值
     * @param max         表示这k个数中最大值值
     */
    public void addElement(int k,int remain,int max){
        // 在循环过程中用于表示从begin_index的末尾开始添加元素
        int begin_index = 0;
        // k为1的话直接在res上加添一个[remain]
        if(k==1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(remain);
            res.add(list);
            return;
        }
        // 设置从res开始添加元素的标记
        int begin = res.size();
        for(int max_item=k;max_item<max+1;++max_item){
			// 当前max_item的值不符合要求，第一个判断的是remian比这k个数的最小和还小，第二项为remian比这k个元素的最大和还大
            if(remain<(max_item+k*(k-1)/2)||remain>(max_item+max_item+1-k)*k/2)
                continue;
            addElement(k-1,remain-max_item,max_item-1);
            for(int j=begin;j<res.size();++j)
                res.get(j).add(max_item);
            begin = res.size();
        }
    }
}
