
def add(x, y):
    return x + y

def my_function(num):
    first = 0
    second = 1
    
    for i in range(num):
        added = add(first, second)
        print(added)
        first = second
        second = added

fib =  int (input("Enter how many fibonacci number do you want?"))
my_function(fib)
