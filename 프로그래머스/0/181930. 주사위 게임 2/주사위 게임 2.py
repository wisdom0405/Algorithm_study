import math
def solution(a, b, c):
    remove_same = {a, b, c}
    count = len(remove_same)
    if count == 3 :
        return a + b + c
    elif count == 2 :
        return (a + b + c) * (pow(a,2) + pow(b,2) + pow(c,2))
    elif count == 1 :
        return (a + b + c) * (pow(a,2) + pow(b,2) + pow(c,2)) * (pow(a,3) + pow(b,3) + pow(c,3))
    else : 
        return 0
    