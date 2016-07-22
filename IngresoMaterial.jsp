<%-- 
    Document   : IngresoMaterial
    Created on : 16-07-2016, 16:38:25
    Author     : Jorge
--%>

<%@page import="controlador.Material"%>
<%@page import="modelo.BeanMaterial"%>
<%@page import="java.sql.*,controlador.Conexion"%>
<%@page import ="java.util.LinkedList"%>
<%
    ResultSet rs = null;
    
    try
    {
        Connection con = Conexion.CrearConexion();
        String sql = "select * from leica.tipo_material";
        
        Statement st = con.createStatement();
        
        rs = st.executeQuery(sql);
    }
    catch(SQLException e)
    {
        out.println("Excepción de SQL: " + e);
        return;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Materiales</title>
    </head>
    <body>
        <h1>Formulario de Ingreso de Materiales</h1>
        
        <form action="bd_InsertMaterial.do" method="post">
            <table align="center" border="1"> 
                <th colspan="2">
                    Ingreso de Materiales
                </th>
                <tr>
                    <td>Codigo</td>
                    <td><input type="text" name="codmate" cols="40"/></td>
                </tr>
                <tr>
                    <td>Tipo de Material</td>
                    <td>
                        <select name="idtipo" cols="40">
                            <option>SELECCIONE...</option>
                            <% while(rs.next()) {%>
                            <option value="<%= rs.getLong("id_tipo_material") %>">
                                <%= rs.getString("desc_tipo_material") %>
                            </option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nommate" cols="40"/></td>
                </tr>
                <tr>
                    <td>Descripción</td>
                    <td><textarea name="desmate" rows="10" cols="40"></textarea></td>
                </tr>
                <tr>
                    <td>Fecha Recepción</td>
                    <td><input type="date" name="fecmate" cols="40"/></td>
                </tr>
                <tr>
                    <td>Modelo</td>
                    <td><input type="text" name="modmate" cols="40" /></td>
                </tr>
                <tr>
                    <td>Estado</td>
                    <td>
                        Aprobado <input type="radio" name="estmate" value="aprobado" checked="yes"/>
                        Rechazado <input type="radio" name="estmate" value="rechazado" />
                        Pendiente <input type="radio" name="estmate" value="pendiente" />
                    </td>
                </tr>
                <tr>
                    <td>Unidades</td>
                    <td><input type="number" name="unimate" /></td>
                </tr>
                <tr>
                    <td>Comentarios</td>
                    <td><textarea name="commate" rows="10" cols="40"></textarea></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Enviar" />
                        <input type="reset" value="Limpiar" />
                    </td>
                </tr>
            </table>
        </form>
        <br />                
        <br />
        
        
    </body>
</html>
