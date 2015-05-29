package bean;

import java.io.IOException;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
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

    @ManagedProperty(value= "#{listBean}")
    private ListBean listBean;

    public void setListBean(ListBean listBean) {
        this.listBean = listBean;
    }

    /** report */
    public void generateReport() throws JRException,IOException {

        JRBeanCollectionDataSource collection = 
                new JRBeanCollectionDataSource(listBean.getBooks());

        String report = 
                FacesContext.getCurrentInstance().getExternalContext()
                .getRealPath("/resources/relatorios/Report.jasper");

        jasperPrint = 
                JasperFillManager.fillReport(report,
                        new HashMap<String, Object>(), collection);

        /** Http */
        HttpServletResponse httpServletResponse = 
                (HttpServletResponse) FacesContext
                .getCurrentInstance().getExternalContext().getResponse();

        httpServletResponse.addHeader("Content-disposition",
                "attachment; filename=Book-Report .pdf");

        javax.servlet.ServletOutputStream servletStream = 
                httpServletResponse.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, servletStream);
        FacesContext.getCurrentInstance().responseComplete();
    }
}


