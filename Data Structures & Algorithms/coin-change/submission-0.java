class Solution {
    public int coinChange(int[] coins, int amount) {
     int[] coinsRequired=new int[amount+1];
     if(amount<1)
     return 0;
     Arrays.fill(coinsRequired,Integer.MAX_VALUE);
     coinsRequired[0]=0;
     for(int i=1;i<=amount;i++)
     {
        for(int coin: coins)
        {
            if(coin<=i && coinsRequired[i-coin]!=Integer.MAX_VALUE)
            {
                coinsRequired[i]=Math.min( coinsRequired[i],coinsRequired[i-coin]+1);
            }
        }
     }   
     if(coinsRequired[amount]==Integer.MAX_VALUE)
     return -1;
     return coinsRequired[amount];
    }
}
