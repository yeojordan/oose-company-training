package model.exceptions;

public class FileFormatException extends Exception
{
    public FileFormatException(String message, Throwable cause)
    {
        super(message + cause.getMessage() , cause);
    }

    public FileFormatException(String message)
    {
        super(message);
    }

}
