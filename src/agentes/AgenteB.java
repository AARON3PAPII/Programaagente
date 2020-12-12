package agentes;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
/**
 *
 * @author Aaron Ramos
 */
public class AgenteB extends Agent
{
    protected void setup()
    {
        this.addBehaviour(new Behaviour()
        {
            public void action()
            {
              System.out.println("Hola Mundo de Agentes, yo soy el agente -->  " +
                getAID().getName());
            }
            public boolean done()
            {
                return true;
            }
        });
    }
}
