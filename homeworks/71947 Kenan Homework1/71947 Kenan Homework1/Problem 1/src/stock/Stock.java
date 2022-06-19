package stock;

public class Stock
{
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String symbol, String name)
    {
        if (symbol != null)
        {
            this.symbol = symbol;
        }
        else
        {
            this.symbol = "Default Symbol"; // no default symbol given in the task description
        }

        if (name != null)
        {
            this.name = name;
        }
        else
        {
            this.name = "Default Name"; // no default name given in the task description
        }
        // no given default values in the task description.
        setCurrentPrice(1);
        setPreviousClosingPrice(1);
    }

    public String getSymbol()
    {
        return this.symbol;
    }

    public String getName()
    {
        return this.name;
    }

    public double getPreviousClosingPrice()
    {
        return this.previousClosingPrice;
    }

    public double getCurrentPrice()
    {
        return this.currentPrice;
    }

    public void setPreviousClosingPrice(double previousClosingPrice)
    {
        if (previousClosingPrice > 0)
        {
            this.previousClosingPrice = previousClosingPrice;
        }
        else
        {
            this.previousClosingPrice = 1; // no given default value
        }
    }

    public void setCurrentPrice(double currentPrice)
    {
        if (currentPrice > 0)
        {
            this.currentPrice = currentPrice;
        }
        else
        {
            this.currentPrice = 1; // no given default value
        }
    }

    public double changePercent()
    {
                double difference = this.currentPrice - this.previousClosingPrice; // saving the increased value
                difference = difference / previousClosingPrice * 100; // getting the percentage of the diffirence
                return difference;
    }
}