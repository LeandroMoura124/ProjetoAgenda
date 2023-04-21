import java.util.Scanner;

public class Agenda {
    public static  Scanner entrada = new Scanner(System.in);
    public static String agenda[][] = new String [10][3];

    //Programa Princiap
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");



        int opcao, linha;
        String nome;
        

        //Funcao Limpar matriz
        limparMatriz(agenda);


        do
        {   
            //exibindo menu
            exibirMenu();

            System.out.println("Escolha uma opção: ");
            opcao = entrada.nextInt();
            System.out.println();

            //Seleciona o opção escolhida

            switch(opcao){
                //caso seja a opcao de add novo contato
                case 1: 
                    novo(agenda, linhaProximoContato(agenda));
                    break;
                
                //caso a escolha seja edita contato
                case 2: 
                    System.out.println("--------Pesquise o contato que deseja editar--------");
                    System.out.println("Digite o nome.......:");
                    nome = entrada.next();
                    linha = pesquisarContato(agenda, nome);
                    if(linha == -1)
                    {
                        //Informa que nao encontrou o contato
                        System.out.println("Contato não cadastrado \n");
                    }
                    else{
                        //se encontrou, exibe o contato e exibe a opcao de editar
                        exibirContato(agenda, linha);
                        editarContato(agenda, linha);
                    }
                    break;
                //Efetua a pesquisa do contato
                case 3:
                    System.out.println("-----------Pesquise o contato----------");
                    System.out.println("Digite o nome.......");
                    nome = entrada.next();
                    //Retorna a linha da pesquisa
                    linha = pesquisarContato(agenda, nome);
                    if(linha == -1){
                        //Se o contato não existe
                        System.out.println("Contato não cadastrado\n");
                    }
                    else{
                        //se existir o contato, exibir
                        exibirContato(agenda, linha);
                    }
                    break;
                //Lista Contatos
                case 4: 
                    listarAgenda(agenda);
                    break;
                //Apaga contato
                case 5:
                    System.out.println("Excluindo um contato da agenda............:");
                    System.out.println("Digite o nome..,...:");
                    nome = entrada.next();
                    apagarContato(agenda, nome);
                    break;
                
                //Sair do programa
                case 6: 
                    System.out.println("OBRIGADO POR UTILIZAR NOSSA AGENDA (: ");
                    break;

            }
            System.out.println();
        }while(opcao != 6);

    }


    //Metodos do programa 

    public static void limparMatriz(String mm[][]) {
        //Insere vazio em todas as células da matriz
        for(int l = 0; l < 10; l++ ) {
            for(int c = 0; c < 3;  c++){
                mm[l][c] = "";
            }
        }

    }
    public static void exibirMenu(){
        System.out.println("-------------Menu---------------");
        System.out.println("1- Adiciona novo contato");
        System.out.println("2- Editar contato");
        System.out.println("3- Pesquisar contato");
        System.out.println("4- Lista de contatos");
        System.out.println("5- Apagar um contato");
        System.out.println("6- Sair");

    }
    public static void novo(String mm[][], int l){
        //Adicionando novo contato
        System.out.println("------------Preencha o novo contato------------");
        System.out.println("Nome........");
        mm[l][0] = entrada.next();
        System.out.println("Celular..........");
        mm[l][1] = entrada.next();
        System.out.println("E-mail..........");
        mm[l][2] = entrada.next();
    }
    public static int linhaProximoContato(String mm[][]){
        for(int l=0;  l<10; l++){
            if(mm[l][0].equals("")){
                //caso tenha encotrado retorna o numero da linha
                //proxima linha vazia
                return l;
            }
            //-1 representa a matriz estar cheia
            return -1;
        }
        return 0;
    }

    public static int pesquisarContato(String mm[][], String n){
        //Caso encontre o contato, retorna a linha que ele está
        for(int l = 0; l < 10; l++){
            if(mm[l][0].equals(n)){
                return l;
            }
        }
        //nao encontrou nada;
        return -1;
    }
    public static void exibirContato(String mm[][], int linha)
    {
        //Exibe o registro da linha passada pro parâmetro
        System.out.println("Nome.......: " + mm[linha][0]);
        System.out.println("Celular..........: " + mm[linha][1]);
        System.out.println("E-mail...........: " + mm[linha][2]);
    }

    public static void editarContato(String mm[][], int l){
        System.out.println("-------------Edite o contato-----------");
        System.out.println("Nome.............: " + mm[l][0] + "\n");
        System.out.println("Celular...........: ");
        mm[l][1] = entrada.next();
        System.out.println("E-mail................: ");
        mm[l][2] = entrada.next();
    }

    public static void listarAgenda(String mm[][]){
        System.out.println("------------------ Contatos da Agenda -------------");
        for(int l =0; l < 10; l ++){
            //Enquanto tiver registro exibe-o
            if(mm[l][0] != ""){
                exibirContato(mm, l);
                System.out.println("-------------------------------------------");
            }

        }
        System.out.println("Fim da agenda");
    }

    public static void apagarContato(String mm[][], String n){

        //inicia a variavel achou contato como nula
        boolean achou = false;

        int linha  = pesquisarContato(mm, n);

        String opcao;
        if (linha != -1){
            exibirContato(mm, linha);
            System.out.println("Confirma a exclusão do contato?\n[S]im ou [N]ão");
            opcao = entrada.next();
            if(opcao.equals("s") || opcao.equals("S")){
                excluiLinha(mm, linha);
            }
            else{
                System.out.println("Exclusão Cancelada!");
            }
        }
    }
    public static void excluiLinha(String mm[][], int l){
        mm[l][0] = "";
        mm[l][1] = "";
        mm[l][2] = "";
        System.out.println("Contato excluído");
    }
}
