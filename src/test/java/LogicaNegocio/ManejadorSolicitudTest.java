package LogicaNegocio;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ManejadorSolicitudTest {
    @Test
    public void given_newFriend_when_generarSolicitud_then_ok(){
        ArrayList<Usuario> amigos = new ArrayList<>();
        amigos.add(new Usuario("Stryder#2693", "procesoUnificado"));
        Usuario target = new Usuario("Cesar#5555", "Iscariote");
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia", amigos, new ArrayList<Solicitud>());
        ManejadorSolicitud p = new ManejadorSolicitud();
        mike.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        assertEquals(ManejadorSolicitud.respuesta.ok,p.generarSolicitud(mike,target));
    }
    @Test
    public void given_oldFriend_when_generarSolicitud_then_amigos(){
        ArrayList<Usuario> amigos = new ArrayList<>();
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia");
        amigos.add(mike);
        Usuario target = new Usuario("Stryder#2693", "procesoUnificado", amigos, new ArrayList<Solicitud>());
        ManejadorSolicitud p = new ManejadorSolicitud();
        mike.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        assertEquals(ManejadorSolicitud.respuesta.amigos,p.generarSolicitud(mike,target));
    }


    @Test(timeout = 300)
    public void given_newFriend_when_generarSolicitud_then_reenvio() {
        ArrayList<Usuario> amigos = new ArrayList<>();
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        solicitudes.add(new Solicitud("Mikkel14#1111", true));
        amigos.add(new Usuario("Stryder#2693", "procesoUnificado"));
        Usuario target = new Usuario("Cesar#5555", "Iscariote",amigos,solicitudes);
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia");
        ManejadorSolicitud p = new ManejadorSolicitud();
        mike.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        assertEquals(ManejadorSolicitud.respuesta.reenvio, p.generarSolicitud(mike, target));
    }

}