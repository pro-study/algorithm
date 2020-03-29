from collections import Counter

def solution(nodeinfo):
    answer = []

    # y축 레벨링
    level = sorted(list(Counter(list(map(lambda x: x[1], nodeinfo)))), reverse=True)
    level = {level[i]: i + 1 for i in range(len(level))}

    nodelist = [Node(i + 1, nodeinfo[i][0], level[nodeinfo[i][1]]) for i in range(len(nodeinfo))]
    root = sorted(nodelist, key=lambda x:x.level)[0]
    makeBinaryTree(nodelist)
    tree = BST(root)
    answer.extend([tree.preorder(), tree.postorder()])
    return answer

def makeBinaryTree(nodelist):
    if not nodelist: return None
    nodelist.sort(key=lambda x: x.level, reverse= True)
    pivot = nodelist.pop();
    pivot.left = makeBinaryTree(list(filter(lambda x: x.location < pivot.location, nodelist)))
    pivot.right = makeBinaryTree(list(filter(lambda x: x.location > pivot.location, nodelist)))
    return pivot;

class Node:
    def __init__(self, value, location, level):
        self.value = value
        self.location = location    # x축
        self.level = level          # y축 레벨링
        self.left = None
        self.right = None

    def __str__(self):
        return "Node(value : {}, location: {}, level: {}, left: {}, right: {})".format(self.value, self.location, self.level,
                                                                                 self.left, self.right)

class BST:
    def __init__(self, root):
        self.root = root

    def preorder(self):
        answer = []
        def _preorder(root):
            if root is None: return;
            answer.append(root.value)
            _preorder(root.left)
            _preorder(root.right)

        _preorder(self.root)
        return answer

    def postorder(self):
        answer = []
        def _postorder(root):
            if root is None: return;
            _postorder(root.left)
            _postorder(root.right)
            answer.append(root.value)

        _postorder(self.root)
        return answer

if __name__ == "__main__":
    nodeinfo = 	[[5, 3], [11, 5], [13, 3], [3, 5], [6, 1], [1, 3], [8, 6], [7, 2], [2, 2]]
    print(solution(nodeinfo))