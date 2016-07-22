
package modelo;

public class BeanMaterial 
{
    // Declaracion de variables.
    private String id_mate;
    private int tipo;
    private String nombre;
    private String descripcion;
    private String fecha;
    private String modelo;
    private String estado;
    private int unidades;
    private String comentario;

    //Declaracion de Get and Set de cada uno de las variables.

    public String getId_mate() {
        return id_mate;
    }

    public void setId_mate(String id_mate) {
        this.id_mate = id_mate;
    }
   
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    // Contructor con todas las variables. 

    public BeanMaterial(String id_mate, int tipo, String nombre, String descripcion, 
            String fecha, String modelo, String estado, int unidades, String comentario) 
    {
        super();
        this.id_mate = id_mate;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.modelo = modelo;
        this.estado = estado;
        this.unidades = unidades;
        this.comentario = comentario;
    }

    public BeanMaterial(String id_mate) {
        this.id_mate = id_mate;
    }
}
