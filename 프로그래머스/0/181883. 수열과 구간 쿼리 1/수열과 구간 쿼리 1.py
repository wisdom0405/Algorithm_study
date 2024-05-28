def solution(arr, queries):
    for i in range(len(queries)):
        for j in range(len(arr)) :
            if (j >= queries[i][0]) and (j <= queries[i][1]):
                arr[j] += 1
    return arr