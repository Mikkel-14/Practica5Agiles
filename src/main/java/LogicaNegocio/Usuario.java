
package LogicaNegocio;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Usuario {
    private String UserId;
    private String contrasenia;
    private ArrayList<Usuario> ListaDeAmigos;
    private ArrayList<Solicitud> ListaDeSolicitudes;
    private ManejadorSolicitud manejadorSolicitud;

    public Usuario(String userId, String contrasenia, ArrayList<Usuario> listaDeAmigos, ArrayList<Solicitud> listaDeSolicitudes) {
        this.UserId = userId;
        this.contrasenia = contrasenia;
        this.ListaDeAmigos = listaDeAmigos;
        this.ListaDeSolicitudes = listaDeSolicitudes;
    }
    public Usuario(String userId, String contrasenia){
        this.UserId = userId;
        this.contrasenia = contrasenia;
        this.ListaDeAmigos = new ArrayList<Usuario>();
        this.ListaDeSolicitudes = new ArrayList<Solicitud>();
    }
    public void setManejadorSolicitud(ManejadorSolicitud m){
        this.manejadorSolicitud = m;
    }

    public String getUserId() {
        return UserId;
    }

    public ManejadorSolicitud.respuesta actualizar(){
        String remitente = this.manejadorSolicitud.getSolicitud().getEmisorSolicitud();
        for (Solicitud s: this.ListaDeSolicitudes){
            if (s.getEmisorSolicitud().equals(remitente)){
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return ManejadorSolicitud.respuesta.reenvio;
            }
        }
        for (Usuario u: this.ListaDeAmigos){
            if(u.getUserId().equals(remitente)){
                return ManejadorSolicitud.respuesta.amigos;
            }
        }
        this.ListaDeSolicitudes.add(this.manejadorSolicitud.getSolicitud());
        return ManejadorSolicitud.respuesta.ok;
    }
}
