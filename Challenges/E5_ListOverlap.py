#E5_ListOverlap

import random

ls1 = [random.randint(0,9) for x in range(0,10)]
ls2 = [random.randint(0,9) for x in range(0,10)]

print(ls1 + [0,0,0,0,0] + ls2)