import java.util.*;


/**
 * 如果 s2 在 S1 中出现了N次，那么 S2 肯定在 S1 中出现了 N/n2 次，注意这里的大写表示字符串加上重复次数组成的大字符串。
 * 所以可以得出结论，只要算出 s2 出现的次数，然后除以 n2，就可以得出 S2 出现的次数了。
 * 那么问题就是表示重复，遍历 s1 字符串 n1 次，表示每个 s1 字符串为一段，对于每段，可以得知：
    1. 出现在该段的 s2 字符串的累计出现次数
    2. 一个 nextIndex，其中 s2[nextIndex] 表示在下一段 s1 中你所要寻找的 s2 中的一个字符。(比如说 s1="abc", s2="bac", 由于第一个 s1 
        中只能匹配上 s2 中的b，那么只有在下一段 s1 中才能继续匹配 s2 中的a，所以 nextIndex=1，即a在 s2 中的位置为1；同理，比如  s1="abca", s2="bac"，
        第一个 s1 可以匹配上 s2 中的 ba，那么后面的c只能在下一段 s1 中匹配上，那么 nextIndex=2，即c在 s2 中的位置为2)
表示重复关键就在于 nextIndex，比如对于下面这个例子：
 * nextIndex 的范围从0到 s2.size()-1，根据鸽巢原理(又称抽屉原理)，你一定会找到相同的两个 nextIndex 在遍历 s1 段 s2.size()+1 次之后。在上面的例子中，
 * 重复的 nextIndex 出现在第三段，和第一段一样都为2，那么重复的 pattern 就找到了，是第二段和第三段中的 aabc，而且从第四段开始，每两段就有一个 aabc，
 * 现在的目标就是统计出整个 S1 中有多少个s2。由于 pattern 占用了两段，所以 interval 为2，然后看整个 S1 中有多少个这样的两段，
 * repeat = (n1 - start) / interval。start 表示 pattern 的起始段数，之前的不是 pattern，然后算在整个 S1 中有多少个 pattern 
 * 出现，patternCnt = (repeatCnt[k] - repeatCnt[start]) * repeat，注意这里的 repeatCnt[k] - repeatCnt[start] 表示一个 pattern 
 * 中有多少个字符串 s2，个人感觉一般来说都是1个。然后算出剩下的非 pattern 的字符串里能包含几个 s2，remainCnt = repeatCnt[start + (n1 - start) % interval]，
 * 然后把 patternCnt + remainCnt 之和算出来除以 n2 就是需要的结果啦。如果 pattern 未曾出现，那么我们直接用 repeatCnt[n1] / n2 也能得到正确的结果
 */

class Solution{

    // solution for 466
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(s1==null || s2==null || s2.length()*n2 > s1.length()*n1) return 0;
        if(s2.equals("")) return 0;
        HashSet<Character> chars = new HashSet<>();
        for(int i=0;i<s1.length();++i)
            chars.add(s1.charAt(i));
        for(int i=0;i<s2.length();++i){
            if(!chars.contains(s2.charAt(i)))
                return 0;
        }
        int str2Index = 0;
        int k = 0;  // 使用了s1的个数
        int count = 0;  // 使用了s2的个数
        while(k<n1){
            for(int i=0;i<s1.length();++i){
                if(s1.charAt(i)==s2.charAt(str2Index)){
                    str2Index+=1;
                    if(str2Index==s2.length()){
                        count+=1;
                        str2Index=0;
                    }
                }
            }
            k+=1;
            if(str2Index==0){
                if(n1%2==0 || n1 < 2)
                    count*=n1/k;
                else
                    count=(count*(n1-1)/k)+1;
                break;
            }
        }
        return count/n2;
    }


    public int getMaxRepetitions_better(String s1, int n1, String s2, int n2) {
        if(s1==null || s2==null || s2.length()*n2 > s1.length()*n1) return 0;
        if(s2.equals("")) return 0;
        HashSet<Character> chars = new HashSet<>();
        for(int i=0;i<s1.length();++i)
            chars.add(s1.charAt(i));
        for(int i=0;i<s2.length();++i){
            if(!chars.contains(s2.charAt(i)))
                return 0;
        }
        int str2Index = 0;
        int cnt = 0;  // 使用了s1的个数
        int count = 0;  // 使用了s2的个数
        int[] repeatCnt = new int[n1+1];
        int[] nextIdx = new int[n1+1];
        for(int k=1;k<=n1;++k){
            for(int i=0;i<s1.length();++i){
                if(s1.charAt(i)==s2.charAt(str2Index)){
                    str2Index++;
                    if(str2Index==s2.length()){
                        count++;
                        str2Index = 0;
                    }
                }
            }

            repeatCnt[k] = count;
            nextIdx[k] =  str2Index;
            for(int i=0;i<k;++i){
                if(nextIdx[i]==str2Index){
                    int interval = k - i;
                    int repeat = (n1 - i) / interval;
                    int patternCnt = (repeatCnt[k] - repeatCnt[i]) * repeat;
                    int remainCnt = repeatCnt[i + (n1 - i) % interval];
                    return (patternCnt + remainCnt) / n2;
                }
            }
        }
        return repeatCnt[n1]/n2;
    }
}
