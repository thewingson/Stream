package task2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Almat on 30.01.2020
 */
public class Box<T> {

    public static <T extends String, K extends Integer, M extends Integer> T sum(K argK, M argM){
        return (T) String.valueOf((Integer)argK + (Integer) argM);
    }

    public static void main(String[] args) {
        String a = Box.sum(1, 4);

        List<String> asd = new ArrayList<>();

        System.out.println(a);

    }

}
