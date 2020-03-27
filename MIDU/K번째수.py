def solution(array, commands):
    return list(sorted(array[i-1:j])[k-1] for i,j,k in commands)