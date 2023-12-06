package cl.litscl.subirimagen.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cl.litscl.subirimagen.util.ArchivoUtil;

/**
 * Servlet implementation class ImagenControlador
 */

@MultipartConfig //La anotaci�n "MultipartConfig", prepara el Servlet para poder recepcionar archivos.
@WebServlet("/ImagenControlador")
public class ImagenControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImagenControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part archivo = request.getPart("imagen");
		
	    File rutaArchivoDestino = new File("C:\\Users\\Daniel\\Documents\\workEE\\SubirImagen\\WebContent\\uploads\\");
	    String[] formatosSoportados = {".ico", ".png", ".jpg", ".jpeg"};
		
		if (archivo.getSubmittedFileName().equals("") == true) {
			request.setAttribute("mensaje", "No se ha enviado ning�n archivo");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if (new ArchivoUtil().validarFormato(archivo.getSubmittedFileName(), formatosSoportados)) {
			String nombreImagen = new ArchivoUtil().guardarImagen(archivo, rutaArchivoDestino);
			request.setAttribute("mensaje", "Imagen subida correctamente con el nombre: " + nombreImagen);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			request.setAttribute("mensaje", "Formato de imagen no valido");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
