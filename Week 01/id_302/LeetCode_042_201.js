/**
 * @param {number[]} height
 * @return {number}
 */

/***
  * Approach 1 - brutal force, time complexity O(n^2).
  */

 function trap1(height) {
//     lmax, rMax
//     find each element's lMax and rMax
//     use Max.min(lMax, rMax) - ele's height
//     to get determine if there are trapping water
        
    let res = 0
    
    for(let i=0; i<height.length; i++){
//         initial lmax and rMax.
        let lMax = 0, rMax = 0;
//         find the lmax 
        for(let j=0; j<i; j++) {
            lMax = Math.max(lMax, height[j]);
        }
        
// find the rMax 
        for(let j=i +1; j<height.length; j++) {
            rMax = Math.max(rMax, height[j]);
        }
        
        console.log(rMax);
        
        
        let water = Math.min(lMax, rMax) - height[i];
        console.log(water);
        if(water > 0) res += water;
    }
    
    return res;
}

 /***
  * Approach 2 - dynamic programming, time complexity O(n).
  */
function trap2(height) {
//     use two hash to store lMax and rMax for each element.
//     evaluate water after the hashing 
    let res =0, lMax = {}, rMax = {};
    
    lMax[0] = height[0]
    
    for(let i = 1; i<height.length; i++) {
        
        lMax[i] = Math.max(lMax[i-1], height[i]);
    }
    
    rMax[height.length -1] = height[height.length -1]
    
    for(let i = height.length -2; i>=0; i--) {
        rMax[i] = Math.max(rMax[i + 1], height[i]);
    }
    
    for(let i=0; i<height.length; i++) {
        let water = Math.min(lMax[i], rMax[i]) - height[i];
        
        if(water > 0) res += water;
    }
    
    return res;
        
}