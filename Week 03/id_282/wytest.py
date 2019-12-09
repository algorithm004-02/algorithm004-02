aaa = ['name', 'dob', 'gender']
values = [['jason', '2000-01-01', 'male'], ['mike', '1999-01-01', 'male'],['nancy', '2001-02-01', 'female']]
mydict = [{key:value[index] for index,key in enumerate(aaa)}for value in values]
print(mydict) 
