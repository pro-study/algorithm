def check(frames):
    if not frames:
        return True

    for x, y, kind in frames:
        if kind == 0: # pillar
            if y == 0 or (x, y-1, 0) in frames or (x, y, 1) in frames or (x-1, y, 1) in frames:
                continue
            else:
                return False
        else: # base
            if (x, y-1, 0) in frames or (x+1, y-1, 0) in frames or \
                ((x-1, y, 1) in frames and (x+1, y, 1) in frames):
                continue
            else:
                return False
    return True

def solution(n, build_frame):
    frames = set()

    for x, y, kind, action in build_frame:
        if action: # build
            frames.add((x, y, kind))
            if not check(frames):
                frames.remove((x, y, kind))
        else:
            frames.remove((x, y, kind))
            if not check(frames):
                frames.add((x, y, kind))
    
    return sorted(map(list, frames))