package present;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class MainFabrica {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fabrica");
        EntityManager em = emf.createEntityManager();
        try {
            console = TelaPrincipal.menuPrincipal(console, em);
        }
        catch(Exception e)	{
            System.out.println("Erro: " + e);
        }
        finally {
            em.close();
            emf.close();
        }


    }
}
