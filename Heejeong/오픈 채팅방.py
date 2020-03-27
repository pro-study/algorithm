def solution(record):
    answer = []
    uinfo = {}  # user info - uid, nicname

    # record는 command uid nicname 순으로 들어옴.
    # command의 종류: Enter, Leave, Change
    for r in record:
        command = r.split(" ")

        # user의 닉네임은 Enter와 Change를 통해서 변함.
        if command[0] != "Leave": uinfo[command[1]] = command[2]

    for r in record:
        command = r.split(" ")

        # 출력 메세지는 Enter와 Leave일 때만 기록됨.
        if command[0] == "Change": continue
        elif command[0] == "Enter":
            answer.append("{}님이 들어왔습니다.".format(uinfo[command[1]]))
        else:
            answer.append("{}님이 나갔습니다.".format(uinfo[command[1]]))
    return answer