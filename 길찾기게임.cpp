#include <string>
#include <vector>
#include <queue>

using namespace std;


typedef struct _bintree {
	
	int index;
	int x;

	// << sub tree
	struct _bintree* left;
	struct _bintree* right;
	// >>
};

typedef struct _node {

	int x;
	int y;


	int index;
};

// << global variable
vector<vector<int>> g_answer(2); // Answer Format
_bintree* g_map;
// >>

// << priority
struct _priority {
	bool operator()(_node a, _node b) {
		if (a.y == b.y)
			return a.x > b.x;
		else
			return a.y < b.y;
	}
};
// >>


// << the number of cases by case
void find(_bintree* curr, _bintree* newNode) {

	if (curr->x > newNode->x) { 
		if (curr->left != NULL) {
			find(curr->left, newNode);
		}
		else
			curr->left = newNode;
	}
	else if (curr->x < newNode->x) {
		if (curr->right != NULL) {
			find(curr->right, newNode);
		}
		else
			curr->right = newNode;
	}
}
// >>

void preorder(_bintree* curr) {
	if (curr == NULL)
		return;
	g_answer[0].push_back(curr->index);
	preorder(curr->left);
	preorder(curr->right);
}

void postorder(_bintree* curr) {
	if (curr == NULL)
		return;
	postorder(curr->left);
	postorder(curr->right);
	g_answer[1].push_back(curr->index);
}


// sol : priority queue ->  binary tree  and search
vector<vector<int>> solution(vector<vector<int>> nodeinfo) {

	//Priority 1. bigger y, 2. bigger x 
	priority_queue< _node, vector<_node>, _priority> nodes;
	
	_node input;

	for (int i = 0; i < nodeinfo.size(); i++) {
		input.x = nodeinfo[i][0];
		input.y = nodeinfo[i][1];
		input.index = i + 1; // index 1 start
		nodes.push(input);
	}

	_node curr;
	_bintree* newNode, * tmp;

	newNode = (_bintree*)malloc(sizeof(_bintree));
	curr = nodes.top();
	nodes.pop();
	newNode->index = curr.index;
	newNode->x = curr.x;
	newNode->left = newNode->right = NULL;
	g_map = newNode;

	while (!nodes.empty()) {
		curr = nodes.top();
		nodes.pop();
		newNode = (_bintree*)malloc(sizeof(_bintree));
		newNode->index = curr.index;
		newNode->x = curr.x;
		newNode->left = newNode->right = NULL;
		find(g_map, newNode);
	}

	preorder(g_map);
	postorder(g_map);


	return g_answer;
}
