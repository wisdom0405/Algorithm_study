def solution(ineq, eq, n, m):
    n = str(n)
    m = str(m)
    
    if eq == "=" :
        if eval(n + ineq + eq + m):
            return 1
        else:
            return 0 
    else :
        if eval(n + ineq + m):
            return 1
        else :
            return 0
    