package model.exceptions;

public class CompanyException extends PropertyException
{
    public CompanyException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CompanyException(String message)
    {
        super(message);
    }
}
