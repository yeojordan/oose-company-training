/**
* @Author: Jordan Yeo
* @Date:   22/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: An exception for an issue with a BusinessUnit
*/


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
