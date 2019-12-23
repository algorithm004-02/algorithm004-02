int lengthOfLastWord(char * s){
    int size = 0;
    int index  = 0;
    int preType = 1;
    while(*(s + index)!='\0'){
        if( (s[index]>=65 && s[index]<=90) || (s[index]>=97 && s[index]<=122) ){
            if(!preType){
                size = 0;
            }
            size++;
            preType = 1;
        }else if(*(s+index) == ' '){
            preType = 0;
        }
        index++;
    }
    return size;
}