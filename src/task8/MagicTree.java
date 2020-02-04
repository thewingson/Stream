package task8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toCollection;

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

    public List<Integer> flattenedListValues(){
        List<Integer> list = new LinkedList<>();
        list.add(this.value);
        for (MagicTree m: children) {
            list.addAll(m.flattenedListValues());
        }
        return list;
    }

    public List<MagicTree> flattenedMagicTree(){
        List<MagicTree> list = new LinkedList<>();
        list.add(this);
        for (MagicTree m: children) {
            list.addAll(m.flattenedMagicTree());
        }
        return list;
    }

    public Stream<MagicTree> flattenedStream() {
        return Stream.concat(
                Stream.of(this),
                children.stream().flatMap(MagicTree::flattenedStream));
    }

    @Override
    public String toString() {
        return "{" + value + '}';
    }
}
