def solution(start_num, end_num):
    answer = []
    n = start_num - end_num + 1
    for i in range(n):
        answer.append(start_num)
        start_num -= 1
    return answer