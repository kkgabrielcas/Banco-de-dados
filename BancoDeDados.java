import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class BancoDeDados {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in); //Scanner para NUMEROS

        Scanner cad_usuario = new Scanner(System.in); //Scanner para cadastrar o usuário
        Scanner cad_senha = new Scanner(System.in); //Scanner para cadastrar a senha

        Scanner log_usuario = new Scanner(System.in); //Scanner para checkar o login do usuário
        Scanner log_senha = new Scanner(System.in); //Scanner para checkar o login da senha
        
        while (true) {
        
        //Perguntas
        System.out.println("Escolha uma opção: ");
        System.out.println("[1] Login");
        System.out.println("[2] Registrar-se");
        System.out.println("[3] Sair");
        byte escolha = input.nextByte();

        //Registro && Login
        switch(escolha) {
  
            //Login
            case 1:
            System.out.println("|LOGIN| Digite o usuário: ");
            String l_usuario = log_usuario.nextLine();

            System.out.println("|LOGIN| Digite a senha: ");
            String l_senha = log_senha.nextLine();

            String caminhoDADOS = "C:/Users/NOME100%REAL/Downloads/dados.txt"; //Insira o diretório onde o banco de dados se localiza. EX: "C:/Users/Bob/Downloads/dados.txt"
                                                                                                    //Abaixo se localiza o local de criação do mesmo    
            try (BufferedReader br = new BufferedReader(new FileReader(caminhoDADOS))) {
                String linha;
            
                while ((linha = br.readLine()) != null) { //Lê cada linha do arquivo
                    if (linha.contains(l_usuario) && linha.contains(l_senha)) { //Verifica se a linha contém as informações de login fornecidas
                        System.out.println("Bem vindo de volta "  + l_usuario + " :)");
                        System.exit(0);
                    }
                }
            
                //Mensagem de erro ao buscar o LOGIN
                System.out.println("---404---");
                System.out.println("Usuário ou senha incorretos!");
                System.out.println("---------");
                System.exit(0);
            } 

            //Mensagem de erro por não achar o arquivo
            catch (IOException e) {
                System.out.println("---ERRO---");
                System.out.println("Ocorreu um erro ao tentar ler o arquivo: " + e.getMessage());
                System.out.println("Certifique-se de colocar o mesmo diretório nas linhas 39 e 77");
                System.out.println("----------");
                System.exit(0);
            }
            //Registro
            case 2:
            System.out.println("|REGISTRO| Digite o usuário: ");
            String usuario = cad_usuario.nextLine();
            
            System.out.println("|REGISTRO| Digite a senha: ");
            String senha = cad_senha.nextLine();

            //Criando o Banco de Dados
            final String ARQUIVO = "dados.txt";
            try {
                File DADOS = new File("C:/Users/NOME100%REAL/" + ARQUIVO); //Insira o diretório onde o banco de dados será gerado. EX: "C:/Users/Bob/Downloads/"
                
                //Salvando as informações
                FileWriter salvar = new FileWriter(DADOS, true);
                salvar.write(usuario + " " + senha + "\n");
                salvar.close();
                    
                //Mensagem de confirmação
                System.out.println("Cadastro feito com sucesso!");
                System.out.println("------");
                System.out.println("Usuário: " + usuario);
                System.out.println("Senha: " + senha);
                System.out.println("------");
                System.out.println("--Tente fazer o login.--");
                break;
            }
            
                //Mensagem de erro
                catch (IOException e) {
                    System.out.println("---ERRO---");
                    System.out.println("Ocorreu um erro ao tentar criar o arquivo: " + e.getMessage());
                    System.out.println("Tente colocar outro diretório, EX: ''C:/Users/(Nome do Usuário)/Downloads/'' ");
                    System.out.println("----------");
                    System.exit(0);
                }

            //Saindo    
            case 3:
            input.close();
            cad_usuario.close();
            cad_senha.close();
            log_usuario.close();
            log_senha.close();
            System.out.println("Saindo...");
            System.exit(0);

            //Opção Inválida
            default:
            System.out.println("Opção inválida! ");
            
            }
        } 
    }
}
