def solution(m, n, puddles):
    MOD = 1000000007
    isPuddle = [[False for _ in range(m+1)] for _ in range(n+1)]
    dp = [[0 for _ in range(m+1)] for _ in range(n+1)]
    for i in range(len(puddles)):
        isPuddle[puddles[i][1]][puddles[i][0]] = True

    for i in range(n+1):
        if isPuddle[i][1]:
            break
        dp[i][1] = 1
    for i in range(m+1):
        if isPuddle[1][i]:
            break
        dp[1][i] = 1

    for y in range(2, n+1):
        for x in range(2, m+1):
            if(isPuddle[y][x] is False):
                dp[y][x] = (dp[y-1][x]+dp[y][x-1])%MOD

    # for arr in dp:
    #     print(arr)

    return dp[n][m]


print(solution(4,3,[[2, 2]]))