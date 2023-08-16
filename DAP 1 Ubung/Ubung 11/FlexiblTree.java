
public class FlexiblTree<T extends Comparable<T>> {
    private CounterStrategy counterGenerator;
    private FlexiblTree<T> leftChild, rightChild;
    private T content;
    private Counter quantity;

    public interface CounterStrategy {
        public abstract Counter generateCounter();
    }

    public interface Counter {
        public abstract void increment();

        public abstract void decrement();

        public abstract int getValue();
    }

    public FlexiblTree(CounterStrategy s){
        leftChild=null;
        rightChild=null;
        content=null;
        counterGenerator=s;
        this.quantity=s.generateCounter();
        

    }
    public void add(T t){
        if(isEmptyNode()){
            content=t;
            leftChild=new FlexiblTree<T>(counterGenerator);
            rightChild=new FlexiblTree<T>(counterGenerator);
            quantity.increment();

        }else if(content.compareTo(t)>0){
            leftChild.add(t);
        }else if(content.compareTo(t)<0){
            rightChild.add(t);
        }else{
            quantity.increment();
        }

    }
    //some node can be not empty but have quantity lower than 0
    private boolean isEmptyNode(){
        return content==null;
    }
    public boolean isEmpty(){
        if(isEmptyNode()){
            return true;
        }else{
            if(quantity.getValue()<=0){
                return leftChild.isEmpty()&&rightChild.isEmpty();
            }else{
                return false;
            }
        }
    }
    public boolean isLeaf(){
        return !isEmptyNode()&& quantity.getValue()>0&&leftChild.isEmpty()&&rightChild.isEmpty();
    }
    public boolean contains(T t){
        return getQuantity(t)>0;
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

}