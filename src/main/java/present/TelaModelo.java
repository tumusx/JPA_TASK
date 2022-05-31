package present;

import dao.MarcaDAO;
import dao.ModeloDAO;
import entity.Modelo;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;

public class TelaModelo {

    @SuppressWarnings("resource")
    public static Scanner menuModelo(Scanner console, EntityManager em) throws InterruptedException, ParseException {
        int opcao = 0;
        do {
            System.out.println("\n\n");
            System.out.println("    ###   Tela: Modelo     ###");
            System.out.println("    =========================");
            System.out.println("    |     1 - Cadastrar     |");
            System.out.println("    |     2 - Listar        |");
            System.out.println("    |     3 - Alterar       |");
            System.out.println("    |     4 - Excluir       |");
            System.out.println("    |     0 - Retornar      |");
            System.out.println("    =========================");
            System.out.print("    Opção -> ");
            opcao = console.nextInt();
            console.nextLine();

            switch (opcao) {
                case 1: console = cadastrar(console, em);
                    break;
                case 2:	console = listar(console, em);
                    break;
                case 3: console = alterar(console, em);
                    break;
                case 4: console = excluir(console, em);
                    break;
                case 0:	console = TelaPrincipal.menuPrincipal(console, em);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    TimeUnit.SECONDS.sleep(1);
            }
        } while (opcao != 0);
        return console;
    }

    private static Scanner cadastrar(Scanner console, EntityManager em) throws ParseException {

        Modelo m = new Modelo();

        System.out.println("\n\n");
        System.out.println("    ###   Modelo-Cadastrar ###");
        System.out.println("    =========================");

        System.out.print("    |     Id Marca: ");
        m.setMarca(new MarcaDAO(em).findMarca(console.nextInt()));
        console.nextLine();

        System.out.print("    |     Descrição: ");
        m.setDescricao(console.nextLine());

        System.out.print("    |     Potencia: ");
        m.setPotencia(console.nextInt());
        console.nextLine();

        System.out.println("    =========================");

        new ModeloDAO(em).cadastrarModelo(m);

        console.nextLine();
        return console;
    }

    private static Scanner listar(Scanner console, EntityManager em) {

        List<Modelo> modelos = new ModeloDAO(em).listarModelo();

        System.out.println("\n\n");
        System.out.println("    ###   Modelo-Listar    ###");
        System.out.println("    =========================");
        System.out.println("    |     Id\t\tDescrição\t\tPotencia\t\tMarca");
        for(Modelo c : modelos) {
            System.out.println("    |     " + c.getId()
                    + "\t\t" 		+ c.getDescricao()
                    + "\t\t" 		+ c.getPotencia()
                    + "\t\t" 		+ c.getMarca().toString()
            );
        }
        System.out.println("    =========================");
        console.nextLine();
        return console;
    }

    private static Scanner alterar(Scanner console, EntityManager em) throws ParseException {

        Modelo m = new Modelo();

        System.out.println("\n\n");
        System.out.println("    ###   Modelo-Alterar   ###");
        System.out.println("    =========================");
        System.out.print("    |     Id: ");
        m.setId(console.nextInt());
        console.nextLine();

        System.out.print("    |     Id Marca: ");
        m.setMarca(new MarcaDAO(em).findMarca(console.nextInt()));
        console.nextLine();

        System.out.print("    |     Descrição: ");
        m.setDescricao(console.nextLine());

        System.out.print("    |     Potencia: ");
        m.setPotencia(console.nextInt());
        console.nextLine();

        System.out.println("    =========================");
        new ModeloDAO(em).update(m);

        console.nextLine();
        return console;
    }

    private static Scanner excluir(Scanner console, EntityManager em) throws ParseException {

        System.out.println("\n\n");
        System.out.println("    ###   Modelo-Excluir   ###");
        System.out.println("    =========================");
        System.out.print("    |     Digite o Id: ");
        int id = console.nextInt();
        console.nextLine();
        System.out.println("    =========================");

        new ModeloDAO(em).deletarModelo(id);

        console.nextLine();
        return console;
    }
}