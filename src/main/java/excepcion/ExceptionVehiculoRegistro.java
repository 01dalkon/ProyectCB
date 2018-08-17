package excepcion;

public class ExceptionVehiculoRegistro extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ExceptionVehiculoRegistro(String message) {
		super(message);
	}
}
