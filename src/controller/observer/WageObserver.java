/**
* @Author: Jordan Yeo
* @Date:   06/10/2016
* @Project: OOSE Assignment SEM 2 2016
* @Last modified by:   Jordan Yeo
* @Last modified time: 24/10/2016
* @Purpose: Interface all observers of wage changes implement. 
*/


package controller.observer;

public interface WageObserver
{
    /**
     * Method to update wages for Wage observers
     * @param multiplier Value to multiply wages by
     */
    public void update(double multiplier);
}
