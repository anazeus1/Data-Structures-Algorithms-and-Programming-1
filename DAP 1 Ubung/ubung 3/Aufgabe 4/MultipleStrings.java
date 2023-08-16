public class MultipleStrings 
{
    private String[] texts;

    public MultipleStrings( int n )
    {
        texts = new String[Math.abs( n )];
    } 
    
    public boolean addAtPosition( String s, int p )
    {
        if ( p >=0 && p< texts.length )
        {
            texts[p] = s;
            return true;
        }
        return false;
    }
    
    public int size()
    {
        int count = 0;
        for( String s : texts )
        {
            if ( s != null )
            {
                ++count;
            }
        }
        return count;
    }
    
    public int atEnd( String end )
    {
        int count = 0;
        for( String s : texts )
        {
            if ( s != null && s.endsWith(end) )
            {
                ++count;
            }
        }
        return count;
    }
    
    public boolean inAll( char c )
    {
        for ( String s : texts )
        {
            if ( s != null && s.indexOf( c ) == -1 )
            {
                return false;
            }
        }
        return true;
    }
    
    public void replace( char c, char r )
    {
        for ( int i = 0; i < texts.length; ++i )
        {
            if ( texts[i] != null )
            {
                texts[i] = texts[i].replace( c, r );
            }
        }
    }

   

}     
