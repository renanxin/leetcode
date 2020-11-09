import java.util.ArrayList;
import java.util.List;

// solution for 729
class MyCalendar {

    int START = 0;
    int END = 1;
    List<int[]> books = new ArrayList<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        int[] book = {start,end};
        int head=0,tail = books.size();

        //  寻找起始时间比待加入日程起始时间刚好大的时间
        while(head<tail){
            int mid = head + (tail-head)/2;
            if(books.get(mid)[START]>book[START])
                tail = mid;
            else
                head = mid + 1;
        }

        if(head>0){
            if(books.get(head-1)[END]>book[START])
                return false;
        }

        if(head< books.size()){
            if(books.get(head)[START]<book[END])
                return false;
        }

        books.add(head,book);
        return true;
    }
}
