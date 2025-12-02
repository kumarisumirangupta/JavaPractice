public class Car implements Comparable<Car> {
    private Integer id;
    private String name;
    private String type;
    private int i;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", i=" + i +
                '}';
    }

    public int getI(){
        return i;
    }

    Car(Integer id, String name, String type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int compareTo(Car o) {
        return this.getId() - o.getId();
    }
}
