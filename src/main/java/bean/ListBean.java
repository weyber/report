package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Book;
import dao.Dao;
import dao.IDao;

@ManagedBean(name="listBean")
@SessionScoped
public class ListBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Book> books;

    private IDao dao = new Dao();

    @PostConstruct
    public void init() {
        books = dao.select();
    }

    public Double getSum() {
       Double sum = 0.0;
       
       for (Book book : books) {
           sum += book.getValue();
       }
       return sum;
    }
    
    public List<Book> getBooks() {
        return books;
    }
}
