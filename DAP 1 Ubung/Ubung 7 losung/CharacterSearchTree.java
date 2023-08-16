public class CharacterSearchTree 
{
    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

    public CharacterSearchTree() 
    {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public HuffmanTriple getContent()
    {
        if ( !isEmpty() )
        {
            return content;
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean isEmpty() 
    {
        return content == null;
    }

    public boolean isLeaf() 
    {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void add( char t )
    {
        if ( isEmpty() ) 
        {
            content = new HuffmanTriple( t );
            leftChild = new CharacterSearchTree();
            rightChild = new CharacterSearchTree();
        }
        else
        {
            if ( content.getToken() > t )
            {
                leftChild.add( t );
            }
            else if ( content.getToken() < t )
            {
                rightChild.add( t );
            }
            else
            {
                content.incrementQuantity();
            }
        }
    }

    public void iterativeAdd( char t )
    {
        CharacterSearchTree current = this;
        while ( !current.isEmpty() && current.content.getToken() != t )
        {
            if ( current.content.getToken() > t )
            {
                current = current.leftChild;
            }
            else
            {
                current = current.rightChild;
            }
        }
        if ( current.isEmpty() ) 
        {
            current.content = new HuffmanTriple( t );
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        }
        else
        {
            current.content.incrementQuantity();
        }
    }

    public String getCode( char t )
    {
        if ( !isEmpty() ) 
        {
            if ( content.getToken() > t )
            {
                return leftChild.getCode( t );
            }
            else if ( content.getToken() < t )
            {
                return rightChild.getCode( t );
            }
            else
            {
                return content.getCode();
            }
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    public int size() 
    {
        if ( isEmpty() ) 
        {
            return 0;
        }
        else
        {
            return 1 + leftChild.size() + rightChild.size();
        }       
    }

    public void show()
    {
        if ( !isEmpty() ) 
        {
            leftChild.show();
            System.out.println( content.toString() );
            rightChild.show();
        }
    }

    public HuffmanTriple[] toArray()
    {
        if ( !isEmpty() ) 
        {
            HuffmanTriple[] collector = new HuffmanTriple[size()];
            toArray( collector, 0 );
            return collector;
        }
        return new HuffmanTriple[0];
    }

    private int toArray( HuffmanTriple[] collector, int index ) 
    {
        if ( !isEmpty() )
        {
            index = leftChild.toArray( collector, index );
            collector[index] = content;
            index = rightChild.toArray( collector, index + 1 );
        }
        return index;
    }
   

    // Uebungsblatt 7 - Loesungen
    
    // Aufgabe 7-2
    public int height()
    {
        if ( !isEmpty() ) 
        {
            int leftHeight = leftChild.height();
            int rightHeight = rightChild.height();
            if ( leftHeight > rightHeight )
            {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        } else {
            return 0;
        }
    }

    // Aufgabe 7-3
    public int[] levelWidths()
    {
        int[] result = new int[height()];
        levelWidths( result, 0 );
        return result;
    }

    private void levelWidths( int[] widths, int level)
    {
        if ( !isEmpty() )
        {
            widths[level]++;
            leftChild.levelWidths( widths, level + 1 );
            rightChild.levelWidths( widths, level + 1 );
        }
    }

    public int maxLevelWidth()
    {
        int[] widths = levelWidths();
        int max = 0;
        for ( int current : widths )
        {
            if (current > max)
                max = current;
        }
        return max;
    }

    // Aufgabe 7-4

    public void breadthFirstTraversal() 
    {
        if ( ! isEmpty() ) 
        {
            int max = maxLevelWidth();
            RingBuffer buffer = new RingBuffer( max + max / 2 );
            buffer.push( this );
            while ( buffer.countElements() != 0 ) {
                CharacterSearchTree current = buffer.pop();
                System.out.print( current.getContent().getToken() + " " );
                if ( ! current.leftChild.isEmpty() ) 
                {
                    buffer.push( current.leftChild );
                }
                if ( ! current.rightChild.isEmpty() ) 
                {
                    buffer.push( current.rightChild );
                }
            }
            System.out.println();
        }
    }

    // zusaetzliche Variante: Breitendurchlauf in Feld ablegen
    public CharacterSearchTree[] breadthFirstToArray() 
    {
        if ( ! isEmpty() ) 
        {
            CharacterSearchTree[] result = new CharacterSearchTree[size()];
            result[0] = this;
            int insert = 1;
            for ( int i = 0; i < result.length - 1; i++ ) 
            {
                if ( ! result[i].leftChild.isEmpty() ) 
                {
                    result[insert++] = result[i].leftChild;
                }
                if ( ! result[i].rightChild.isEmpty() ) 
                {
                    result[insert++] = result[i].rightChild;
                }
            }
            return result;
        }
        return new CharacterSearchTree[0];
    }

}
