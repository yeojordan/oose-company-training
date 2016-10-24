/**
* @Author: Jordan Yeo
* @Date:   22/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: An exception for an issue with a Wage Event
*/


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
