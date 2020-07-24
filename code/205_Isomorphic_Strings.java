/*
	此题的目标是判断字符串s是否和t有着相同的形状，判断的依据为能否通过字符映射将字符串s转化为字符串t
	对于映射，两个不同的字符不能映射为同一个字符，我们可以通过一个HashMap来解决，首先对于一个未出现过在map键中的字符，如果
	需要映射的字符已经出现在了map的value中，则表明出现了两个不同的字符不能映射为同一个字符，直接返回false
	如果当前字符串在map中对应的字符与需要映射的不同，返回false，相等则继续循环
	最后就是如果以上情况均未出现，则直接将当前映射插入map中
	
*/

class MinStack {
	
   // solution for 205
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        if(s.length()!=t.length())  return false;
        if(s.length()==0)   return true;
        for(int i=0;i<s.length();++i){
            char si = s.charAt(i),ti = t.charAt(i);
            if(map.containsKey(si)){
                if(map.get(si)!=ti)
                    return false;
            }else{
                if(map.containsValue(ti))
                    return false;
                map.put(si,ti);
            }
        }
        return true;
    }
}
