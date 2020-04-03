import java.util.*;
import java.util.stream.Collectors;

class Solution {

	private static final int X_IDX = 0;
	private static final int Y_IDX = 1;

	public int[][] solution(int[][] nodeinfos) {
		List<Node> nodeList = mapToNodeList(nodeinfos);

		Node topNode = makeBinaryTree(nodeList);

		int[] preOrder = getPreOrder(topNode).stream().mapToInt(node -> node).toArray();
		int[] postOrder = getPostOrder(topNode).stream().mapToInt(node -> node).toArray();

		return new int[][] { preOrder, postOrder };
	}

	private List<Node> mapToNodeList(int[][] nodeinfos) {
		List<Node> nodeList = new ArrayList<>();

		for (int i = 0; i < nodeinfos.length; i++) {
			nodeList.add(new Node(i + 1, nodeinfos[i][X_IDX], nodeinfos[i][Y_IDX]));
		}

		return nodeList;
	}

	private Node makeBinaryTree(List<Node> nodeList) {
		if (nodeList.isEmpty()) {
			return null;
		}
		nodeList.sort(Comparator.comparingInt(node -> node.y));
		Node topNode = nodeList.remove(nodeList.size() - 1);

		Map<Boolean, List<Node>> nodeListByTopNodeX = nodeList.stream().collect(Collectors.partitioningBy(node -> node.x < topNode.x));

		topNode.leftChild = makeBinaryTree(nodeListByTopNodeX.get(true));
		topNode.rightChild = makeBinaryTree(nodeListByTopNodeX.get(false));

		return topNode;
	}

	private List<Integer> getPreOrder(Node node) {
		List<Integer> preOrderList = new ArrayList<>();

		if (Objects.isNull(node)) {
			return preOrderList;
		}

		preOrderList.add(node.key);
		preOrderList.addAll(getPreOrder(node.leftChild));
		preOrderList.addAll(getPreOrder(node.rightChild));

		return preOrderList;
	}

	private List<Integer> getPostOrder(Node node) {
		List<Integer> postOrderList = new ArrayList<>();

		if (Objects.isNull(node)) {
			return postOrderList;
		}

		postOrderList.addAll(getPostOrder(node.leftChild));
		postOrderList.addAll(getPostOrder(node.rightChild));
		postOrderList.add(node.key);

		return postOrderList;
	}
}

class Node {
	int key;
	int x;
	int y;
	Node leftChild;
	Node rightChild;

	Node(int key, int x, int y) {
		this.key = key;
		this.x = x;
		this.y = y;
	}
}