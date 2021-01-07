package LogicaNegocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuscadorUsuario {
    private IConectorBD conexion;
    public BuscadorUsuario(IConectorBD conector){
        this.conexion = conector;
    }
    public BuscadorUsuario(){
        this.conexion= null;
    }
    public  Usuario buscar(String id){
        if (this.validarId(id)){
            Usuario resultado = this.conexion.query(id);
            if (resultado != null){
                return resultado;
            }
            else{
                return null;
            }
        }
        return null;
    }
    public boolean validarId(String id){
        Pattern patron = Pattern.compile("^[A-Za-z0-9]{4,10}#[0-9]{4}");
        Matcher match = patron.matcher(id);
        return match.matches();
    }
}
