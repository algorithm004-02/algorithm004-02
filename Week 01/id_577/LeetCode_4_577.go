/**
Way 1: merge two into one and sort it.

func merge(nums1 []int, m int, nums2 []int, n int)  {
    for i:= 0; i < n ; i++ {
        nums1[m+i] = nums2[i]
       
    }
    
     
    sort.Ints(nums1)
    
}
*/

/**
Way 2: merge from front to end using two pointers using  extra nums1 copy



func merge(nums1 []int, m int, nums2 []int, n int)  {
    nums1_copy := make([]int, m)
    
    for i:=0; i < m; i ++ {
        nums1_copy[i] =nums1[i]
    }
     
    
    //compare nums1 copy with nums2
    
    p, p1, p2 := 0, 0, 0
    
    for (p1 < m && p2 < n) {
        if nums1_copy[p1] < nums2[p2] {
            
            nums1[p] = nums1_copy[p1]
            p1++
            
        } else {
            
            nums1[p] = nums2[p2]
            p2++
            
        }
        
        p++
    }
    
    //After loop, check left nums1 copy or nums2
    
    for ( p1 < m ) {
        
        nums1[p] = nums1_copy[p1]
        p1++
        p++ 
        
    }
    
    
    for (p2 < n) {
        
        nums1[p] = nums2[p2]
        p2++
        p++ 
        
    }
}

*/


/*Way 3: 
Iterate from end to front using nums1 extra space
*/

func merge(nums1 []int, m int, nums2 []int, n int)  {
    
    p, p1, p2:= m+n-1, m-1, n-1
    
    for (p1 >= 0 && p2 >= 0) {
        if nums1[p1] < nums2[p2] {
            nums1[p] = nums2[p2]
            p2--
        } else {
            nums1[p] = nums1[p1]
            p1--
        }
        p--
    }
    
    //if is there any missing in nums2, insert them into nums1 front
    
    for i:=0; i<p2+1; i++ {
        nums1[i] = nums2[i]
    }
    
    
    
    
    
}