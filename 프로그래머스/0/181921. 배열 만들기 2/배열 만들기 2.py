def solution(l, r):
    answer = []
    for num in range(l, r+1):
        if set(str(num)) <= {'0','5'}:
            answer.append(num)
    if answer :
        return answer
    else :
        return [-1]