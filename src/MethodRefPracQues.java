import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

class Employee{
    Integer id;
    String name;
    Integer rollNo;
    Integer count = 0;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollNo=" + rollNo +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId() {
        this.id = ++count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    Employee(){

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(rollNo, employee.rollNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rollNo);
    }

    Employee(Integer id){
        this.id = id;
    }
    Employee(String name){
        this.name = name;
    }
}
public class MethodRefPracQues {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Sumiran", "s1", "s2"));

        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println(string);
            }
        };
        Consumer<String> consumer = System.out::println;
        list.forEach(System.out::println);
        Function<String, Employee> func1 = new Function<String, Employee>() {
            @Override
            public Employee apply(String string) {
                return new Employee(string);
            }
        };

        Function<String, Employee> func2 = Employee::new;
        list.stream()
                .map(Employee::new)
                .map(a-> {
                    a.setId();
                    return a;
                })
                .map(Employee::getName)//emp.getName
                .map(String::toUpperCase)
                .forEach(System.out::println);
        ;
    }
}
