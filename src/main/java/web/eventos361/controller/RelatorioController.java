package web.eventos361.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import web.eventos361.model.Evento;
import web.eventos361.repository.EventoRepository;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping("/eventos-pdf")
    public ResponseEntity<byte[]> gerarRelatorioEventos() {
        try {
            // Buscar todos os eventos com participantes
            List<Evento> eventos = eventoRepository.findAllWithParticipantes();

            // Compilar o relatório principal
            InputStream reportStream = getClass().getResourceAsStream("/relatorios/relatorio_eventos.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            // Compilar o sub-relatório
            InputStream subReportStream = getClass().getResourceAsStream("/relatorios/sub_relatorio_participantes.jrxml");
            JasperReport subJasperReport = JasperCompileManager.compileReport(subReportStream);

            // Parâmetros do relatório
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("SUB_REPORT", subJasperReport);
            parameters.put("DATA_GERACAO", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            parameters.put("TITULO", "Relatório de Eventos e Participantes");

            // Criar DataSource
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(eventos);

            // Preencher o relatório
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Exportar para PDF
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            // Configurar headers da resposta
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", "relatorio_eventos.pdf");

            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
