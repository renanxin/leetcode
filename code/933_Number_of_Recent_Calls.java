import java.util.ArrayDeque;
import java.util.Deque;

// solution for 933
class RecentCounter {

    Deque<Integer> deque;
    int len;

    public RecentCounter() {
        len = 0;
        deque = new ArrayDeque<>();
    }

    public int ping(int t) {
        while(!deque.isEmpty() && t-deque.getFirst()>3000){
            deque.removeFirst();
            --len;
        }
        deque.addLast(t);
        ++len;
        return len;
    }
}