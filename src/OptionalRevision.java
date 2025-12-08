import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class OptionalRevision {

    public static void main(String[] args) {
        /*//Creation of optional object
        Optional<Integer> optional1 = Optional.of(5);
        System.out.println(optional1.get());
        optional1 = Optional.of(null); //Throws NPE value must be not null

        Optional<Integer> optional2 = Optional.ofNullable(7);
        System.out.println(optional2.get());
        optional2 = Optional.ofNullable(null);

        Optional<Integer> optional3 = Optional.empty();
        System.out.println(optional3.isPresent());

        Optional<Integer> optional4 = Optional.empty();
        System.out.println(optional4.hashCode());
        System.out.println(optional3 == optional4); //uses singleton for empty returns same object by typecasting it
        System.out.println(System.identityHashCode(optional3));
        System.out.println(System.identityHashCode(optional4));

        Optional<String> optional5 = Optional.empty();
        System.out.println(System.identityHashCode(optional5)); */

        /*//presence checking of optional value
        Optional<Integer> optional1 = Optional.of(5);
        System.out.println(optional1.isPresent()); //true
        System.out.println(optional1.isEmpty()); //false

        Optional<Integer> optional2 = Optional.empty();
        System.out.println(optional2.isPresent()); //false
        System.out.println(optional2.isEmpty()); //true*/

        /*//Retrieving values from optional object
        //1-> get() method
        Optional<Integer> notNullableOptional = Optional.of(5);
        Optional<String> emptyOptional = Optional.empty();
        Optional<Integer> nullableOptional = Optional.ofNullable(null);

        System.out.println(notNullableOptional.get());
        System.out.println(emptyOptional.orElse("empty optional getting value from or else"));
        String s = emptyOptional.orElseGet(() -> {return "returning from supplier";});
        System.out.println(s);
        //Integer integer = nullableOptional.orElseThrow();
        try {
            nullableOptional.orElseThrow(new Supplier<Exception>() {
                @Override
                public Exception get() {
                    return new ArithmeticException("Throwing Arithmetic exception");
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        emptyOptional.or(() -> Optional.of("empty optinal trying by or"));*/

        //Transforming Values
        /*Optional<Integer> notNullableOptional = Optional.of(5);
        Optional<String> emptyOptional = Optional.empty();
        Optional<Integer> optionalArray = Optional.of(1);

        Optional<Integer> optionalI = notNullableOptional.map(a -> a * 10); //Returns optional
        System.out.println(optionalI.get());

        Optional<Integer> optionalI1 = notNullableOptional.flatMap(a -> Optional.of(a * 10)); //manually returns optional

        Optional<Integer> optionalI2 = optionalArray.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integers) {
                return integers > 5;
            }
        });
        if(optionalI2.isPresent()) {
            System.out.println(optionalI2.get());
        }else{
            System.out.println("optionalI2 is empty");
        }*/

        //Action Based Methods
        /*Optional<String> emptyOptional = Optional.of("hello Java");
        emptyOptional.ifPresent((val) -> System.out.println("value is "+ val));

        emptyOptional = Optional.empty();
        emptyOptional.ifPresentOrElse((val) -> System.out.println("value is "+ val) , () -> System.out.println("Empty optional running else part"));*/

        //Stream Integration
        List<UserDetails> userDetailsList = Arrays.asList(new UserDetails("abcd@gmail.com"), new UserDetails("emal1.gmail.com"), new UserDetails("hello@gmail.com"),
                new UserDetails(null));
        List<String> list = userDetailsList.stream()
                .map(UserDetails::getEmail)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        System.out.println(list);

        //Same using Optional.stream
        List<String> list1 = userDetailsList.stream()
                .map(UserDetails::getEmail)
                .flatMap(Optional::stream)
                .toList();
        System.out.println(list1);


    }

    static class UserDetails{
        String email;

        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }

        public void setEmails(String email) {
            this.email = email;
        }

        UserDetails(String email){
            this.email = email;
        }
    }
}
