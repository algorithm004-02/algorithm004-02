int* relativeSortArray(int* arr1, int arr1Size, int* arr2, int arr2Size, int* returnSize){
       int mark[1001]={0};
   
    for(int i=0;i<arr1Size;i++)
    {
        mark[arr1[i]]++;
    }
    int j=0;
    for(int i=0;i<arr2Size;i++)
    {
        
        if(mark[arr2[i]]>0)
        {	
            for(int k=mark[arr2[i]];k>0;k--)
            {
                arr1[j]=arr2[i];
            
                j++;
                mark[arr2[i]]--;
            }
        }
    }
    printf("\n");
    for(int i=0;i<1001;i++)
    {
        if(mark[i]>0)
        {
            for(int k=mark[i];k>0;k--)
            {
                arr1[j]=i;
                j++;
                mark[i]--;
            }
           
        }
    }
    *returnSize=arr1Size;
    return arr1;
}
