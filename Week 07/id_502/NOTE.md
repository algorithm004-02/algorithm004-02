# NOTE
**排序算法**
**插入排序**

        def insertSort(arr):
            length = len(arr)
            for i in range(1,length):
                x = arr[i]
                for j in range(i,-1,-1):
                    if x < arr[j-1]:
                        arr[j] = arr[j-1]
                    else:
                        break
                arr[j] = x
        
**选择排序**

        def Selectionsort1():
            A = [-9, -8, 640, 25, 12, 22, 33, 23, 45, 11, -2, -5, 99, 0]
            for i in range(len(A)):
                min = i
                for j in range(i + 1, len(A)):
                    if A[min] > A[j]:
                        min = j
                
                A[i], A[min] = A[min], A[i]
                
**希尔排序**

    def shellSort(arr): 
  
    n = len(arr)
    gap = int(n/2)
  
    while gap > 0: 
  
        for i in range(gap,n): 
  
            temp = arr[i] 
            j = i 
            while  j >= gap and arr[j-gap] >temp: 
                arr[j] = arr[j-gap] 
                j -= gap 
            arr[j] = temp 
        gap = int(gap/2)
        
**堆排序**

    def heapify(arr, n, i): 
        largest = i  
        l = 2 * i + 1     # left = 2*i + 1 
        r = 2 * i + 2     # right = 2*i + 2 
        if l < n and arr[i] < arr[l]: 
            largest = l 
      
        if r < n and arr[largest] < arr[r]: 
            largest = r 
      
        if largest != i: 
            arr[i],arr[largest] = arr[largest],arr[i]
            heapify(arr, n, largest) 
        
    def heapSort(arr): 
        n = len(arr) 
        for i in range(n, -1, -1): 
            heapify(arr, n, i) 
    
        for i in range(n-1, 0, -1): 
            arr[i], arr[0] = arr[0], arr[i]   # 交换
            heapify(arr, i, 0) 
            
            
**冒泡排序**

    def bubbleSort(arr):
        n = len(arr)
    
        # 遍历所有数组元素
        for i in range(n):
     
            # Last i elements are already in place
            for j in range(0, n-i-1):
     
                if arr[j] > arr[j+1] :
                    arr[j], arr[j+1] = arr[j+1], arr[j]
                    
    
**快速排序**

    def partition(arr,low,high): 
        i = ( low-1 )         # 最小元素索引
        pivot = arr[high]     
      
        for j in range(low , high): 
      
            # 当前元素小于或等于 pivot 
            if   arr[j] <= pivot: 
              
                i = i+1 
                arr[i],arr[j] = arr[j],arr[i] 
      
        arr[i+1],arr[high] = arr[high],arr[i+1] 
        return ( i+1 ) 

    def quickSort(arr,low,high): 
        if low < high: 
      
            pi = partition(arr,low,high) 
      
            quickSort(arr, low, pi-1) 
            quickSort(arr, pi+1, high) 

**归并排序**

    def merge(arr, l, m, r): 
        n1 = m - l + 1
        n2 = r- m 
  
        # 创建临时数组
        L = [0] * (n1)
        R = [0] * (n2)
      
        # 拷贝数据到临时数组 arrays L[] 和 R[] 
        for i in range(0 , n1): 
            L[i] = arr[l + i] 
      
        for j in range(0 , n2): 
            R[j] = arr[m + 1 + j] 
      
        # 归并临时数组到 arr[l..r] 
        i = 0     # 初始化第一个子数组的索引
        j = 0     # 初始化第二个子数组的索引
        k = l     # 初始归并子数组的索引
      
        while i < n1 and j < n2 : 
            if L[i] <= R[j]: 
                arr[k] = L[i] 
                i += 1
            else: 
                arr[k] = R[j] 
                j += 1
            k += 1
      
        # 拷贝 L[] 的保留元素
        while i < n1: 
            arr[k] = L[i] 
            i += 1
            k += 1
      
        # 拷贝 R[] 的保留元素
        while j < n2: 
            arr[k] = R[j] 
            j += 1
            k += 1
  
    def mergeSort(arr,l,r): 
        if l < r: 
            m = int((l+(r-1))/2)
            mergeSort(arr, l, m) 
            mergeSort(arr, m+1, r) 
            merge(arr, l, m, r) 