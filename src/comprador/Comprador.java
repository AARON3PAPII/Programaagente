package comprador;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 *
 * @author Aaron Ramos
 */
public class Comprador extends Agent
{
    private String titulo;
    
    protected void setup()
    {
        System.out.println("Soy el agente comprador: " + getAID().getName());
        
        Object[] args = getArguments();
        
        if(args != null && args.length >0)
        {
            titulo = (String)args[0]; //cast o conversión explícitas
            System.out.println("Vamos a intentar comprar el libro: " + titulo);
            addBehaviour(new TickerBehaviour (this, 10000)
            {
                protected void onTick()
                {
                    System.out.println("Enviando petición a posibles vendedores ... " 
                    + getAID().getName());
                }
            });
        }
        else
        {
            System.out.println("No se ha especificado ningún libro que comprar ...");
            doDelete();
        }
      }
    protected void takeDown()
    {
        System.out.print("Finalizando el agente comprador: " + getAID().getName());
    }
}
