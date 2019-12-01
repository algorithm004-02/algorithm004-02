class Leaderboard {
    
    TreeMap<Integer, Integer> boards ;

    public Leaderboard() {
        
        
        boards =  new TreeMap();
        
        
    }
    
    public void addScore(int playerId, int score) {
        boards.put(playerId, boards.getOrDefault(playerId, 0)+score);
        
        
        
    }
    
    public int top(int K) {
        
        List<Integer> list = new LinkedList(boards.values());
        
        Collections.sort(list, (n1, n2) -> n2 - n1 > 0 ? 1 : n2 == n1 ? 0 : -1);
            
        int result = 0;
        
        
        
        for (int i = 0; i< K; i++) {
            result += list.get(i);
            
        }
            
        return result;
    }
    
    public void reset(int playerId) {
        
        boards.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */