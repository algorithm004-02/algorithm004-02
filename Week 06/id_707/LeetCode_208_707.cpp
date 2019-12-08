#include <stdlib.h>
#include <stdio.h>
#include <iostream>
using namespace std;
// ÊµÏÖTrie ×ÖµäÊ÷
const int MAXN = 26;
class Trie {
public:
	bool is_str;
	Trie *next[MAXN];
	Trie() {
		is_str = false;
		memset(next, 0, sizeof(next));
	}
	void insert(string word) {
		Trie *cur = this;
		for (char w : word)
		{
			if (cur->next[w-'a'] == nullptr)
			{
				Trie *new_node = new Trie();
				cur->next[w - 'a'] = new_node;
			}
			cur = cur->next[w - 'a'];
		}
		cur->is_str = true;
	}

	bool search(string word) {
		Trie *cur = this;
		for (char w:word)
		{
			if (cur != nullptr)
			{
				cur = cur->next[w - 'a'];
			}
		}
		return (cur != nullptr && cur->is_str);
	}
	bool startsWith(string prefix) {
		Trie *cur = this;
		for (char w: prefix)
		{
			if (cur != nullptr)
			{
				cur = cur->next[w - 'a'];
			}
		}
		return cur != nullptr;
	}
};

int main() {
	Trie *trie = new Trie();
	trie->insert("apple");
	cout << trie->search("apple") << endl;
	cout << trie->search("app") << endl;
	cout << trie->startsWith("app") << endl;
	trie->insert("app");
	cout << trie->search("app") << endl;
	system("pause");
	return 0;
}