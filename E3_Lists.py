#E3_Lists

a_list = [1,1,2,3,5,8,13,21,34,55,89]

#for element in a_list:
#	if element < 5:
#		print(element)

#b_list = [num for num in a_list if num < 5]
#print(b_list)

#print([num for num in a_list if num < 5])

num2 = int(input("Enter a number. I will do some magic...."))
print([num for num in a_list if num < num2])

input("END")