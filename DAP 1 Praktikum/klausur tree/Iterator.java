public interface Iterator<T>
{
    //The syntax of generic interfaces corresponds to that of generic classes. The interface is declared in the same way as the known class:
    boolean hasNext(); //stands in a class for public abstract boolean hasNext()
    T next();
}
