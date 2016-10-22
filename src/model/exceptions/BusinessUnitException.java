package model.exceptions;

public class BusinessUnitException extends PropertyException
{
    public BusinessUnitException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public BusinessUnitException(String message)
    {
        super(message);
    }
}
