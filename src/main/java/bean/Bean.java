package bean;

import java.io.IOException;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name="bean")
@RequestScoped
public class Bean {

    private JasperPrint jasperPrint;

    private  String report;

    private JRBeanCollectionDataSource collection;

    private HttpServletResponse httpServletResponse;

    private javax.servlet.ServletOutputStream servletStream;

    private ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

    @ManagedProperty(value= "#{bookService}")
    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    /** report */
    public void generateReport() throws JRException,IOException {

        collection = new JRBeanCollectionDataSource(bookService.getBooks());

        report = context.getRealPath("/resources/relatorios/Report.jasper");

        jasperPrint = JasperFillManager.fillReport(report,
                new HashMap<String, Object>(), collection);

        /* Http */
        httpServletResponse = (HttpServletResponse) context.getResponse();

        httpServletResponse.addHeader("Content-disposition",
                "attachment; filename=Book-Report .pdf");

        servletStream = httpServletResponse.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, servletStream);
        FacesContext.getCurrentInstance().responseComplete();
    }
}


