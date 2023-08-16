import java.util.function.*;
import java.util.*;

public class LamdaTest {

    public static void main(String[] args) {
        // The java.util.function package contains numerous predefined functional
        // interfaces
        Function<Integer, Integer> f = x -> x * x;
        Function<Integer, Integer> g = x -> 3 * x;
        System.out.println(f.compose(Function.identity()).apply(5));// creates a Function object that defines f(id(x))
                                                                    // and for which f(id(5)) = 25 is calculated by the

        /*
         * creates Function object that defines f(g(x)) and for which f(g(5)) = 225 is
         * calculated by the apply call.
         */ // apply call.
        System.out.println(f.compose(g).apply(5));
        // creates a function object that defines g(f(x)) and for which g(f(5)) = 75 is
        // calculated by the apply call
        System.out.println(f.andThen(g).apply(5));
        // System.out.println( f.andThen( g ).compose( x -> x + 7 ).apply( 5 ) ) No type
        // determination possible because the parameter type of compose contains too few
        // specifications

        System.out.println(f.andThen(g).compose((Integer x) -> x + 7).apply(5));// creates a function object that
                                                                                // defines g(f(x+7)) and for which
                                                                                // g(f(5+7)) = 432 is calculated by the
                                                                                // apply call.
        System.out.println(((Function<Integer, Integer>) (Integer x) -> x + 7).apply(5));// type casting is moglich

        // The methods of implicitly created classes can be built on top of existing
        // methods:
        Predicate<Integer> gto = x -> BooleanUtilities.positiveNumber(x);
        Predicate<Integer> gto1 = BooleanUtilities::positiveNumber;// samme thing
        gto.test(5);

        List<Integer> numbers = new LinkedList<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(11);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.iterator().forEachRemaining(x -> System.out.print(x + " "));// 2 4 11 5 6 7
        System.out.println();
        Iterator<Integer> it = numbers.iterator();
        it.next();
        it.forEachRemaining(x -> System.out.print(x + " "));// 4 11 5 6 7
        System.out.println();

        // numbers.replaceAll(x -> x + 3);
        numbers.iterator().forEachRemaining(x -> System.out.print(x + " "));
        System.out.println();// 5 7 14 8 9 10
        //numbers.sort((x, y) -> y - x);//descending order becaus sort ascending
        numbers.iterator().forEachRemaining(x -> System.out.print(x + " "));
        System.out.println();//11 7 6 5 4 2
        // numbers.sort( (x,y) -> x % 2 - y % 2 );odd greater than even
        numbers.iterator().forEachRemaining(x -> System.out.print(x + " "));
        System.out.println();//2 4 6 11 5 7
        numbers.sort((x, y) -> y % 2 - x % 2);
        numbers.iterator().forEachRemaining(x -> System.out.print(x + " "));//even greatr than odd
        System.out.println();//11 7 5 6 4 2
    }
}
