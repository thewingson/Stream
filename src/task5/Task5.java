package task5;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {

    public static void main(String[] args) {
        //Task 5. (20 points) Collection to stream
        System.out.println("Task 5: ");

        Author author1 = new Author("Almat", Short.valueOf("22"), null);
        Author author2 = new Author("Vlad", Short.valueOf("28"), null);
        Author author3 = new Author("Aziza", Short.valueOf("20"), null);

        Book book1 = new Book("Java", new ArrayList<Author>() { {add(author1);add(author2);} }, 194);
        Book book2 = new Book("React",  new ArrayList<Author>() { {add(author1);add(author3);} }, 894);
        Book book3 = new Book(".Net",  new ArrayList<Author>() { {add(author3);} }, 342);

        author1.setBooks(new ArrayList<Book>() { {add(book1);add(book2);} });
        author2.setBooks(new ArrayList<Book>() { {add(book1);add(book3);} });
        author3.setBooks(new ArrayList<Book>() { {add(book2);add(book3);} });

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        List<Author> authorList = new ArrayList<>();
        authorList.add(author1);
        authorList.add(author2);
        authorList.add(author3);

        System.out.println("#3.1 - check if some/all book(s) have more than 200 pages");
        bookList.stream().filter(book -> book.getNumberOfPages() > 200).forEach(book -> System.out.println(book.getTitle()));

        System.out.println("#3.2 - find the books with max and min number of pages");
        Book max = bookList.stream().max(Comparator.comparing(Book::getNumberOfPages)).orElseThrow(NoSuchElementException::new);
        System.out.println(max.getTitle());

        System.out.println("#3.3 - filter books with only single author");
        bookList.stream().filter(book -> book.getAuthors().size() == 1).forEach(book -> System.out.println(book.getTitle()));

        System.out.println("#3.4 - sort the books by number of pages/title");
        bookList.stream().sorted((Comparator.comparing(Book::getTitle))).forEach(book -> System.out.println(book.getTitle()));
        bookList.stream().sorted((Comparator.comparing(Book::getNumberOfPages))).forEach(book -> System.out.println(book.getTitle()));

        System.out.println("#3.5 - get list of all titles");
        List<String> collect = bookList.stream().map(Book::getTitle).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("#3.7 - get distinct list of all authors");
        List<Book> collect1 = bookList.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);

        System.out.println("#4 - Use peek method for debugging intermediate streams during execution the previous task");
//        bookList.stream().distinct().peek(book -> book.setNumberOfPages(100)).collect(Collectors.toList()).forEach(book -> System.out.println(book.getNumberOfPages()));

        System.out.println("#5 - Use parallel stream with subtask #3");
        bookList.stream().parallel().filter(book -> book.getNumberOfPages() < 200).forEach(book -> System.out.println(book.getTitle()));

        System.out.println("#7 - Use the Optional type for determining the title of the biggest book of some author");
        Optional<Book> first = bookList.stream().filter(book -> book.getAuthors().contains(author3)).max(Comparator.comparing(Book::getNumberOfPages));
        first.ifPresent(book -> System.out.println(book.getTitle()));


        System.out.println("------------------------------");
    }
}
