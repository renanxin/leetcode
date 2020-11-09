import java.util.ArrayList;
import java.util.List;

class Solution{
    // solution for 766
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length < 2)    return true;
        StringBuilder pre = new StringBuilder();
        int str_len = matrix[0].length;
        for(int i=0;i<matrix[0].length;++i)
            pre.append(Character.toChars(matrix[0][i]));
        for(int k=1;k<matrix.length;++k){
            StringBuilder tmp = new StringBuilder();
            for(int i=0;i<matrix[0].length;++i)
                tmp.append(Character.toChars(matrix[k][i]));
            System.out.println(pre.substring(0,str_len-1));
            System.out.println(tmp.substring(1,str_len));
            if(pre.substring(0,str_len-1).equals(tmp.substring(1,str_len))){
                pre = tmp;
            }else{
                return false;
            }
        }
        return true;
    }
}
