#ifndef _IMPLEMENTTRIEPREFIXTTREE_H_
#define _IMPLEMENTTRIEPREFIXTTREE_H_

#include <iostream>
#include <string>

using namespace std;

class TreeNode
{
public:
	TreeNode(bool isEnd = false) {
		memset(next, 0, sizeof(next));
		m_isEnd = isEnd;
	}

public:
	TreeNode* next[26];
	bool m_isEnd;

};

class Trie {
public:
	/** Initialize your data structure here. */
	Trie() {
		root = new TreeNode();
	}

	/** Inserts a word into the trie. */
	void insert(string word) {
		TreeNode* p = root;
		for (int i = 0; i < word.size(); i++) {
			if (p->next[word[i] - 'a'] == NULL) {
				p->next[word[i] - 'a'] = new TreeNode();
			}
			p = p->next[word[i] - 'a'];
		}
		p->m_isEnd = true;
	}

	/** Returns if the word is in the trie. */
	bool search(string word) {
		TreeNode* p = find(word);
		return p != NULL && p->m_isEnd;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	bool startsWith(string prefix) {
		return find(prefix) != NULL;
	}

private:
	TreeNode* find(string word) {
		TreeNode* p = root;
		for (int i = 0; i < word.size() && p != NULL; i++) {
			p = p->next[word[i] - 'a'];
		}
		return p;
	}

public:
	TreeNode* root;
};

#endif
