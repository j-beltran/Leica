<%-- 
    Document   : ListadoMaterial
    Created on : 21-07-2016, 10:41:20
    Author     : Jorge
--%>
<%@page import="controlador.Material"%>
<%@page import="modelo.BeanMaterial"%>
<%@page import="java.sql.*,controlador.Conexion"%>
<%@page import ="java.util.LinkedList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br />
        <br />
        <br />
        <table border="1" align="center">
            <tr>
                <th colspan="11" bgcolor="yellow">Listado de Materiales</th>
            </tr>
            <tr>
                <td>Codigo</td>
                <td>Tipo Material</td>
                <td>Nombre</td>
                <td>Descripción</td>
                <td>Fecha Recepción</td>
                <td>Modelo</td>
                <td>Estado</td>
                <td>Unidades</td>
                <td>Comentario</td>
                <td>Operaciones</td>
            </tr>
            <%
                LinkedList<BeanMaterial> lista = Material.getMateriales();
                for (int i=0;i<lista.size();i++)
                {
                    out.println("<tr>");
                    out.println("<td>"+ lista.get(i).getId_mate() +"</td>");
                    out.println("<td>"+ lista.get(i).getTipo() +"</td>");
                    out.println("<td>"+ lista.get(i).getNombre() +"</td>");
                    out.println("<td>"+ lista.get(i).getDescripcion() +"</td>");
                    out.println("<td>"+ lista.get(i).getFecha() +"</td>");
                    out.println("<td>"+ lista.get(i).getModelo() +"</td>");
                    out.println("<td>"+ lista.get(i).getEstado() +"</td>");
                    out.println("<td>"+ lista.get(i).getUnidades() +"</td>");
                    out.println("<td>"+ lista.get(i).getComentario() +"</td>");
                    out.println("<td>"
                            + "<a href=bd_EliminarMaterial.do?id="+ lista.get(i).getId_mate() +"><img src=img/desactivar.png></a>"
                            + "<a href=bd_ModificarMaterial.do?id="+ lista.get(i).getId_mate() +"><img src=img/modificar.png></a>"
                            + "</td>");
                    out.println("</tr>");
                }
            %>    
        </table>
    </body>
</html>
