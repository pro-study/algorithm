# https://www.acmicpc.net/problem/10828

def pop(arr):
    if not arr: return -1
    return arr.pop()

def size(arr):
    return len(arr)

def empty(arr):
    if not arr: return 1
    else: return 0

def top(arr):
    if not arr: return -1
    return arr[-1]


if __name__ == "__main__":
    N = int(input())
    stack = []

    for i in range(1, N + 1):
        command = list(input().split(" "))
        if command[0] == "push": stack.append(int(command[1]))
        else:
            print(eval(command[0]+"(stack)"))