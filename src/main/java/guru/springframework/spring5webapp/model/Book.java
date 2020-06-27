package guru.springframework.spring5webapp.model;
import guru.springframework.spring5webapp.model.Author;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String ISBN;

    @ManyToMany
    @JoinTable(name="author_book", joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn (name="author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(String name, String ISBN) {
        this.name = name;
        this.ISBN = ISBN;
    }

    public Book(String name, String ISBN, Set<Author> authors) {
        this.name = name;
        this.ISBN = ISBN;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", authors=" + authors +
                '}';
    }
}
