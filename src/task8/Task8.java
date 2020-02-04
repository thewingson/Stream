package task8;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Task8 {

    public static void main(String[] args) {

        MagicTree magicTree22 = new MagicTree(22, new LinkedList<>());
        MagicTree magicTree21 = new MagicTree(21, new LinkedList<>());
        MagicTree magicTree13 = new MagicTree(13, new LinkedList<>());
        MagicTree magicTree12 = new MagicTree(12, new LinkedList<>());
        MagicTree magicTree11 = new MagicTree(11, new LinkedList<>());

        MagicTree magicTree1 = new MagicTree(1, new LinkedList<MagicTree>() {{
            add(magicTree11);
            add(magicTree12);
            add(magicTree13);
        }});
        MagicTree magicTree2 = new MagicTree(2, new LinkedList<MagicTree>() {{
            add(magicTree21);
            add(magicTree22);
        }});

        MagicTree magicTree0 = new MagicTree(0, new LinkedList<MagicTree>() {{
            add(magicTree1);
            add(magicTree2);
        }});


//        List<Integer> flattenedListValues = magicTree0.flattenedListValues();
//        System.out.println(flattenedListValues);

//        List<MagicTree> flattenedMagicTree = magicTree0.flattenedMagicTree();
//        System.out.println(flattenedMagicTree);

        magicTree0.flattenedStream().forEach(System.out::println);



    }

}
