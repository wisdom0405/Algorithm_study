def solution(num_list):
    eval_sum = 0
    odd_sum = 0
    for i in range(len(num_list)):
        if(i%2 == 0):
            eval_sum += num_list[i]
        else:
            odd_sum += num_list[i]
    
    return max(eval_sum, odd_sum)