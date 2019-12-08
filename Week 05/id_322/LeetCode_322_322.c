int coinChange(int* coins, int coinsSize, int amount){
    int *f = NULL;
    int min = 0;
    
    if (amount == 0) {
        return 0;
    }
    f = malloc(sizeof(int) * (amount + 1));
    memset(f, 0, sizeof(int) * (amount + 1));
    
    for (int i = 0; i < coinsSize; ++i) {
        if (coins[i] <= amount) {
            f[coins[i]] = 1;
        }
    }
    for (int i = 1; i <= amount; ++i) {
        min = 0;
        if (f[i] != 0) {
            continue;
        }
        for (int j = 0; j < coinsSize; ++j) {
            if (coins[j] >= i) {
                continue;
            }
            if (f[i - coins[j]] == 0) {
                continue;
            }
            if (min == 0) {
                min = f[i - coins[j]];
            } else {
                min = min < f[i - coins[j]] ? min : f[i - coins[j]];
            }
        }
        if (min != 0) {
            f[i] = min + 1;
        }
    }
    if (f[amount] != 0) {
        return f[amount];
    }
    return -1;
}