public abstract class FileReading
{
    // Template Method
    public void read(String filename)
    {
        // Open File
        
        // Read File Contents
        readFile(filename)
        // Close File
    }

    abstract void readFile(String filename);
}
