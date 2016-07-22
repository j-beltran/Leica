package controlador;

import java.sql.*;
import java.util.LinkedList;
import javax.swing.text.html.HTMLDocument;
import modelo.BeanMaterial;

public class Material 
{
    //Metodo para agregar Materual
    public static boolean agregarMaterial(BeanMaterial material)
    {
        boolean agregar = false;
        try
        {
            // Realizar la conexion con la BD y ejecutar la sentencia de insercion de datos.
            Connection con = Conexion.CrearConexion();
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO LEICA.MATERIALES(`ID_MAT`, `TIPO_MATERIAL_ID_TIPO_MATERIAL`,"+
                         "`NOM_MAT`, `DESC_MAT`, `FECHA_REC_MAT`, `MODELO_MAT`, `ESTADO_MAT`, "+
                         "`UNIDADES`, `COMENTARIO_MAT`) values('"+ material.getId_mate()+ "',"+material.getTipo()+","+
                         "'"+material.getNombre()+"','"+material.getDescripcion()+"',"+
                         "'"+material.getFecha()+"','"+material.getModelo()+"','"+material.getEstado()+"',"+
                         ""+material.getUnidades()+",'"+material.getComentario()+"')");
            
            agregar = true;
            st.close();
        }
        catch(SQLException e)
        {
            agregar = false;
            System.out.println("Excepcion de SQL: "+  e);
        }
        return agregar;
    }
    //Material para listar materiales.
    public static LinkedList<BeanMaterial> getMateriales()
    {
                 
        LinkedList<BeanMaterial> listaMaterial = new LinkedList<BeanMaterial>();
        try
        {
            // Realizar la conexion con la BD y ejecutar la sentencia de insercion de datos.
            Connection con = Conexion.CrearConexion();
            String sql = "SELECT * FROM LEICA.MATERIALES";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                BeanMaterial lmaterial = new BeanMaterial(sql, 0, sql, sql, sql, sql, sql, 0, sql);
                lmaterial.setId_mate(rs.getString("id_mat"));
                lmaterial.setTipo(rs.getInt("tipo_material_id_tipo_material"));
                lmaterial.setNombre(rs.getString("nom_mat"));
                lmaterial.setDescripcion(rs.getString("desc_mat"));
                lmaterial.setFecha(rs.getString("fecha_rec_mat"));
                lmaterial.setModelo(rs.getString("modelo_mat"));
                lmaterial.setEstado(rs.getString("estado_mat"));
                lmaterial.setUnidades(rs.getInt("unidades"));
                lmaterial.setComentario(rs.getString("comentario_mat"));
                listaMaterial.add(lmaterial);
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println("Excepcion de SQL: " + e);       
        }
        return listaMaterial;
    }
    
    //Metodo para eliminar materiales.
    public static boolean eliminarMaterial(BeanMaterial ematerial)
    {
        boolean elminar = false;
        try
        {
            Connection conn = Conexion.CrearConexion();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM LEICA.MATERIALES WHERE ID_MAT = '"+ ematerial.getId_mate() +"' ");
            
            elminar = true;
            st.close();
        }
        catch(SQLException e)
        {
            elminar = false;
            System.out.println("Excepcion de SQL:" + e );
        }
        return elminar;
    }
}