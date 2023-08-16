/*Each subclass of the Comparable class allows any two objects of a type T to be compared with one another */
/*Die Objekte von Unterklassen der Klasse Comparable sind also geeignete Inhalte für binäre
Suchbäume, da die geforderte Ordnung hergestellt werden kann.*/
public abstract class Comparable<T>
{
    public abstract int compareTo( T t );
}
