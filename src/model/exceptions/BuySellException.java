package model.exceptions;

public class BuySellException extends PlanException
{
    public BuySellException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public BuySellException(String message)
    {
        super(message);
    }

}
