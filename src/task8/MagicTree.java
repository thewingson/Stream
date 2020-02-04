package task8;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

import static java.util.Arrays.asList;

public class MagicTree {

    private int value;

    private List<MagicTree> children = new LinkedList<>();

    public MagicTree(int value, List<MagicTree> children) {
        super();
        this.value = value;
        this.children.addAll(children);
    }

    public MagicTree(int value, MagicTree... children) {
        this(value, asList(children));
    }

    public int getValue() {
        return value;
    }

    public List<MagicTree> getChildren() {
        return Collections.unmodifiableList(children);
    }

//    public Stream<MagicTree> flattened(){
//
//        return children.stream().filter(magicTree -> {
//            if(magicTree.getChildren() != null) {
//                magicTree.getChildren().stream().
//            }
//        });
//
//    }

    public List<Integer> flattened(){
        if(children.get(0) != null){
            List<Integer> list = new ArrayList<>();
            list.add(value);
            for (MagicTree m: children) {
                list.addAll(m.flattened());
            }
            return list;
        } else {
            return new ArrayList<Integer>(){{add(value);}};
        }
    }

    @Override
    public String toString() {
        return "{" + value + '}';
    }
}
