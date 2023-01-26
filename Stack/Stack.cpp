#include <iostream>
#include <string.h>

struct StackElement {
	int id;
	char* stringInfo;
	StackElement* next;
};

struct Stack {
	StackElement* top;
};

Stack* initStack()
{
	Stack* newStack = new Stack;

	newStack->top = NULL;

	return newStack;
}

StackElement* initElement(int id, const char* stringInfo) {
	StackElement* element = new StackElement;

	element->id = id;
	element->stringInfo = new char[strlen(stringInfo) * sizeof(char) + 1];
	strcpy_s(element->stringInfo, (strlen(stringInfo) * sizeof(char) + 1), stringInfo);

	element->next = NULL;

	return element;
}

void showElementInfo(StackElement* element) {
	std::cout << "The stack element with the id equal to " << element->id << " has:" << std::endl;
	std::cout << element->stringInfo << std::endl;
	std::cout << std::endl;
}


Stack* push(Stack* stack, StackElement* newElement) {
	if (stack == NULL)
	{
		stack = initStack();
		stack->top = newElement;

		return stack;
	}

	
	if (stack->top == NULL)
	{
		stack->top = newElement;

		return stack;
	}
	
	newElement->next = stack->top;

	stack->top = newElement;

	return stack;
	
}

StackElement* pop(Stack* stack)
{
	if (stack == NULL)
	{
		return NULL;
	}

	if (stack->top == NULL)
	{
		return NULL;
	}

	StackElement* temp = stack->top;

	stack->top = stack->top->next;

	temp->next = NULL;

	return temp;
}

void showStackElements(StackElement* element)
{
	showElementInfo(element);

	if (element->next == NULL)
		return;
	
	showStackElements(element->next);
}

void showStack(Stack* stack)
{
	if (stack == NULL)
		return;

	if (stack->top == NULL)
		return;

	showStackElements(stack->top);
}

void deallocateElement(StackElement* element) {
	delete element->stringInfo;
	delete element;
}

void deallocateStackContents(Stack* stack)
{
	if (stack == NULL)
		return;

	if (stack->top == NULL)
		return;

	StackElement* temp = stack->top;

	if (temp->next == NULL)
	{
		deallocateElement(temp);

		return;
	}

	stack->top = stack->top->next;

	deallocateElement(temp);
	deallocateStackContents(stack);
}

void deallocateStack(Stack* stack) {
	deallocateStackContents(stack);

	delete stack;
}

int main() {


	Stack* stack = push(NULL, initElement(2, "Hikaru"));
	stack = push(stack, initElement(1, "Alexandra"));
	stack = push(stack, initElement(4, "Magnus"));
	stack = push(stack, initElement(3, "Levy"));


	showStack(stack);

	
	deallocateStack(stack);

	return 0;
}