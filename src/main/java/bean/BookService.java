package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Book;

@ManagedBean
@SessionScoped
public class BookService implements Serializable{

    private static final long serialVersionUID = 1L;

    private List<Book> books;

    public BookService() {
        books = new ArrayList<Book>();

        Book[] book = new Book[9];

        book[0] = new Book(1l, "CASSINO ROYALE - JAMES BOND 007", "Ian Fleming", "james.jpg" , 29.90);   

        book[1] = new Book(2l, "FILOSOFIA DO TEDIO", "Lars Svendsen", "tedio.jpg" , 38.80);

        book[2] = new Book(3l, "O CASAMENTO", "Nelson Rodrigues", "casamento.jpg", 39.90);

        book[3] = new Book(4l, "NEVE", "Orhan Pamuk","neve.jpg" , 54.00);

        book[4] = new Book(5l,"VOLTA AO MUNDO EM OITENTA DIAS", "Julio Verne", "volta_mundo.jpg", 16.50);

        book[5] = new Book(6l, "GRANDE SERTÃO - VEREDAS", "Guimarães Rosa","veredas.jpg", 31.50);

        book[6] = new Book(7l, "QUANDO NIETZSCHE CHOROU", "Irvin D. Yalom","chorou.jpg", 49.90);

        book[7] = new Book(8l, "CRISTOVAO COLOMBO", "Julio Verne","cristovao_colombo.jpg", 16.50);

        book[8] = new Book(9l, "VINTE MIL LEGUAS SUBMARINAS", "Julio Verne","submarinas.jpg", 14.90);

        books.add(book[0]);
        books.add(book[1]);
        books.add(book[2]);
        books.add(book[3]);
        books.add(book[4]);
        books.add(book[5]);
        books.add(book[6]);
        books.add(book[7]);
        books.add(book[8]);
    }

    public List<Book> getBooks() {
        return books;
    }
}
