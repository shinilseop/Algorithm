def Degrees90(arr, N):
    arr2 = []
    for i in range(0, N):
        for j in range(N - 1, -1, -1):
            arr2.append(arr[j][i])
    return arr2


def Degrees180(arr, N):
    arr2 = []
    for i in range(N - 1, -1, -1):
        for j in range(N - 1, -1, -1):
            arr2.append(arr[i][j])
    return arr2


def Degrees270(arr, N):
    arr2 = []
    for i in range(N - 1, -1, -1):
        for j in range(0, N):
            arr2.append(arr[j][i])
    return arr2


T = int(input())

for tc in range(T):
    N = int(input())
    arr = []
    for i in range(N):
        a = list(map(int, input().split()))
        arr.append(a)

    deg90 = Degrees90(arr, N)
    deg180 = Degrees180(arr, N)
    deg270 = Degrees270(arr, N)

    result = [deg90, deg180, deg270]
    """
    result = [  [1,2,3,3,4,1...],
                [],
                [] ]
                
    N=3
    
    0번쨰 줄       1 2 3 -> 0~2 -> N(3)*row(0) ~ N + N(3)*row(0)
                  4 5 6 -> 3~5 -> N(3)*row(1) ~ N + N(3)*row(1)
                  7 8 9 -> 6~8 -> N(3)*row(2) ~ N + N(3)*row(2)
                
    """

    for row in range(N):
        for count in range(len(result)):
            for i in range(N * row, N * row + N):
                print(result[count][i],end='')
            print(end=' ')
        print()

    # arr3 = [deg90, deg180, deg270]
    # arr4 = sum(arr3, []) #2차원배열->1차원배열로만듦
    # arr5 = []
    # arr6 = []
    #
    # for i in range(0, len(arr4), N):
    #     arr5.append(arr4[i:i+3])

    # for i in range(0,N):
    #     for j in range(0, N):
    #         print(arr5[j][i])

    # print(arr5)
