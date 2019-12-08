class LRUCache {
public:
    int cap;
    list<pair<int, int>> ls;
    map<int, list<pair<int, int>>::iterator> ha;
    LRUCache(int capacity) : cap(capacity) {}
    
    int get(int key) {
        if (ha.find(key) == ha.end()) return -1;
        int val = ha[key]->second;
        ls.erase(ha[key]);
        ls.push_front(make_pair(key, val));
        ha[key] = ls.begin();
        return val;
    }
    
    void put(int key, int value) {
        if (ha.find(key) != ha.end()) {
            ls.erase(ha[key]);
        } else if (ls.size() >= cap) {
            ha.erase(ls.back().first);
            ls.pop_back();
        }
        ls.push_front(make_pair(key, value));
        ha[key] = ls.begin();
    }
};