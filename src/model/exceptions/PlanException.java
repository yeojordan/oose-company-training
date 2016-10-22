package model.exceptions;

public class PlanException extends FileFormatException
{
    public PlanException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PlanException(String message)
    {
        super(message);
    }
}
