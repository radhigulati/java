// The indicies are the time in minutes past trade opening time, which
// was 9:30am local time
// The values are the price in dollars of Apple stock at the time
// Ex: So if the stock cost $500 at 10:30am, stockPricesYesterday[60]=500
// Ex: 
// int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
// getMaxProfit(stockPricesYesterday);
// returns 6 buying for ($5 and selling for $11)

public class Stocks
{
    static int[] stockPricesYesterday = new int[]{10, 9, 8, 11};
    static int potentialProfit;

    public static void main(String[] args) 
    {
        System.out.println("Max profit: $" + getMaxProfit(stockPricesYesterday));
    }

    public static int getMaxProfit(int[] stockPricesYesterday) 
    {
        int maxProfit = 0;

        for (int outerTime = 0; outerTime < stockPricesYesterday.length; outerTime++)
        {
            for (int innerTime = 0; innerTime < stockPricesYesterday.length; innerTime++)
            {
                int earlierTime = Math.min(outerTime, innerTime);
                int laterTime = Math.max(outerTime, innerTime);

                int earlierPrice = stockPricesYesterday[earlierTime];
                int laterPrice = stockPricesYesterday[laterTime];

                int potentialProfit = laterPrice - earlierPrice;

                maxProfit = Math.max(maxProfit, potentialProfit);
            }
        }

        return maxProfit;
    }
}

