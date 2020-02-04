package task8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public LinkedList<MagicTree> flattened(){

        LinkedList<MagicTree> temp = children.stream().map(magicTree -> {
            if(magicTree.getChildren().get(0) == null){
                return magicTree;
            }else {
                magicTree.flattened();
                return magicTree;
            }
        }).collect(Collectors.toCollection(LinkedList::new));
        temp.addFirst(this);

        return temp;

    }

    public void flattenedVoid(){

        children.stream().filter(magicTree -> {
            if(magicTree.getChildren().get(0) == null){
                return true;
            }else {
                magicTree.flattenedVoid();
                return true;
            }
        }).forEach(System.out::println);

    }

    public List<Integer> flattenedListValues(){
        if(children.get(0) != null){
            List<Integer> list = new ArrayList<>();
            list.add(value);
            for (MagicTree m: children) {
                list.addAll(m.flattenedListValues());
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
