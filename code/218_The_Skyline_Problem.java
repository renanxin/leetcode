/*
	这道题目看了将近一个半小时。终于基本理解了在做什么。
首先， skyline 的点分为两种：
升序时候的 skyline 点 只可能是左侧点
降序时候的 skyline 点 只可能是右侧点

所以每当我们遇到一个更高的左侧点时，他一定是一个 skyline 点
每当我们遇到一个右侧点，高度比当前大楼都高时，就意味着要开始下降了，他也一定是一个 skyline 点。
所以我们要有一个最大堆，用来存放当前大楼的高度。top就是当前大楼的最大高度。

我们有个类 Edge,表示点，以及这个点是左侧点还是右侧点
然后我们把所有的输入转换成这些点，一个大楼有两个点。
然后排序。遵守的原则是
1 . 如果 e1.x != e2.x
那么谁小谁放前面。
2 . 如果相等
那么就有讲究了。
如果同时左边点。应该先遍历哪个呢？
如果把height 矮一些的放前面，那么这个点就会变成一个 skyline 点
然后height 更高的又出现了，又会有一个skyline点，在刚刚那个点的垂直上方。这是不对的。
所以先把 height 高一些的放前面。这样，矮一些的就不会产生skyline 点

如果同时右边点。
如果把高的放前面，那么高的会在矮的高度处产生一个skyline点
然后矮的在地平线处产生一个 skyline 点。这是不对的。
所以矮的放前面，因为高的仍然在堆里，所以矮的无法产生skyline点，然后再轮到高的，在地平线处产生一个skyline 点。

如果一个是左边点，一个是右边点。
如果把右边点放在前面，会在地平线处产生一个skyline 点，然后再进入左边点，于是在左边点处产生一个 skyline 点。于是一个垂直方向上，同时出现了两个点，是不对的。
如果把左边点放在前面，如果右边点高度比他高，那么左边点不会产生skyline 点，然后右边点产生了skyline 点，下降。
如果右边点比他低，那么左边点产生一个skyline 点，上升。然后右边点发现当前top的高度比他高，无法产生skyline 点。
*/

public class Solution {
	
   // solution for 218
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 定义返回结果
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 定义节点类
        class Point {
            int height;         // 该点的高度
            int x;              // 该点的x轴坐标
            boolean isStart;    // 表示是否为左侧点

            public Point(int height, int x, boolean isStart) {
                this.height = height;
                this.x = x;
                this.isStart = isStart;
            }

            @Override
            public String toString() {
                return "Point{" +
                        "height=" + height +
                        ", x=" + x +
                        ", isStart=" + isStart +
                        '}' + "\n";
            }
        }
        // 用于存储节点
        ArrayList<Point> points = new ArrayList<>();
        // 初始化节点集合
        for (int i = 0; i < buildings.length; ++i) {
            points.add(new Point(buildings[i][2], buildings[i][0], true));
            points.add(new Point(buildings[i][2], buildings[i][1], false));
        }
        // 对那些右侧点和左侧点相同的矩形进行融合


        // 对points进行排序
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x != o2.x)
                    return o1.x - o2.x;
                else
                    return o2.height - o1.height;
            }
        });
        // 定义优先队列
        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
		// 对每个节点开始遍历
        for (Point point : points) {
			// 如果是右侧节点
            if (point.isStart) {
				// 如果整个访问了整数个建筑或者当前节点的高度比当前队列中的最大值大，表明高度正在上升
                if (pq.isEmpty() || point.height > pq.peek()) {
					// 如果当前节点的x轴和之前加入返回结果集的节点的横坐标相同，则此时有两种情况
                    if(res.size()>0&&res.get(res.size()-1).get(0)==point.x) {
                        res.remove(res.size() - 1);
                        if(res.get(res.size()-1).get(1)==point.height) 
                            continue;
                    }
                    res.add(Arrays.asList(point.x, point.height));
                }
                pq.offer(point.height);
            } else {
                pq.remove(point.height);
                if (pq.isEmpty()) {
                    if(res.size()>0&&res.get(res.size()-1).get(0)==point.x)
                        res.remove(res.size()-1);
                    res.add(Arrays.asList(point.x, 0));
                }
                else if (point.height > pq.peek()) {
                    if(res.size()>0&&res.get(res.size()-1).get(0)==point.x)
                        res.remove(res.size()-1);
                    res.add(Arrays.asList(point.x, pq.peek()));
                }
            }
        }
        return res;
    }
}
