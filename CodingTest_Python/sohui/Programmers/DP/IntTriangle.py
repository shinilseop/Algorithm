def solution(triangle):
    length = len(triangle)

    dp = [[0 for _ in range(length)] for _ in range(length)]

    dp[0][0] = triangle[0][0]
    for i in range(1, len(triangle)):
        for j in range(len(triangle[i])):
            if (j == 0):
                dp[i][j] = dp[i - 1][j] + triangle[i][j]
            elif (j == len(triangle[i]) - 1):
                dp[i][j] = dp[i - 1][j - 1] + triangle[i][j]
            else:
                dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]

    _max = 0
    for i in range(len(dp[len(dp) - 1])):
        _max = max(_max, dp[len(dp) - 1][i])

    # for i in range(len(dp)):
    #     print(dp[i])

    return _max


print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))
