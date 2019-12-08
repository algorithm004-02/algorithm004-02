#ifndef _LRUCACHEIMPLEMENT_H_
#define _LRUCACHEIMPLEMENT_H_

#include <iostream>
#include <list>
#include <unordered_map>

using namespace std;

class LRUCache {
public:
	LRUCache(int capacity) : m_capacity(capacity) {}

	int get(int key) {
		auto itget = m_map.find(key);
		if (itget == m_map.end()) {
			return -1;
		}
		m_list.splice(m_list.begin(), m_list, itget->second);
		return itget->second->second;
	}

	void put(int key, int value) {
		auto itset = m_map.find(key);
		if (itset != m_map.end()) {
			m_list.splice(m_list.begin(), m_list, itset->second);
			itset->second->second = value;
			return;
		}
		if (m_map.size() == m_capacity) {
			int backKey = m_list.back().first;
			m_list.pop_back();
			m_map.erase(backKey);
		}
		m_list.emplace_front(key, value);
		m_map[key] = m_list.begin();
	}

private:
	int m_capacity;
	list<pair<int, int>> m_list;
	unordered_map<int, list<pair<int, int>>::iterator> m_map;
};

#endif // _LRUCACHEIMPLEMENT_H_
