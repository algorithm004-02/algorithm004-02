height = [1,8,6,2,5,4,8,3,7]
##################枚举O(n^2)#################
# 超时！
# res = 0
# i = 0
# j = i-1
# for i in range(len(height)-1):
#     for j in range(len(height)):
#         area=(j-i)*min(height[i],height[j])
#         res= max(res,area)
#         j+=1
#     i+=i
# print(res)
#####################左右边界收敛O(n)#################
# 超时！
res,i,j = 0,0,len(height)-1
while i<j:
    res=max(res,height[i]*(j-i))
    if height[i]<height[j]:
        i=+1
    else:
        j-=1
print(res)
########################
# res, i, j = 0, 0, len(height) - 1
# while i < j: 
#     res, i, j = (max(res,  height[i] * (j - i)), i + 1, j) if height[i] < height[j] else (max(res,  height[j] * (j - i)), i, j - 1)
# print(res)


