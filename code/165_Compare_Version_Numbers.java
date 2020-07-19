/*
	此题的目标就是比较两个字符串代表的版本号的大小：
		首先使用split方法将字符串分割成多个字符串数组，再从头依次比较字符串大小
	
*/

class MinStack {
	// solution for 165
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int min_len = Math.min(split1.length,split2.length),tmp1,tmp2;
        for(int i=0;i<min_len;++i){
            tmp1 = Integer.parseInt(split1[i]);
            tmp2 = Integer.parseInt(split2[i]);
            if(tmp1>tmp2)
                return 1;
            else if(tmp1<tmp2)
                return -1;
        }
        if(split1.length>min_len){
            for(int i=min_len;i<split1.length;++i){
                if(Integer.parseInt(split1[i])>0)
                    return 1;
            }
        }
        if(split2.length>min_len){
            for(int i=min_len;i<split2.length;++i){
                if(Integer.parseInt(split2[i])>0)
                    return -1;
            }
        }
        return 0;
    }
}
