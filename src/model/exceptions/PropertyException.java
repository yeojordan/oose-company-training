package model.exceptions;

public class PropertyException extends FileFormatException
{
    public PropertyException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PropertyException(String message)
    {
        super(message);
    }
}
