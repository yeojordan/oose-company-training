package model.exceptions;

public class ValueEventException extends EventException
{
    public ValueEventException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ValueEventException(String message)
    {
        super(message);
    }

}
