# 066. 加一
################一句必杀########################
# print(type(digits[2]))
# print(type(digits))

# str1 = list(map(str, digits))
# print(digits)
# print(str1)
# print(type(str1))

# str2 = ''.join(map(str, digits))
# print(str2)
# print('str2的类型为%s' % (type(str2)))

# int2 = int(str2)+1
# str3 =str(int(''.join(map(str, digits)))+1)
# print(list(map(int,str(int(''.join(map(str, digits)))+1))))

##################for#########################


# def plusOne(digits):

#     for i in range(len(digits)):
#         if digits[-1-i] == 9:
#             digits[-1-i] = 0
#             if -1-i == -len(digits):
#                 # digits[-1-i] =1
#                 # digits.append(0)
#                 digits.insert(0, 1)
#         else:
#             digits[-1-i] += 1
#             break

###############while#############################
# 执行用时 :44 ms
def plusOne(digits):
    j = len(digits)-1
    while j >= 0:
        if digits[j]+1 < 10:
            digits[j] += 1
            break
        else:
            digits[j] = 0
        j -= 1

    if digits[0] == 0:
        digits.insert(0, 1)
        return digits
    else:
        return digits


#####################测试数据###################
digits = [9, 9, 9]
plusOne(digits)
print(digits)

