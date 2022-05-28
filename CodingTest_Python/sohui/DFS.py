T = int(input())


def check(arr):
    # 가로 확인
    for i in range(9):
        check = []
        for j in range(9):
            if arr[i][j] in check:
                return '0'
            check.append(arr[i][j])

    # 세로 확인
    for i in range(9):
        check = []
        for j in range(9):
            if check:
                if arr[j][i] in check:
                    return '0'
            check.append(arr[j][i])

    # 블록 확인
    for i in range(0, 9, 3):  # 시작점
        for j in range(0, 9, 3):
            check = []

            # 블록
            for k in range(3):
                for t in range(3):
                    if check:
                        if arr[i + k][j + t] in check:
                            return '0'
                    check.append(arr[i + k][j + t])
    return '1'


for tc in range(1,T+1):
    arr = [list(map(int, input().split())) for _ in range(9)]
    print("#{}".format(tc), end=' ')
    print(check(arr))