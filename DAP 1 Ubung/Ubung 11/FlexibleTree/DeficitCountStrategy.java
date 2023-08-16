public class DeficitCountStrategy implements FlexibleTree.CounterStrategy
{
    public FlexibleTree.Counter generateCounter() 
    {
        return new FlexibleTree.Counter()
        {
            private int c = 0;
            public void increment() { c++; }
            public void decrement() { c--; } 
            public int getValue() { return c; }
        };
    }
}
