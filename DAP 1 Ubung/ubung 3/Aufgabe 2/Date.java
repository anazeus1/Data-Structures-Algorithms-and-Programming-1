


public class Date
{

    private String description;
    private PointInTime start;
    private Period duration;

    public Date( String d, PointInTime s, Period p )
    {
       description = d;
       start = s;
       duration = p;
    }
    
    public Date clone()
    {
        return new Date( description, start.clone(), duration.clone() );
    }

    public void set( PointInTime s, Period d )
    {        
        start = s;
        duration = d;
    }
    
    public void change( int hours )
    {        
        if ( start != null )
        {
            start.change( hours );
        }
    }
    
    public String toString()
    {
        String s =  description + ":  start = ";
        if ( start != null ) 
        {
            s += start.toString();
        } 
        else 
        {
            s += "unbestimmt";
        }
        s += "  duration = ";
        if ( duration != null )
        {
           s += duration.toString();
        }
        else
        {
            s += "unbestimmt";
        }
        return s;
    }

}
