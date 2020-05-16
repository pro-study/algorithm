# 가능한 스킬 트리인지 검사하는 함수
def isAvailable(skill, skill_tree):
    # 스킬트리에 값이 없을 때까지 반복
    while skill_tree:
        element = skill_tree.pop(0)
        if skill[0] == element:
            skill.pop(0)
        else:
            return False
    return True


def solution(skill, skill_trees):
    answer = 0
    for skill_tree in skill_trees:
        # 스킬트리에 있는 것만 skills에 저장
        skills = []
        for s in skill_tree:
            if s in skill: skills.append(s)

        # 가능한 스킬일 경우 count 값 증가
        if isAvailable(list(skill), skills): answer += 1
    return answer

if __name__=="__main__":
    skill, skill_trees = "CBD", ["BACDE", "CBADF", "AECB", "BDA"]
    print("#1 {}".format(solution(skill, skill_trees)))