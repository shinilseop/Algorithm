def solution(numbers, target):
    def dfs(deep, result, func):
        if deep == len(numbers):
            if(target == result):
                global answer
                answer+=1
                print(func)
            return

        dfs(deep+1, result+numbers[deep], func+f"+{numbers[deep]}")
        dfs(deep+1, result-numbers[deep], func+f"-{numbers[deep]}")

    global answer
    answer = 0

    dfs(0, 0, "")

    return answer

print(solution([1, 1, 1, 1, 1],3))