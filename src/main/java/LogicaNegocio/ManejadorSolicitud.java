package LogicaNegocio;

public class ManejadorSolicitud {
    private Solicitud solicitud;
    enum respuesta {ok, amigos, reenvio, fallo};

    public respuesta generarSolicitud(Usuario origen,Usuario target){
        this.solicitud = new Solicitud(origen.getUserId(), false);
        return this.notify(target);
    }
    public respuesta notify(Usuario target){
        return target.actualizar();
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }
}
