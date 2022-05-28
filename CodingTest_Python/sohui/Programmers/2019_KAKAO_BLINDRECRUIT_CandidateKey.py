def makeKey(indexes):



def minimalityCheck(tuples):


def solution(relation):
    answer = 0


    table = [() for _ in range(len(relation[0]))]
    for row in relation:
        for i in range(len(row)):
            table[i].add(row[i])


    return answer

# [["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],
# ["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]