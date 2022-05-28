# n,m = map(int, input().split(" "))
# s = list(input())
# k = s[0]
# if len(s) > n:
#     print('s input Error')
# else:
#     for i in range(0, m):
#         s.append(s[i])
#         print(s)
#
#     for j in range(0, m):
#         for i in range(len(s), len(s)+m):
#             s[i].append(s[j])
#             print(s)

T = int(input())

for tc in range(1, T+1):
    _input = input()

    print(f"#{tc} ",end='')
    # maxLength = 0
    firstWord = ''
    for i in range(0, len(_input)):
        firstWord += _input[i]

        if _input[i+1:].startswith(firstWord):
            # maxLength = max(maxLength, len(firstWord))
            print(len(firstWord))
            break