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
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia");
        solicitudes.add(new Solicitud(mike, true));
        Usuario target = new Usuario("Cesar#5555", "Iscariote",amigos,solicitudes);
        ManejadorSolicitud p = new ManejadorSolicitud();
        mike.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        assertEquals(ManejadorSolicitud.respuesta.reenvio, p.generarSolicitud(mike, target));
    }
    @Test
    public void given_friendReq_when_accept_then_añadido(){
        ArrayList<Usuario> amigos = new ArrayList<>();
        amigos.add(new Usuario("Stryder#2693", "procesoUnificado"));
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia", amigos, new ArrayList<Solicitud>());
        Solicitud req = new Solicitud(mike,true);
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        solicitudes.add(req);
        Usuario target = new Usuario("Cesar#5555", "Iscariote", new ArrayList<Usuario>(), solicitudes);
        ManejadorSolicitud p = new ManejadorSolicitud();
        mike.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        assertEquals(ManejadorSolicitud.resultadoSolicitud.aceptada,p.procesarSolicitud(req,target,true));
    }

    @Test
    public void given_friendRequest_when_denied_then_rechazado(){
        ArrayList<Usuario> amigos = new ArrayList<>();
        amigos.add(new Usuario("Stryder#2693", "procesoUnificado"));
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia", amigos, new ArrayList<Solicitud>());
        Solicitud req = new Solicitud(mike,true);
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        solicitudes.add(req);
        Usuario target = new Usuario("Cesar#5555", "Iscariote", new ArrayList<Usuario>(), solicitudes);
        ManejadorSolicitud p = new ManejadorSolicitud();
        mike.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        assertEquals(ManejadorSolicitud.resultadoSolicitud.rechazada,p.procesarSolicitud(req,target,false));
    }
}