import java.util.Scanner;

public class ForumHub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TopicoController controller = new TopicoController();
        boolean executando = true;

        System.out.println("Bem-vindo ao ForumHub!");

        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Criar Tópico");
            System.out.println("2. Listar Tópicos");
            System.out.println("3. Buscar Tópico por ID");
            System.out.println("4. Atualizar Tópico");
            System.out.println("5. Deletar Tópico");
            System.out.println("0. Sair");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o título do tópico:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite a mensagem do tópico:");
                    String mensagem = scanner.nextLine();
                    Topico novoTopico = controller.criarTopico(titulo, mensagem);
                    System.out.println("Tópico criado com sucesso: \n" + novoTopico);
                }
                case 2 -> {
                    System.out.println("Tópicos disponíveis:");
                    controller.listarTopicos().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Digite o ID do tópico que deseja buscar:");
                    Long id = Long.parseLong(scanner.nextLine());
                    Topico topico = controller.buscarTopico(id);
                    if (topico != null) {
                        System.out.println("Tópico encontrado:\n" + topico);
                    } else {
                        System.out.println("Tópico com ID " + id + " não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.println("Digite o ID do tópico que deseja atualizar:");
                    Long id = Long.parseLong(scanner.nextLine());
                    System.out.println("Digite o novo título do tópico:");
                    String novoTitulo = scanner.nextLine();
                    System.out.println("Digite a nova mensagem do tópico:");
                    String novaMensagem = scanner.nextLine();
                    if (controller.atualizarTopico(id, novoTitulo, novaMensagem)) {
                        System.out.println("Tópico atualizado com sucesso!");
                    } else {
                        System.out.println("Tópico com ID " + id + " não encontrado.");
                    }
                }
                case 5 -> {
                    System.out.println("Digite o ID do tópico que deseja deletar:");
                    Long id = Long.parseLong(scanner.nextLine());
                    if (controller.deletarTopico(id)) {
                        System.out.println("Tópico deletado com sucesso!");
                    } else {
                        System.out.println("Tópico com ID " + id + " não encontrado.");
                    }
                }
                case 0 -> {
                    executando = false;
                    System.out.println("Encerrando o sistema. Até mais!");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
