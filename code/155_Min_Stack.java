/*
	此题的目标是设计一个MinStack类，其可以直接通过getMin获取栈中最小值
	解决的方法是在原始的array基础上添加一个minArray用来存储当前栈中最小值
	当压入一个数的时候先与minArray栈顶元素比较大小，压入二者中最小值
	
*/

class MinStack {

        private ArrayList<Integer> minArray;
        private ArrayList<Integer> array;
        /** initialize your data structure here. */
        public MinStack() {
            minArray = new ArrayList<Integer>();
            array = new ArrayList<Integer>();
        }

        public void push(int x) {
            array.add(x);
			// 当minArray栈不为空的时候，压入x和栈顶元素中较小的一个
            if(minArray.size()>0&&x>minArray.get(minArray.size()-1)){
                minArray.add(minArray.get(minArray.size()-1));
            }else
                minArray.add(x);
        }

        public void pop() {
            if(minArray.size()==0)
                return;
            minArray.remove(minArray.size()-1);
            array.remove(array.size()-1);
        }

        public int top() {
            return array.get(array.size()-1);
        }

        public int getMin() {
            return minArray.get(minArray.size()-1);
        }
    }
