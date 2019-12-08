#ifndef _WORDSEARCHII_H_
#define _WORDSEARCHII_H_

#include <iostream>
#include <vector>
#include <set>

using namespace std;

class TrieNode
{
public:
	TrieNode() {
		next = vector<TrieNode*>(26, NULL);
		isEnd = false;
	}

public:
	vector<TrieNode*> next;
	bool isEnd;

};

class Trie {
public:
	Trie(vector<string> words) {
		root = new TrieNode();
		for (auto& word : words) {
			insert(word);
		}
	}

	TrieNode* getRoot() {
		return root;
	}

	void insert(string word) {
		TrieNode* curr = root;
		for (int i = 0; i < word.size(); i++) {
			if (curr->next[word[i] - 'a'] == NULL) {
				curr->next[word[i] - 'a'] = new TrieNode();
			}
			curr = curr->next[word[i] - 'a'];
		}
		curr->isEnd = true;
	}

private:
	TrieNode* root;
};

class Solution {
public:
	vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
		Trie* trie = new Trie(words);
		TrieNode* root = trie->getRoot();
		set<string> resultset;
		for (int i = 0; i < board.size(); i++) {
			for (int j = 0; j < board[0].size(); j++) {
				findSinWords(board, i, j, root, "", resultset);
			}
		}

		vector<string> result;
		for (auto& res : resultset) {
			result.push_back(res);
		}
		return result;
	}

private:
	void findSinWords(vector<vector<char>>& board, int x, int y, TrieNode* root, string word, set<string>& result) {
		if (x < 0 || x >= board.size() || y < 0 || y >= board[0].size() || board[x][y] == ' ') {
			return;
		}

		if (root->next[board[x][y] - 'a'] != NULL) {
			word += board[x][y];
			root = root->next[board[x][y] - 'a'];
			if (root->isEnd) {
				result.insert(word);
			}
			char c = board[x][y];
			board[x][y] = ' ';
			findSinWords(board, x + 1, y, root, word, result);
			findSinWords(board, x, y + 1, root, word, result);
			findSinWords(board, x - 1, y, root, word, result);
			findSinWords(board, x, y - 1, root, word, result);
			board[x][y] = c;
		}
	}
};

#endif
