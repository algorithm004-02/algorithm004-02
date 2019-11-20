class Solution:
    def findWords(self, b, words):
        #build trie
        trie={}
        #n is node
        for w in words:
            n=trie
            for c in w: n=n.setdefault(c,{})
            n["#"]=1
            #trie["#"]=1 #error two

        #def dfs
        def dfs(y,x,node,pre,visited):
            #stop
            if "#" in node:r.add(pre)
            #do this level
            for (yt,xt) in ((-1,0),(1,0),(0,-1),(0,1)): #4times
                #y=y+i    #error one
                y1=y+yt
                x1=x+xt
                if      -1<x1<xx \
                    and -1<y1<yy \
                    and b[y1][x1] in node \
                    and (y1,x1) not in visited:
                    dfs(y1,x1,node[b[y1][x1]],pre+b[y1][x1],visited|{(y1,x1)})
        #Traverse b
        r,yy,xx=set(),len(b),len(b[0])

        for y in range(yy):
            for x in range(xx):
                if b[y][x] in trie:
                    #dfs(y,x,trie,b[y][x],{(y,x)})
                    dfs(y,x,trie[b[y][x]],b[y][x],{(y,x)})
        return list(r)



'''  虽然可读性大大下降，但是速度没有提高

class Solution:
    def findWords(self, b, words):
        trie={}
        for w in words:
            n=trie
            for c in w: 
                n=n.setdefault(c,{}) 
            n["#"]=1
        def dfs(y,x,no,p,v):
            if "#" in no:r.add(p)
            for (i,j) in ((-1,0),(1,0),(0,-1),(0,1)):
                a,f=y+i,x+j
                if  -1<f<xx and -1<a<yy and b[a][f] in no and (a,f) not in v:
                    dfs(a,f,no[b[a][f]],p+b[a][f],v|{(a,f)})
        r,yy,xx=set(),len(b),len(b[0])
        for y in range(yy):
            for x in range(xx):
                if b[y][x] in trie:dfs(y,x,trie[b[y][x]],b[y][x],{(y,x)})
        return list(r)
'''
