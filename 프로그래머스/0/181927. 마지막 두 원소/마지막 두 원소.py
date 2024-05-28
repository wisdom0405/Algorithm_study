def solution(num_list):
    i = len(num_list) - 1
    if num_list[i] > num_list[i-1]:
        num_list.append(num_list[i] - num_list[i-1])
    else : 
        m = 2 * num_list[i]
        num_list.append(m)
    return num_list