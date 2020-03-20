def solution(record):
    answer = []
    uinfo = {}  # user info - uid, nicname
    for r in record:
        command = r.split(" ")
        if command[0] != "Leave": uinfo[command[1]] = command[2]

    for r in record:
        command = r.split(" ")
        if command[0] == "Change":
            continue
        elif command[0] == "Enter":
            answer.append("{}님이 들어왔습니다.".format(uinfo[command[1]]))
        else:
            answer.append("{}님이 나갔습니다.".format(uinfo[command[1]]))
    return answer