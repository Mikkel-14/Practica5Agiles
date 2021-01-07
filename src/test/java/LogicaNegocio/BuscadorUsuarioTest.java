package LogicaNegocio;

import LogicaNegocio.BuscadorUsuario;
import LogicaNegocio.IConectorBD;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
public class BuscadorUsuarioTest {
    @Test
    public void given_userid_when_validarId_then_ok(){
        BuscadorUsuario b = new BuscadorUsuario();
        assertTrue(b.validarId("Mikkel#1111"));
    }

    @Test
    public void given_invalid_userid_when_validarId_then_ok(){
        BuscadorUsuario b = new BuscadorUsuario();
        assertFalse(b.validarId("@312Santiago"));
    }


}
