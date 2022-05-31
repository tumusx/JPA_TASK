package present;

import dao.AutomovelDAO;
import dao.ModeloDAO;
import entity.Automovel;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;

public class TelaAutomovel {

    @SuppressWarnings("resource")
    public static Scanner menuAutomovel(Scanner console, EntityManager em) throws InterruptedException, ParseException {
        int opcao = 0;
        do {
            System.out.println("\n\n");
            System.out.println("    ###   Tela: Automovel     ###");
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

        Automovel a = new Automovel();

        System.out.println("\n\n");
        System.out.println("    ###   Automovel-Cadastrar ###");
        System.out.println("    =========================");

        System.out.print("    |     Id Modelo: ");
        a.setModelo(new ModeloDAO(em).findModelo(console.nextInt()));
        console.nextLine();

        System.out.print("    |     Ano Fabricação: ");
        a.setAnoFabricacao(console.nextInt());
        console.nextLine();

        System.out.print("    |     Ano Modelo: ");
        a.setAnoModelo(console.nextInt());
        console.nextLine();

        System.out.print("    |     Observações: ");
        a.setObservacoes(console.nextLine());

        System.out.print("    |     Preco: ");
        a.setPreco(console.nextFloat());
        console.nextLine();

        System.out.print("    |     Kilometragem: ");
        a.setKilometragem(console.nextInt());
        console.nextLine();

        System.out.println("    =========================");

        new AutomovelDAO(em).cadastrarAutomovel(a);

        console.nextLine();
        return console;
    }

    private static Scanner listar(Scanner console, EntityManager em) {

        List<Automovel> Automovels = new AutomovelDAO(em).listarAutomovel();

        System.out.println("\n\n");
        System.out.println("    ###   Automovel-Listar    ###");
        System.out.println("    =========================");
        System.out.println("    |     Id\t\t Ano Fabricação\t\tAno Modelo\t\tPreco\t\tKilometragem\t\tModelo\t\tObservações");
        for(Automovel a : Automovels) {
            System.out.println("    |     " + a.getId()
                    + "\t\t" 		+ a.getAnoFabricacao()
                    + "\t\t" 		+ a.getAnoModelo()
                    + "\t\t" 		+ a.getPreco()
                    + "\t\t" 		+ a.getKilometragem()
                    + "\t\t" 		+ a.getModelo().toString()
                    + "\t\t" 		+ a.getObservacoes()
            );
        }
        System.out.println("    =========================");
        console.nextLine();
        return console;
    }

    private static Scanner alterar(Scanner console, EntityManager em) throws ParseException {

        Automovel a = new Automovel();

        System.out.println("\n\n");
        System.out.println("    ###   Automovel-Alterar   ###");
        System.out.println("    =========================");
        System.out.print("    |     Id: ");
        a.setId(console.nextInt());
        console.nextLine();

        System.out.print("    |     Id Modelo: ");
        a.setModelo(new ModeloDAO(em).findModelo(console.nextInt()));
        console.nextLine();

        System.out.print("    |     Ano Fabricação: ");
        a.setAnoFabricacao(console.nextInt());
        console.nextLine();

        System.out.print("    |     Ano Modelo: ");
        a.setAnoModelo(console.nextInt());
        console.nextLine();

        System.out.print("    |     Observações: ");
        a.setObservacoes(console.nextLine());

        System.out.print("    |     Preco: ");
        a.setPreco(console.nextFloat());
        console.nextLine();

        System.out.print("    |     Kilometragem: ");
        a.setKilometragem(console.nextInt());
        console.nextLine();

        System.out.println("    =========================");
        new AutomovelDAO(em).update(a);

        console.nextLine();
        return console;
    }

    private static Scanner excluir(Scanner console, EntityManager em) throws ParseException {

        System.out.println("\n\n");
        System.out.println("    ###   Automovel-Excluir   ###");
        System.out.println("    =========================");
        System.out.print("    |     Digite o Id: ");
        int id = console.nextInt();
        console.nextLine();
        System.out.println("    =========================");

        new AutomovelDAO(em).deletarAutomovel(id);

        console.nextLine();
        return console;
    }
}