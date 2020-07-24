/*
	此题就是判断图中是否存在闭环，首先可以利用prerequisites构建一个图，之后从每个节点出发，进行深度遍历，
	如果遍历到未遍历过的节点，则将其的访问标记设置为true，遍历到访问过的节点，则表示存在闭环，这里为了减少
	遍历的次数，还特意添加了permMark，与tempMark仅仅存储当前遍历过程中的访问情况不同，它记录的是从某个节点开始遍历是否会存在环，这样就减少了不少重复的工作
*/

public class Solution {
	
   / solution for 207
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjust = new ArrayList<>();
        for(int i=0;i<numCourses;++i)
            adjust.add(new ArrayList<Integer>());
        for(int[] e:prerequisites)
            adjust.get(e[1]).add(e[0]);
        // 永久标记，表示从该节点出发不会出现环结构
        boolean[] permMark = new boolean[numCourses];
        // 暂时标记，表示在此次遍历过程中该节点被遍历过
        boolean[] tempMark = new boolean[numCourses];

        for(int i=0;i<numCourses;++i){
            // 遍历过程中出现了闭环
            if(existsCycle(i,permMark,tempMark,adjust))
                return false;
        }
        return true;
    }

    // judge from the index i weather there exists a cycle
    public boolean existsCycle(int i,boolean[] permMark,boolean[] tempMark,List<List<Integer>> adjust){
        if(permMark[i])
            return false;
        if(tempMark[i])
            return true;
        tempMark[i] = true;
        for(int v:adjust.get(i))
            if(existsCycle(v,permMark,tempMark,adjust))
                return true;
        tempMark[i] = false;
        permMark[i] = true;
        return false;
    }
}
