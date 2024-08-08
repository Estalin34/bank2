package com.example.banco.Controladores;

import com.example.banco.Entidad.Formulario;
import com.example.banco.Servicios.FormularioServicio;
import com.example.banco.Servicios.PdfServicio;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class PdfControlador {

//    @Autowired
//    private FormularioServicio formularioServicio;
//
//    @Autowired
//    private PdfServicio pdfServicio;
//
//    @GetMapping("/generar-pdf")
//    public ResponseEntity<Resource> generarPdf(@RequestParam Long idFormulario) {
//        try {
//            Formulario formulario = formularioServicio.obtenerPorId(idFormulario); // Obtén el formulario por ID
//            if (formulario == null) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 si no se encuentra el formulario
//            }
//            byte[] pdfBytes = pdfServicio.generarPdf(formulario);
//            ByteArrayResource resource = new ByteArrayResource(pdfBytes);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=formulario_" + idFormulario + ".pdf");
//            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
//        } catch (IOException | DocumentException e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
