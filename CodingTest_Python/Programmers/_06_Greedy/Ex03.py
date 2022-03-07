def solution(number, k):
    change = idx = 0
    while(change != k):
        print(number)
        if(idx == len(number)-1):
            break
        elif(number[idx] < number[idx+1]):
            number = number[:idx]+number[idx+1:]
            change+=1
            if idx!=0:
                idx-=1
        else:
            idx+=1

    answer = number[:len(number)-(k-change)]

    return answer

if __name__=="__main__":
    print(solution("1924", 2))
    print(solution("987654321", 3))
