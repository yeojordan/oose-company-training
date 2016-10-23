package controller.observer;

public interface WageObserver
{
    /**
     * Method to update wages for Wage observers
     * @param multiplier Value to multiply wages by
     */
    public void update(double multiplier);
}
