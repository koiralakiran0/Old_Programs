#E4_Divisors.py

num = int(input("Enter a number"))

ls = range(2,num)

print([num2 for num2 in ls if num % num2 == 0])