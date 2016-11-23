/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.gov.asuncion.demopf.reporte;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author vinsfran
 */
public class Reportes {

    public static void getReporte(String ruta, Map parametros, String exportar) throws ClassNotFoundException, SQLException {
        Connection conexion;
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demopf_db", "postgres", "admin123");

        try {
            File file = new File(ruta);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            JRExporter jrExporter = null;

            if (exportar.equals("vacio")) {
                httpServletResponse.addHeader("Content-Type", "application/pdf");
                httpServletResponse.setContentType("application/pdf");
                jrExporter = new JRPdfExporter();
            } else {
                httpServletResponse.setHeader("Cache-Control", "no-cache");
                httpServletResponse.setHeader("Pragma", "no-cache");
                httpServletResponse.setDateHeader("Expires", 0);
                httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"reporte." + exportar + "\";");
                httpServletResponse.setContentType("application/" + exportar);

                switch (exportar) {
                    case "pdf":
                        jrExporter = new JRPdfExporter();
                        break;
                    case "xlsx":
                        jrExporter = new JRXlsxExporter();
                        break;
                    case "docx":
                        jrExporter = new JRDocxExporter();
                        break;
                    case "pptx":
                        jrExporter = new JRPptxExporter();
                        break;
                    case "csv":
                        jrExporter = new JRCsvExporter();
                        break;
                    case "txt":
                        jrExporter = new JRTextExporter();
                        break;
                    default:
                        break;
                }
            }

            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conexion);

            jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());

            try {
                jrExporter.exportReport();
            } catch (JRException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
