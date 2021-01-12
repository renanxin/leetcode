import java.util.*;



class Solution{

    // solution for 316
    public String removeDuplicateLetters(String s) {
        // 从后往前遍历，得到每个元素的个数
        int[] count = new int[26];
        for(int i=s.length()-1;i>=0;--i){
            count[s.charAt(i)-'a'] += 1;
        }
        int idx = 0;
        char[] tmp = new char[27];
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();++i){
            if(set.contains(s.charAt(i))){
                for(int j=0;j<idx;++j){
                    if(s.charAt(i)==tmp[j]){
                        int k = j+1;
                        while(k<idx){
                            if(tmp[k]>tmp[j]){
                                if(count[tmp[k]-'a']<1)
                                    break;
                            }else{
                                for(int p=j;p<idx-1;++p)
                                    tmp[p] = tmp[p+1];
                                tmp[idx-1] = s.charAt(i);
                                break;
                            }
                            k++;
                        }
                    }
                }
            }else{
                tmp[idx++] = s.charAt(i);
                set.add(s.charAt(i));
            }
            count[s.charAt(i)-'a'] -= 1;
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<idx;++i)
            builder.append(tmp[i]);
        return builder.toString();
    }
}
