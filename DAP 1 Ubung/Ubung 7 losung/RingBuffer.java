public class RingBuffer 
{
    private CharacterSearchTree[] buffer;
    private int readPos,writePos;
    private int elements;

    public RingBuffer(int n)
    {
        if ( n <= 0 )
        {
            throw new RuntimeException("n has to be bigger than 0");
        }
        buffer = new CharacterSearchTree[n]; 
        readPos = writePos = 0;
        elements = 0;
    }

    public CharacterSearchTree pop()
    {
        if ( countElements() > 0)
        {
            CharacterSearchTree temp = buffer[readPos];
            readPos = (readPos + 1)%buffer.length;
            elements--;
            return temp;
        } else {
            throw new RuntimeException("no elements in buffer");
        }
    }

    public CharacterSearchTree peek(){
        if ( countElements() > 0 )
        {
            return buffer[readPos];
        }else{
            throw new RuntimeException("no elements in buffer");
        }
    }

    public void push(CharacterSearchTree s)
    {
        if ( countElements() < size() )
        {
            buffer[writePos] = s;
            writePos = (writePos + 1)%buffer.length;
            elements++;
        } else {
            throw new RuntimeException("buffer full");
        }
    }

    public int size()
    {
        return buffer.length;
    }

    public int countElements()
    {
        return elements;
    }   
    
}
