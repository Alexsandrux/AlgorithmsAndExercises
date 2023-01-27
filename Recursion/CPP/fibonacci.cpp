#include <iostream>


int getfibonacciNumber(int times) {
	if (times == 0)
	{
		return 0;
	}
	if (times == 1)
	{
		return 1;
	}
	int num = getfibonacciNumber(times - 1) + getfibonacciNumber(times - 2);
	return num;
}

void fibonacciSequence(int times) {
	if (times < 0)
		return;

	std::cout << getfibonacciNumber(times) << " ";
	
	fibonacciSequence(times - 1);
}


int main() {


	fibonacciSequence(7);

	return 0;
}