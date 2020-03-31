def isAvailable(skill, skills):
    while skills:
        element = skills.pop(0)
        if skill[0] == element:
            skill.pop(0)
        else:
            return False
    return True


def solution(skill, skill_trees):
    answer = 0
    for skill_tree in skill_trees:
        skills = []
        for s in skill_tree:
            if s in skill: skills.append(s)
        if isAvailable(list(skill), skills): answer += 1
    return answer

if __name__=="__main__":
    skill, skill_trees = "CBD", ["BACDE", "CBADF", "AECB", "BDA"]
    print("#1 {}".format(solution(skill, skill_trees)))