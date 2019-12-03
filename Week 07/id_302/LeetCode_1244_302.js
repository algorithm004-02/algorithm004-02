// Design a Leaderboard class, which has 3 functions:

// addScore(playerId, score): Update the leaderboard by adding score to the given player's score. 
// If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
// top(K): Return the score sum of the top K players.
// reset(playerId): Reset the score of the player with the given id to 0. It is guaranteed that the 
// player was added to the leaderboard before calling this function.
// Initially, the leaderboard is empty.

// Binary Search sort 

var Leaderboard = function() {
    this.players = new Map();
    this.scores = [];
}

Leaderboard.prototype.sortedIndex = function(value) {
    let low = 0, high = this.scores.length;

    while(low < high) {
        let mid = (low + high) >>> 1;
        if(this.scores[mid] < value) low = mid + 1;
        else high = mid;
    }

    return low;
}

Leaderboard.prototype.addScore = function(playerId, score) {
    if(this.players.has(playerId)) {
        let current = this.players.get(playerId);
        let sum = score + current;
        this.players.set(playerId, sum);

        let currentIndex = this.sortedIndex(current); // we need to find current index in order to 
        this.scores.splice(currentIndex, 1)
        let newIndex = this.sortedIndex(sum);
        this.scores.splice(newIndex, 0, sum);
        
    } else {
        let index = this.sortedIndex(score);
        this.players.set(playerId, score);
        this.scores.splice(index, 0, score); 
    }
}

Leaderboard.prototype.top = function(K) {
    let count = K, sum = 0;
    let len = this.scores.length;
    while(count > 0) {
        sum = sum + this.scores[len - count]
        count--;
    }
    return sum;
}

Leaderboard.prototype.reset = function(playerId) {
    let current = this.players.get(playerId);
    this.players.delete(playerId);
    let currentIndex = this.sortedIndex(current);
    this.scores.splice(currentIndex, 1);
}

