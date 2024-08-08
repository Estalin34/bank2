package com.example.banco.Servicios;

import com.example.banco.Entidad.Formulario;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfServicio {

    public byte[] generarPdf(Formulario formulario) throws DocumentException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Agrega el contenido al documento PDF
        document.add(new Paragraph("Formulario de Registro"));
        document.add(new Paragraph("Nombre: " + formulario.getNombre()));
        document.add(new Paragraph("Apellido: " + formulario.getApellido()));
        document.add(new Paragraph("Cédula: " + formulario.getCedula()));
        document.add(new Paragraph("Número de Cuenta: " + formulario.getNumeroCuenta()));
        document.add(new Paragraph("Correo Electrónico: " + formulario.getCorreoElectronico()));

        document.close();
        return outputStream.toByteArray();
    }
}
