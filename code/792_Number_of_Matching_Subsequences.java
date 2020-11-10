import java.util.*;


class Solution{
    // solution for 792
    public int numMatchingSubseq(String S, String[] words) {
        int res=0;
        ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<26;++i)
            tmp.add(new ArrayList<Integer>());
        for(int i=0;i<S.length();++i)
            tmp.get(S.charAt(i)-'a').add(i);
        for(String word:words){
            int index=-1;
            int i=0;
            for(;i<word.length();++i){
                List<Integer> tmp_list = tmp.get(word.charAt(i)-'a');
                int head=0,tail=tmp_list.size();
                while(head<tail){
                    int mid = head + (tail-head)/2;
                    if(tmp_list.get(mid)<=index)
                        head = mid +1;
                    else
                        tail = mid;
                }
                if(tail==tmp_list.size())
                    break;
                index = tmp_list.get(tail);
            }
            if(i==word.length())
                res += 1;
        }
        return res;
    }
}
