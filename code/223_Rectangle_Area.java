/*
	首先判断这两个图形是否由公共区域或者某个图形的面积为0，满足这种情况直接返回二者的面积之和
	接下来就是求公共区域的面积，分别取这两个图形对应坐标位置的最小值和最大值，比如左下角就是取最大值，右上角的点
	就是求最小值，这样做差就可以得到公共区域图形的长和宽
	最后返回的时候将这两个图形的面积和减去公共区域的面积即可
*/

public class Solution {
	

   // solution for 223
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A == C || B == D || E == G || F == H || D <= F || H <= B || C <= E||G<=A)
            return (C - A) * (D - B) + (G - E) * (H - F);
        int height = (B > F ? B : F) - (D > H ? H : D);
        if (height < 0)
            height = -height;
        int width = (C > G ? G : C) - (E>A?E:A);
        return (C - A) * (D - B) + (G - E) * (H - F) - width * height;
    }
}
