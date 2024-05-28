def solution(numLog):
    result = []
    answer = ""
    word = ["w", "s", "d", "a"]
    control = [1, -1, 10, -10]
    for i in range(len(numLog)-1):
        log = numLog[i+1] - numLog[i]
        result.append(log) # 조작에 의한 결과값 저장 리스트
    
    for j in result:
        if j in control:
            x = control.index(j) # 결과값이 control 리스트에 있다면 해당 값의 인덱스 찾음
            answer += word[x] # 찾은 index에 해당하는 word값 저장 
    
    return answer