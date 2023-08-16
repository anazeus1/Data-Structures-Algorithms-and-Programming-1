


public class Period
{

    private int minutes;

    public Period(int minutes)
    {
        if (minutes < 0)
        {
            this.minutes = 0;
        }
        else
        {
            this.minutes = minutes;
        }
    }
    
    public Period(int minutes, int hours)
    {
        if (minutes < 0 || hours < 0)
        {
            this.minutes = 0;
        }
        else
        {
            this.minutes = hours * 60 + minutes;
        }
    }

    public int getMinutes()
    {
       return minutes; 
    }
    
    public int getHours()
    {
       return minutes / 60; 
    }
    
    public int getMinorMinutes()
    {
       return minutes % 60; 
    }
    
    public String toString()
    {
        String s,m;
        if (getHours() < 10)
        {
            s = "0";
        }
        else
        {
            s = "";
        }        
        if (getMinorMinutes() < 10)
        {
            m = "0";
        }
        else
        {
            m = "";
        }
        return s + getHours() + ":" + m + getMinorMinutes();
    }
        
    public Period clone()
    {
       return new Period(minutes);
    }
    
    public void change(int m)
    {
       if (m > 0)
       {
           minutes += m;
       }
    }
    
}
