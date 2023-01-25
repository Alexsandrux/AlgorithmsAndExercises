#include <iostream>
#include <string.h>


struct Node {
	int id;
	char* stringInfo;
	Node* left_child;
	Node* right_child;
};

Node* initNode(int id, const char* stringInfo)
{
	Node* newNode = new Node;

	newNode->id = id;
	newNode->stringInfo = new char[strlen(stringInfo) * sizeof(char) + 1];
	strcpy_s(newNode->stringInfo, (strlen(stringInfo) * sizeof(char) + 1), stringInfo);

	newNode->left_child = NULL;
	newNode->right_child = NULL;

	return newNode;
}

Node* addNode(Node* rootNode, Node* newNode) {
	if (rootNode == NULL)
	{
		return newNode;
	}
	if (newNode == NULL)
	{
		return rootNode;
	}

	if (rootNode->id < newNode->id) {
		rootNode->right_child = addNode(rootNode->right_child, newNode);
	}
	else {
		rootNode->left_child = addNode(rootNode->left_child, newNode);
	}


	return rootNode;

}

void showNodeInfo(Node* pNode) {
	std::cout << "Node with the id equal to " << pNode->id << " has:" << std::endl;
	std::cout << pNode->stringInfo << std::endl;
	std::cout << std::endl;
}

void showTreeInfo(Node* rootNode) {
	if (rootNode == NULL)
	{
		return;
	}

	showNodeInfo(rootNode);
	showTreeInfo(rootNode->left_child);
	showTreeInfo(rootNode->right_child);
}

void deallocateTree(Node* rootNode) {
	if (rootNode == NULL)
	{
		return;
	}

	if (rootNode->left_child != NULL) {
		deallocateTree(rootNode->left_child);
	}
	if (rootNode->right_child != NULL) {
		deallocateTree(rootNode->right_child);
	}

	delete rootNode->stringInfo;
	delete rootNode;
}

int main() {
	Node* rootNode = NULL;

	rootNode = addNode(rootNode, initNode(9, "John"));
	rootNode = addNode(rootNode, initNode(7, "Otilia"));
	rootNode = addNode(rootNode, initNode(11, "Ed"));
	rootNode = addNode(rootNode, initNode(10, "Edd"));
	rootNode = addNode(rootNode, initNode(8, "Eddy"));


	showTreeInfo(rootNode);


	deallocateTree(rootNode);
	return 0;
}