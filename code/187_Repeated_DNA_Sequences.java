/*
	此题目标是从一段DNA序列中找到重复出现过的长度为10的子串，可以通过将字符拼接成一个int来快速判断是否出现过
	将A，C，G，T分为映射为1，2，3，4，使用掩码0x3ffff得到连续9个字符对应的int，再依次循环，每次去除第一个字符并添加一个新的字符
	如果该字符出现过，则添加到最后的返回集中
	
*/

public class Solution {

    // solutiopn for 187
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> res = new HashSet<>();
        if(s.length()<=10)
            return new ArrayList<>(res);
        HashSet<Integer> tmp = new HashSet<>();
        HashMap<Character,Integer> reflect = new HashMap<>();
        reflect.put('A',0);
        reflect.put('C',1);
        reflect.put('G',2);
        reflect.put('T',3);
        int mask = 0x3ffff,cur=0;
        for(int i=0;i<9;++i)
            cur = cur<<2|reflect.get(s.charAt(i));
        for(int i=9;i<s.length();++i){
            cur = (cur&mask)<<2|reflect.get(s.charAt(i));
            if(tmp.contains(cur))
                res.add(s.substring(i-9,i+1));
            else
                tmp.add(cur);
        }
        return new ArrayList<>(res);
    }
}
