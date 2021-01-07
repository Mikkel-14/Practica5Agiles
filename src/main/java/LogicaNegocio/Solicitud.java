package LogicaNegocio;

public class Solicitud {
    private String emisorSolicitud;
    private boolean estado;

    public Solicitud(String emisorSolicitud ,boolean estado){
        this.emisorSolicitud=emisorSolicitud;
        this.estado=estado;
    }

    public String getEmisorSolicitud() {
        return emisorSolicitud;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
