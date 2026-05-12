package cliente;

import java.util.GregorianCalendar;

public interface ICliente extends IPersona{
    public int getNumReservas();
    public GregorianCalendar getFechaInicio();
    public void incrementaNumReservas();
    
}
