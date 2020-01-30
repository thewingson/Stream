package task3;

@FunctionalInterface
public interface Writer<T> {

    void doIt(T t);

    default void print(T t){
        System.out.println(t);
    }

    static void printW(){
        System.out.println("W");
    }

}
