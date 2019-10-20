#include "DesignDeque.h"

DesignDeque::DesignDeque(int k):
front(0),
rear(0)
{
	data = new int[k + 1];
	capacity = k + 1;
}


DesignDeque::~DesignDeque()
{
	delete []data;
}

bool DesignDeque::insertFront(int value) {
	if (isFull()) return false;
	front = (front - 1 + capacity) % capacity;
	data[front] = value;
	return true;
}

bool DesignDeque::insertLast(int value) {
	if (isFull()) return false;
	data[rear] = value;
	rear = (rear + 1) % capacity;
	return true;
}

bool DesignDeque::deleteFront() {
	if (isFull()) return false;
	front = (front + 1) % capacity;
	return true;
}

bool DesignDeque::deleteLast() {
	if (isFull()) return false;
	rear = (rear - 1 + capacity) % capacity;
	return true;
}

int DesignDeque::getFront(){
	if (isFull()) return -1;
	return data[front];
}

int DesignDeque::getRear() {
	if (isFull()) return -1;
	return data[(rear-1+capacity)%capacity];
}

bool DesignDeque::isEmpty() {
	return (front == rear);
}

bool DesignDeque::isFull() {
	return ((rear + 1) % capacity == front);
}
