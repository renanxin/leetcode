/*
	在之前那题的基础上添加了一个sorted数组，对于graph，对于i位置存储的是i的所有先导课程，这样对graph开始遍历，遍历到一个没有先导课
	的课程之后将添加进sorted，然后对其它先导课进行遍历保证其完成，最后将sorted出栈完成输出即可
*/

public class Solution {
	
   // solution for 210
    HashSet<Integer> visited,visiting;
    Stack<Integer> sorted;
    List<Integer> graph[];

    public int[] findOrder(int numCourses,int[][] prerequisites){
        visited = new HashSet<>();
        visiting = new HashSet<>();
        sorted = new Stack<>();
        graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;++i)
            graph[i] = new ArrayList<Integer>();
        for(int[] arr :prerequisites)
            graph[arr[1]].add(arr[0]);
        boolean ans = true;
        for(int i=0;i<numCourses;++i){
            if(!ans)    break;
            if(!visited.contains(i))    ans = dfs(i);
        }
        if(!ans)
            return new int[]{};
        int [] arr = new int[numCourses];
        for(int i = 0;i<numCourses;++i)
            arr[i] = sorted.pop();
        return arr;

    }

    boolean dfs(int i){
        System.out.println(i);
        visiting.add(i);
        boolean ans = true;
        for(int j:graph[i]){
            if(!ans)    break;
            if(!visited.contains(j)){
                if(visiting.contains(j))
                    return false;
                ans = ans && dfs(j);
            }
        }
        visited.add(i);
        sorted.add(i);
        visiting.remove(i);
        return ans;
    }
}
