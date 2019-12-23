char * toLowerCase(char * str){
    int i;
    if(str==NULL)
        return;
    for(i=0;str[i]!='\0';i++){
        if(str[i]>='A'&&str[i]<='Z'){
        str[i]=str[i]+32;
        }
    }
    return str;
}