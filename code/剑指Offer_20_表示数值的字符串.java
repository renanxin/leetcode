import leetcode.ListNode;
import leetcode.TreeNode;

import java.util.*;



class Solution{

    // 20 表示数值的字符串
    public boolean isNumber(String s) {
        s = s.trim();
        boolean signalShow = false, eShow = false, pointShow = false, numberShow = false;
        for(int i=0;i<s.length();++i){
            char a = s.charAt(i);
            switch (a){
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    numberShow = true;
                    break;
                case '+':
                case '-':
                    if(signalShow || numberShow || pointShow)
                        return false;
                    signalShow = true;
                    break;
                case 'e':
                case 'E':
                    if(eShow || !numberShow)
                        return false;
                    eShow = true;
                    signalShow = false;
                    numberShow = false;
                case '.':
                    if(eShow || !numberShow)
                        return false;
                    pointShow = true;
                    break;
                default:
                    return false;
            }
        }
        return numberShow;
    }
}
