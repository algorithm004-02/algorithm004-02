#pragma once
class DesignDeque
{
public:
	DesignDeque(int k);
	~DesignDeque();

	bool insertFront(int value);
	bool insertLast(int value);
	bool deleteFront();
	bool deleteLast();
	int getFront();
	int getRear();
	bool isEmpty();
	bool isFull();

private:
	int *data;
	int front;
	int rear;
	int capacity;
};

