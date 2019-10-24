#E12 List Ends
import random

def startEnd(ls):
    return [ls[0], ls[len(ls) - 1 ]]

ls = [random.randint(0,9) for x in range(0,10)]
print (ls)
print (startEnd(ls) )
