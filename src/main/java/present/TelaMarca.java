package present;

import dao.MarcaDAO;
import entity.Marca;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;

public class TelaMarca {

    @SuppressWarnings("resource")
    public static Scanner menuMarca(Scanner console, EntityManager em) throws InterruptedException, ParseException {
        int opcao = 0;
        do {
            System.out.println("\n\n");
            System.out.println("    ###   Tela: Marca     ###");
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

        Marca m = new Marca();

        System.out.println("\n\n");
        System.out.println("    ###   Marca-Cadastrar ###");
        System.out.println("    =========================");
        System.out.print("    |     Nome: ");
        m.setNome(console.nextLine());

        System.out.println("    =========================");

        new MarcaDAO(em).cadastrarMarca(m);

        console.nextLine();
        return console;
    }

    private static Scanner listar(Scanner console, EntityManager em) {

        List<Marca> marcas = new MarcaDAO(em).listarMarca();

        System.out.println("\n\n");
        System.out.println("    ###   Marca-Listar    ###");
        System.out.println("    =========================");
        System.out.println("    |     Id\t\tNome");
        for(Marca c : marcas) {
            System.out.println("    |     " + c.getId()
                    + "\t\t" 		+ c.getNome() );
        }
        System.out.println("    =========================");
        console.nextLine();
        return console;
    }

    private static Scanner alterar(Scanner console, EntityManager em) throws ParseException {

        Marca c = new Marca();

        System.out.println("\n\n");
        System.out.println("    ###   Marca-Alterar   ###");
        System.out.println("    =========================");
        System.out.print("    |     Id: ");
        c.setId(console.nextInt());
        console.nextLine();

        System.out.print("    |     Nome: ");
        c.setNome(console.nextLine());

        System.out.println("    =========================");
        new MarcaDAO(em).update(c);

        console.nextLine();
        return console;
    }

    private static Scanner excluir(Scanner console, EntityManager em) throws ParseException {

        System.out.println("\n\n");
        System.out.println("    ###   Marca-Excluir   ###");
        System.out.println("    =========================");
        System.out.print("    |     Digite o Id: ");
        int id = console.nextInt();
        console.nextLine();
        System.out.println("    =========================");

        new MarcaDAO(em).deletarMarca(id);

        console.nextLine();
        return console;
    }
}