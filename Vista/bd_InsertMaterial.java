/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.Material;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.BeanMaterial;

/**
 *
 * @author Jorge
 */
public class bd_InsertMaterial extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public bd_InsertMaterial(){
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //1.- Recuperar datos del Formulario.
            String codigo = request.getParameter("codmate");
            int tipo = Integer.parseInt(request.getParameter("idtipo"));
            String nombre = request.getParameter("nommate");
            String descripcion = request.getParameter("desmate");
            String fecha = request.getParameter("fecmate");
            String modelo = request.getParameter("modmate");
            String estado = request.getParameter("estmate");
            int unidades = Integer.parseInt(request.getParameter("unimate"));
            String comentario = request.getParameter("commate");
            
                BeanMaterial bmaterial = new BeanMaterial(codigo, tipo, nombre, descripcion, fecha, modelo, estado, unidades, comentario);
                boolean sw = Material.agregarMaterial(bmaterial);
                if(sw)
                {
                    request.getRequestDispatcher("ListadoMaterial.jsp").forward(request, response);
                }
                else
                {
                    PrintWriter out = response.getWriter();
                    //out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
	            response.sendRedirect("Error/ErrorSQL.jsp");
                }
    }
}
