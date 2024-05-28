def solution(n, control):
    answer = 0
    w_count = control.count('w')
    s_count = control.count('s')
    d_count = control.count('d')
    a_count = control.count('a')
    
    answer = n + w_count - s_count + 10 * d_count - 10 * a_count
    return answer
