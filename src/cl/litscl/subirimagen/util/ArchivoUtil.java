package cl.litscl.subirimagen.util;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.Part;

public class ArchivoUtil {
	
	public String guardarImagen(Part archivo, File rutaArchivoDestino) {
		String nombreImagen = "";	
		try {
			Path rutaImagenOrigen = Paths.get(archivo.getSubmittedFileName());
			nombreImagen = new CadenaUtil().cadenaAleatoria(15) + "-" + rutaImagenOrigen.getFileName().toString();
			InputStream imagenSerializada = archivo.getInputStream();
			
			if (imagenSerializada != null) {
				File fi = new File(rutaArchivoDestino, nombreImagen);
				Files.copy(imagenSerializada, fi.toPath());
			}
		} catch (Exception ex) {
			
		}
		return nombreImagen;
	}
	
	public boolean validarFormato(String nombreArchivo, String[] formatosSoportados) {
		for (String formato : formatosSoportados) {
			if (nombreArchivo.toLowerCase().endsWith(formato)) {
				return true;
			}
		}
		return false;
	}
	
}
