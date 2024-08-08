package com.example.banco.Controladores;

import com.example.banco.Entidad.Formulario;
import com.example.banco.Servicios.FormularioServicio;
import com.example.banco.Servicios.PdfServicio;
import com.itextpdf.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;

@Controller
public class FormularioControlador {

    @Autowired
    private FormularioServicio formularioServicio;

    @Autowired
    private PdfServicio pdfServicio;

    @GetMapping("/formularios")
    public String mostrarFormulario(Model model) {
        model.addAttribute("formulario", new Formulario());
        return "formulario";
    }

    @PostMapping("/formularios")
    public String procesarFormulario(@ModelAttribute Formulario formulario, Model model) {
        formularioServicio.guardar(formulario); // Guarda el formulario en la base de datos
        model.addAttribute("mensaje", "Formulario enviado exitosamente!");
        return "redirect:/confirmacion"; // Redirige a la vista de confirmación
    }

    @GetMapping("/confirmacion")
    public String mostrarConfirmacion() {
        return "confirmacion"; // Vista de confirmación
    }

    @GetMapping("/generar-pdf")
    public void generarPdf(HttpServletResponse response) throws IOException, DocumentException {
        Formulario formulario = formularioServicio.obtenerUltimoFormulario(); // Obtén el formulario más reciente o el necesario
        byte[] pdfBytes = pdfServicio.generarPdf(formulario);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=formulario.pdf");
        response.getOutputStream().write(pdfBytes);
    }
}
