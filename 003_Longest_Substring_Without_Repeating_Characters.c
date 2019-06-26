int lengthOfLongestSubstring(char * s){
    int slen = strlen(s);
    int letter[150] = {0};  // 存储子串中出现过的字母
    int local[150]={-1};    // 存储子串中出现字母对应着原字符串中的位置
    int maxlen = 1,nowlen=0,left=0,right=0;
    // 字符串长度小于2
    if(slen<2)
    return slen;
    for(int i=0;i<slen;++i){
        // 判断该字母是否在子串中出现过
        if(++letter[(int)s[i]]==1){
            ++nowlen;
            local[(int)s[i]]=i;
            continue;
        }
        maxlen=maxlen>nowlen?maxlen:nowlen;
        nowlen = i - local[(int)s[i]];
        right = local[(int)s[i]];
        for(int j=left;j<right;++j){
            letter[(int)s[j]]=0;
            local[(int)s[j]]=-1;
        }
        letter[(int)s[i]] = 1;
        local[(int)s[i]] = i;
        left=right+1;
    }
    return maxlen>nowlen?maxlen:nowlen;
}
