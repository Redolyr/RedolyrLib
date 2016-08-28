# -*- coding: utf-8 -*-

from platform import python_version
from enum import Enum
import os

x = [1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 51, 53, 57, 59, 61, 67, 71, 73, 79, 83, 89, 91, 97]
print(x)
print("python: ", python_version())
for i in x:
    print(i)

class testEnum(Enum):
    HELLO = [0, "HELLO"]
    WORLD = [1, "WORLD"]
    NINE = [9, "IDIOT"]

for i in testEnum:
    print(i)
    print(i.value)
    print(i.value[0])
    print(i.value[1])

print(os.name)
print(os.environ)
