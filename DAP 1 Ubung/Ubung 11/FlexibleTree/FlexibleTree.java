public class FlexibleTree<T extends Comparable<T>>
{
    // --- Vorgaben ---
    
    private T content;
    private FlexibleTree<T> leftChild, rightChild;
    private CounterStrategy counterGenerator;
    private Counter quantity;

    public interface CounterStrategy
    {
        public abstract Counter generateCounter();
    }

    public interface Counter 
    {
        public abstract void increment();
        public abstract void decrement();
        public abstract int getValue();
    }

    public FlexibleTree( CounterStrategy s ) 
    {
        content  = null;
        leftChild = null;
        rightChild = null;
        counterGenerator = s;
        quantity = counterGenerator.generateCounter();
    }
    

    // unterstuetzende Methode:
    // prueft genau den vorliegenden Knoten, ob er alleine einen leeren Baum repraesentiert;
    // leere Baeume koennen auch aus Zombie-Knoten mit quantity<=0 aufgebaut sein 
    private boolean isEmptyNode() 
    {
        return content == null;
    }

    
    // --- Loesungen --- 
        
    // Operation auf einem Teilbaum
    // prueft, ob alle Knoten des Teilbaums leere Baeume oder Zombie-Knoten mit
    // quantity<=0 sind
    public boolean isEmpty() 
    {
        if ( isEmptyNode() )   
        {
            return true;
        }
        else 
        {
            if ( quantity.getValue()<=0 )
            {
                return leftChild.isEmpty() && rightChild.isEmpty();
            }
            else
            {
                return false;
            }
        }
    }

    // Operation auf einem Teilbaum
    // prueft, ob alle Knoten der beiden Teilbaeume leere Baeume sind
    // und der Knoten selbst auch nicht leer oder Zombie-Knoten ist
    public boolean isLeaf() 
    {
        return !isEmptyNode() && quantity.getValue()>0 && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void add( T t )
    {
        if ( isEmptyNode() )  
        {
            content = t;
            quantity.increment();
            leftChild = new FlexibleTree<T>(counterGenerator);
            rightChild = new FlexibleTree<T>(counterGenerator);
        }
        else
        {
            if ( content.compareTo( t ) > 0 )
            {
                leftChild.add( t );
            }
            else if ( content.compareTo( t ) < 0 )
            {
                rightChild.add( t );
            }
            else 
            {
                quantity.increment();
            }
        }
    }

    public int getQuantity( T t )
    {
        if ( isEmptyNode() )  
        {
            return 0;
        }
        else
        {
            if ( content.compareTo( t ) > 0 )
            {
                return leftChild.getQuantity( t );
            }
            else if ( content.compareTo( t ) < 0 )
            {
                return rightChild.getQuantity( t );
            } 
            return quantity.getValue();
        }
    }

    public boolean contains( T t )
    {
        return getQuantity( t ) > 0;
    }

    public T get( T t )
    {
        if ( !isEmptyNode() ) 
        {
            if ( content.compareTo( t ) > 0 )
            {
                return leftChild.get( t );
            }
            else if ( content.compareTo( t ) < 0 )
            {
                return rightChild.get( t );
            } 
            else 
            {
                if ( quantity.getValue()>0 )
                {
                    return content;
                }
            }
        }
        return null;
    }

    public void delete( T t )
    {
        if ( !isEmptyNode() )      
        {
            if ( content.compareTo( t ) > 0 )
            {
                leftChild.delete( t );
            }
            else if ( content.compareTo( t ) < 0 )
            {
                rightChild.delete( t );
            } 
            else 
            {
                quantity.decrement();
            }
        }
    }

    public int size() 
    {
        if ( isEmptyNode() ) 
        {
            return 0;
        }
        else
        {
            if ( quantity.getValue() > 0 )
            {
                return 1 + leftChild.size() + rightChild.size();
            }
            else
            {
                return leftChild.size() + rightChild.size();
            }
        }       
    }

    public void show()
    {
        if ( !isEmptyNode() ) 
        {
            leftChild.show();
            if ( quantity.getValue() > 0 ) 
            { 
                System.out.println( content );
            }
            rightChild.show();
        }
    } 

}
