package py.gov.asuncion.demopf.reportes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author Daniel Pardo @ www.programacionj2ee.com
 */
public class GenerarPDF implements Controller {

    JasperReport jasperReport;
    JasperPrint jasperPrint;
    private DriverManagerDataSource ds;
    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JRException, SQLException {

        logger.info("Generando Reporte.");

        jasperReport = JasperCompileManager.compileReport("pjcomspringjasper/web/reporte.jrxml");

        Map parametros = new HashMap();

        parametros.put("usuario", "Usuario");
        parametros.put("contrasena", "Contraseña");

        /*
        try {
        jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, ds.getConnection());
        } catch (SQLException ex) {
        logger.error("Error generando Reporte.");
        ex.printStackTrace();
        }


        JasperExportManager.exportReportToPdfFile(jasperPrint, "reporte.pdf");
         */

        //
        byte[] reporte = null;

        reporte = JasperRunManager.runReportToPdf(jasperReport, parametros, ds.getConnection());

        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "inline; filename=informeDemo.pdf");
        response.setHeader("Cache-Control", "max-age=30");
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setContentLength(reporte.length);

        ServletOutputStream out = response.getOutputStream();
        out.write(reporte, 0, reporte.length);
        out.flush();
        out.close();
        //

        return new ModelAndView("index");
    }

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.ds = dataSource;
    }
}
