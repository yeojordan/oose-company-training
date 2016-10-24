/**
* @Author: Jordan Yeo
* @Date:   22/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: An exception for an issue with a Revenue Event
*/


package model.exceptions;

public class RevenueEventException extends EventException
{
    public RevenueEventException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public RevenueEventException(String message)
    {
        super(message);
    }



}
