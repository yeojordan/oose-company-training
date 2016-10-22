package model.exceptions;

public class EventException extends FileFormatException
{
    public EventException(String message, Throwable cause)
    {
        super(message + cause.getMessage(), cause);
    }

    public EventException(String message)
    {
        super(message);
    }

}
