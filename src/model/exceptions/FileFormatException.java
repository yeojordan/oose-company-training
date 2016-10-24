/**
* @Author: Jordan Yeo
* @Date:   22/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: An exception for an issue with an input file
*/


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
