// solution for 380
class RandomizedSet {

    Object[] store;
    int size = 10001;
    int tmpSize = 0;
    Random random =new Random();
    ArrayList<Integer> alist = new ArrayList<Integer>();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        store = new Object[10001];
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        int index = Math.abs(val)%size;
        if(store[index]==null)
            store[index] = new LinkedList<Integer>();
        LinkedList<Integer> list = (LinkedList<Integer>)store[index];
        if(list.contains(new Integer(val)))
            return false;
        list.add(val);
        tmpSize++;
        alist.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int index = Math.abs(val)%size;
        if(store[index]==null)  return false;
        LinkedList<Integer> list = (LinkedList<Integer>)store[index];
        boolean ex = list.contains(new Integer(val));
        if(!ex)
            return false;
        list.remove(new Integer(val));
        tmpSize--;
        alist.remove(new Integer(val));
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int num = random.nextInt(tmpSize),tmp;
        return alist.get(num);
    }
}