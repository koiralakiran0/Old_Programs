string = input("Enter a string: ")

#if string[0, len(string)/2] == (string[len(string)/2, len(string)])
#    print("YAYA")
#else
#    print("NAH")
# x = int(int(len(string))/2)
# print(string[0:x])


# print(string[x:len(string)])

# if len(string)%2 == 0:
#     print("YAYAY")

# if string[0:x] == string[x:int(len(string)):-1]:
#     print("mc")
    
if string == string[::-1]:
    print("PALINDROME")
else:
    print("NOT A PALINDROME")