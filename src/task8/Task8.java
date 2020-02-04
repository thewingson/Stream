package task8;

import java.util.*;

public class Task8 {

    public static void main(String[] args) {

        MagicTree magicTree22 = new MagicTree(22, (MagicTree) null);
        MagicTree magicTree21 = new MagicTree(21, (MagicTree) null);
        MagicTree magicTree12 = new MagicTree(12, (MagicTree) null);
        MagicTree magicTree11 = new MagicTree(11, (MagicTree) null);

        MagicTree magicTree1 = new MagicTree(1, new LinkedList<MagicTree>() {{
            add(magicTree11);
            add(magicTree12);
        }});
        MagicTree magicTree2 = new MagicTree(2, new LinkedList<MagicTree>() {{
            add(magicTree21);
            add(magicTree22);
        }});

        MagicTree magicTree0 = new MagicTree(0, new LinkedList<MagicTree>() {{
            add(magicTree1);
            add(magicTree2);
        }});


        List<Integer> flattened = magicTree2.flattened();
        System.out.println(flattened);


    }

}