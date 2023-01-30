#include <iostream>

int sumDigits(int number) {
	
	if (number == 0)
		return 0;



	return 0 + (number % 10) + sumDigits(trunc(number / 10));
}

int main()
{
	std::cout << sumDigits(1007);

	return 0;
}