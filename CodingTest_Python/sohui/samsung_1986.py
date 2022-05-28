t = int(input())

for tc in range(1, t+1):
    n = int(input())
    arr_len = n*n
    matrix = [[0 for _ in range(n)] for _ in range(n)] # n * n 배열 0으로 초기화

    value = 1
    for i in range(0, n):
        matrix[0][i] = value
        value+=1
    for i in range(1, n):
        matrix[i][n-1] = value
        value += 1
    for i in range(n-2, -1, -1):
        matrix[n-1][i] = value
        value += 1
    for i in range(n-2, 0, -1):
        matrix[i][0] = value
        value += 1

    # for i in range(0, len(matrix)):
    #     print(matrix[i])

    # 동, 남, 서, 북
    dy = [0, 1, 0, -1] # y축으로의 방향
    dx = [1, 0, -1, 0] # x축으로의 방향
    d = 0 # 현재 진행방향
    nowY = 1
    nowX = 1

    for _value in range(value, n*n+1):
        matrix[nowY][nowX] = _value

        if matrix[nowY+dy[d]][nowX+dx[d]] != 0:
            if d == 3:
                d = 0
            else:
                d+=1

        nowY += dy[d]
        nowX += dx[d]

    for i in range(0, len(matrix)):
        print(matrix[i])