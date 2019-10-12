list1 = [9, 8, 8]
# print(type(list1[2]))
# print(type(list1))

# str1 = list(map(str, list1))
# print(list1)
# print(str1)
# print(type(str1))

# str2 = ''.join(map(str, list1))
# print(str2)
# print('str2的类型为%s' % (type(str2)))

# int2 = int(str2)+1
# str3 =str(int(''.join(map(str, list1)))+1)
# print(list(map(int,str(int(''.join(map(str, list1)))+1))))
for i in range(len(list1)):
    if list1[-1-i] == 9:
        list1[-1-i] = 0
        if -1-i == -len(list1):
            list1[-1-i] =1
            list1.append(0)
            print(list1)
    else:
        list1[-1-i] +=1
        print(list1) 
        break

