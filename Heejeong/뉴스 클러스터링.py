from collections import Counter


# 다중집합 구하는 함수
def make_arr(x):
    return [x[i:i + 2].lower() for i in range(len(x) - 1) if x[i:i + 2].isalpha()]

# 자카드 유사도 구하는 함수
def jacard(arr1, arr2):
    if not arr1 and not arr2: return 1
    c1, c2 = dict(Counter(arr1)), dict(Counter(arr2))
    intersection = list(set(c1).intersection(set(c2)))
    new_inter = []
    for e in intersection:
        if c1[e] >= c2[e]: min_value = c2[e]
        else: min_value = c1[e]
        new_inter.extend([e for i in range(min_value)])

    union = list(set(c1).union(set(c2)))
    new_union = []
    for e in union:
        max_value = 0
        if e in c1 and e in c2:
            if c1[e] >= c2[e]: max_value = c1[e]
            else: max_value = c2[e]
        elif e in c1:
            max_value = c1[e]
        elif e in c2:
            max_value = c2[e]
        new_union.extend([e for i in range(max_value)])
    return len(new_inter)/len(new_union)


def solution(str1, str2):
    answer = 0
    arr1, arr2 = make_arr(str1), make_arr(str2)
    return int(jacard(arr1, arr2) * 65536)