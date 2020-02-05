package task8;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
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

    public List<Integer> getAllValues() {
        List<Integer> list = new LinkedList<>();
        list.add(this.value);
        for (MagicTree m : children) {
            list.addAll(m.getAllValues());
        }
        return list;
    }

    public List<Integer> getAllEvenValues() {
        List<Integer> list = new LinkedList<>();
        if(this.value % 2 == 0){
            list.add(this.value);
        }
        for (MagicTree m : children) {
            list.addAll(m.getAllEvenValues());
        }
        return list;
    }

    public List<MagicTree> flattenedMagicTree() {
        List<MagicTree> list = new LinkedList<>();
        list.add(this);
        for (MagicTree m : children) {
            list.addAll(m.flattenedMagicTree());
        }
        return list;
    }

    public Stream<MagicTree> flattenedStream() {
        return Stream.concat(
                Stream.of(this),
                children.stream().flatMap(MagicTree::flattenedStream));
    }

    public Optional<Integer> sumOfEvenValues() {
        Optional<Integer> sum = Optional.of(0);
        if(this.value % 2 == 0){
            sum = Optional.of(sum.get() + this.value);
        }
        for (MagicTree m : children) {
            sum = Optional.of(sum.get() + m.sumOfEvenValues().get());
        }
        return sum;
    }

    @Override
    public String toString() {
        return "{" + value + '}';
    }
}
