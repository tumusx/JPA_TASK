package present;
import java.text.ParseException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;

public class TelaPrincipal {

    public static Scanner menuPrincipal(Scanner console, EntityManager em) throws ParseException, InterruptedException {

        int opcao = 0;
        do {
            System.out.println("\n\n### Sistema de Controle Escolar  ###");
            System.out.println("    =========================");
            System.out.println("    |     1 - Marca         |");
            System.out.println("    |     2 - Modelo        |");
            System.out.println("    |     3 - Automovel     |");
            System.out.println("    |     0 - Sair          |");
            System.out.println("    =========================");
            System.out.print("    Opção -> ");
            opcao = console.nextInt();
            console.nextLine();

            switch (opcao) {
                case 1: return TelaMarca.menuMarca(console, em);
                case 2: return TelaModelo.menuModelo(console, em);
                case 3: return TelaAutomovel.menuAutomovel(console, em);
                case 0: System.out.println("    Aplicação foi encerrada!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    TimeUnit.SECONDS.sleep(1);
            }
        } while(opcao!=0);
        return console;
    }
}