class Solution {
    public int maxCoins(int[] piles) {
        int maxPile = 0;
        for(int pile : piles) if(pile > maxPile) maxPile = pile;
        
        int[] counts = new int[maxPile + 1];
        for(int pile : piles) counts[pile]++;
        
        int myCoins = 0;
        for(int idx = maxPile + 1, mine = 0, remaining = piles.length / 3; remaining > 0;){
            while (counts[--idx] == 0) {}
            int myPileCount = (counts[idx] + (mine & counts[idx])) / 2;
            if (myPileCount > remaining)  myPileCount = remaining;
            remaining -= myPileCount;
            myCoins += myPileCount * idx;
            mine = (counts[idx] ^ mine) & 1;
        }
        
        return myCoins;
    }
}
