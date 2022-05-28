def solution(record):
    answer = []

    user = {}
    for cmd in record:
        cmds = cmd.split()

        if cmds[0] == "Enter":
            user[cmds[1]] = cmds[2]
            answer.append(cmds[1]+"님이 들어왔습니다.")
        elif cmds[0] == "Leave":
            answer.append(cmds[1]+"님이 나갔습니다.")
        elif cmds[0] == "Change":
            user[cmds[1]] = cmds[2]

    for i in range(len(answer)):
        uid = answer[i].split("님")[0]
        answer[i] = user[uid]+answer[i][len(uid):]

    return answer

print(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]))