class MaxProfit{
    public int maxProfit(int[] prices) {
        
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        //2,4,1

        //the idea is to keep the local min value,

        //min = 2, current 2, max = 0
        //min = 2, current = 4, max = 2;
        //min = 1, 
        // maxProfit = Math.max(maxProfit, current - min)

        for(int price : prices) {

            if(price < minValue){
                minValue = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minValue);
            }
            
        }

        return maxProfit;
    




    }
}