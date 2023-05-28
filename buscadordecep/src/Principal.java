import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args)  {
        ConsultaCep consultaCep = new ConsultaCep();
        Scanner leitura = new Scanner(System.in);
        String cep = "";

        while (!cep.equalsIgnoreCase("sair")) {
            System.out.println("Digite um número de CEP(somente números) para consulta \nDigite SAIR para parar");
            cep = leitura.nextLine();

            if (cep.equalsIgnoreCase("sair")) {
                break;
            } else {
                try {
                    Endereco novoEndereco = consultaCep.buscaEndereco(cep);
                    System.out.println(novoEndereco);
                    GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
                    geradorDeArquivo.salvaJson(novoEndereco);

                } catch (RuntimeException | IOException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Finalizando a aplicação");
                }
            }
        }
    }
}
