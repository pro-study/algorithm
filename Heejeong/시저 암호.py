from test import Test
import string

def transform(e, n):
    upp = string.ascii_uppercase
    low = string.ascii_lowercase

    if e == " ":
        return e
    elif e == e.lower():
        return low[(low.index(e) + n) % len(low)]
    else:
        return upp[(upp.index(e) + n) % len(upp)]

def solution(s, n):
    return ''.join(list(map(lambda x: transform(x, n), s)))
if __name__ == "__main__":
    test_case = ["AB", "a B z"]
    test_result = ["BC", "e F d"]
    Test(solution).test(test_case, test_result)

