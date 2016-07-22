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

public class bd_EliminarMaterial extends HttpServlet {
private static final long serialVersionUID = 1L;
    
    public bd_EliminarMaterial()
    {
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //PrintWriter out = response.getWriter();
        
        //Obtener el id para eliminar un material
        String codigo1 = request.getParameter("id");
        
        BeanMaterial ematerial = new BeanMaterial(codigo1);
        boolean sw = Material.eliminarMaterial(ematerial);
        
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
