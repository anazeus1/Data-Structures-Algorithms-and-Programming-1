public class SimpleCountStrategy implements FlexibleTree.CounterStrategy
{
    public FlexibleTree.Counter generateCounter() 
    {
        return new FlexibleTree.Counter()
        {
            private int c = 0;
            public void increment() { c = 1; }
            public void decrement() { c = 0; } 
            public int getValue() { return c; }
        };
    }
}