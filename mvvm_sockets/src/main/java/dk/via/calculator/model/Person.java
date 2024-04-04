package dk.via.calculator.model;

public record Person(String name, String address) {
    public Person withName(String name) {
        return new Person(name, address);
    }

    public Person withAddress(String address) {
        return new Person(name, address);
    }

    public static void main(String[] args) {
        Person a = new Person("Donald Duck", "1313 Webfoot Walk, Duckburg");
        Person b = a.withAddress("13 Quack Street, Duckburg");
        System.out.println(b);
    }
}
