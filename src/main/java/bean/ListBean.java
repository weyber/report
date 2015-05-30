package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Book;

@ManagedBean(name="listBean")
@SessionScoped
public class ListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{bookService}")
    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public Double getSum() {
        Double sum = 0.0;

        for (Book book : bookService.getBooks()) {
            sum += book.getValue();
        }
        return sum;
    }
}
