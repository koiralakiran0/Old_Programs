def reverseString(str1):
    result = str1.split(" ")
    result = [element for element in reversed(result)]
    result = " ".join(result)
    return result

print(reverseString("My name is Kiran"))
