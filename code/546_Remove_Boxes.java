import java.util.*;



class Solution{

    // solution for 546
    int[][][] removeBoxesDP = new int[100][100][100];

    public int removeBoxes(int[] boxes) {
        return removeBoxesByDFS(boxes,0,boxes.length-1,0);
    }

    public int removeBoxesByDFS(int[] boxes, int begin, int end, int num) {
        if(begin>end)
            return 0;
        if(removeBoxesDP[begin][end][num]!=0)
            return removeBoxesDP[begin][end][num];
        // 初始化removeBoxesDP[begin][end][num]
        removeBoxesDP[begin][end][num] = removeBoxesByDFS(boxes,begin,end-1,0)+(num+1)*(num+1);
        for(int i=begin;i<end;++i){
            if(boxes[i]==boxes[end]){
                removeBoxesDP[begin][end][num] = Math.max(removeBoxesDP[begin][end][num],removeBoxesByDFS(boxes,begin,i,num+1)+removeBoxesByDFS(boxes,i+1,end-1,0));
            }
        }
        return removeBoxesDP[begin][end][num];
    }
}
