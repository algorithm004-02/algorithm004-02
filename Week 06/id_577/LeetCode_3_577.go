/*type UnionFind struct {
    
    count int;
    
    parent []int;
    
    
    
}

func newUnionFind(n int) *UnionFind {
    
    
    
    unions := make([]int, n)
    for i:=0; i< n; i++ {
        unions[i] = i
    }
    
    return &UnionFind{count:n,
                      parent: unions,}
    
    
    
}

func(this *UnionFind) find(p int) int {
    
    
    for p != this.parent[p] {
        this.parent[p]= this.parent[this.parent[p]]
        p= this.parent[p]
        
    }
    
    return p
    
}

func (this *UnionFind)union(p int, q int) {
    
    rootP := find(p)
    rootQ := find(q)
    
    if rootP ==  rootQ {
        
        return 
    }
    
    parent[rootP] = rootQ
    this.count--
    
    
    
    
}*/


func findCircleNum(M [][]int) int {
    
    //check boundary
    
    if M == nil {
        return 0
    }
    
    //Initialize
    
    length := len(M)
    
    parent := make([]int, len(M))
    
    for i:=0; i < length; i++ {
        parent[i] = -1
    }
    
    
    //Check 
    for i:=0; i< length; i++ {
        for j:=0; j< len(M[0]); j++ {
            
            if M[i][j] == 1 &&  i != j {
                //Union
                union(parent, i, j)
            }
            
        }
    }
    
    //count parent -1 after union
    count := 0
    
    for i:=0; i< length; i++ {
        if parent[i] == -1 {
            count++
        }
    }
    
    return count
    
    
}

func find(parent []int, i int) int{
    if parent[i] == -1 {
        return i
    }
    
    return find(parent, parent[i])
}

func union(parent []int, p int, q int) {
    rootp := find(parent, p)
    
    rootq := find(parent, q)
    
    if rootp != rootq {
        parent[rootp] = rootq
    } 
    
}