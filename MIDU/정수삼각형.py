def solution(triangle):
    hap_triangle = triangle[:]

    for i in range(1, len(hap_triangle)):
        for j in range(len(hap_triangle[i])):
            pre_line = [0] + hap_triangle[i-1] + [0]
            hap_triangle[i][j] += max(pre_line[j], pre_line[j+1])
    
    return max(hap_triangle[-1])