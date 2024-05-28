def solution(num_list):
    for i in range(5) :
        min_num = min(num_list)
        num_list.remove(min_num)
    return sorted(num_list)