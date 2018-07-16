#E2_OddorEven

number = int(input("Enter a number: "))
if number % 4 == 0:
	print("The number is even and multiple of 4")
elif number % 2 == 0:
	print("The number is even")
else:
	print("The number is odd")

extra = input("Enter Yes if you want to go to the second version")
if extra == "Yes":
	num = int(input("Enter a number: "))
	check = int(input("Enter number to divide by: "))
	if num % check == 0:
		print(str(num) + " can divide " + str(check))


