/*
	可以利用栈的方法对表达式进行计算
*/

public class Solution {

   // solution for 227
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> singals = new Stack<>();
        int tmp=-1;
        HashMap<Character, Integer> signalMap = new HashMap<>();
        signalMap.put('+',1);
        signalMap.put('-',1);
        signalMap.put('*',2);
        signalMap.put('/',2);
        s=s.replace(" ","");
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9') {
                tmp = (tmp==-1?0:tmp) * 10 + s.charAt(i) - '0';
                if(i==s.length()-1&&tmp!=-1)
                    nums.push(tmp);
            }else {
                nums.push(tmp);
                tmp = -1;
                while (true) {
                    if (singals.isEmpty() || signalMap.get(singals.peek()) < signalMap.get(s.charAt(i))) {
                        singals.push(s.charAt(i));
                        break;
                    }
                    else {
                        Character singal = singals.pop();
                        Integer a2 = nums.pop();
                        Integer a1 = nums.pop();
                        int res;
                        switch (singal) {
                            case '-':
                                res = a1 - a2;
                                break;
                            case '+':
                                res = a1 + a2;
                                break;
                            case '*':
                                res = a1 * a2;
                                break;
                            default:
                                res = a1 / a2;
                        }
                        nums.push(res);
                    }
                }
            }
        }
        while(!singals.isEmpty()){
            Character singal = singals.pop();
            Integer a2 = nums.pop();
            Integer a1 = nums.pop();
            int res;
            switch (singal){
                case '-':
                    res = a1-a2;
                    break;
                case '+':
                    res = a1+a2;
                    break;
                case '*':
                    res = a1*a2;
                    break;
                default:
                    res = a1/a2;
            }
            nums.push(res);
        }
        return nums.pop();
    }
}
