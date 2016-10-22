package model.exceptions;

public class WageEventException extends EventException
{
    public WageEventException(String message, Throwable cause)
    {
        // String appended = message + cause.getMessage();
        super(message, cause);
    }

    public WageEventException(String message)
    {
        super(message);
    }

}
