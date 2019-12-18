package springframework.guru.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author kas
 */
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String isbn;
    private String publisher;

    @ManyToMany()
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name =" book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authorSet = new HashSet<>();

    public Book(String title, String isbn, String publisher, Set<Author> authorSet) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authorSet = authorSet;
    }

    public Book(String title, String isbn, String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authorSet=" + authorSet +
                '}';
    }
}