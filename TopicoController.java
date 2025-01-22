import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TopicoController {
    private final List<Topico> topicos = new ArrayList<>();
    private Long idCounter = 1L;

    // Criar um novo tópico
    public Topico criarTopico(String titulo, String mensagem) {
        Topico topico = new Topico(idCounter++, titulo, mensagem);
        topicos.add(topico);
        return topico;
    }

    // Listar todos os tópicos
    public List<Topico> listarTopicos() {
        return topicos;
    }

    // Buscar um tópico por ID
    public Topico buscarTopico(Long id) {
        Optional<Topico> topicoEncontrado = topicos.stream()
                .filter(topico -> topico.getId().equals(id))
                .findFirst();
        return topicoEncontrado.orElse(null);
    }

    // Atualizar um tópico
    public boolean atualizarTopico(Long id, String novoTitulo, String novaMensagem) {
        Topico topico = buscarTopico(id);
        if (topico != null) {
            topico.setTitulo(novoTitulo);
            topico.setMensagem(novaMensagem);
            return true;
        }
        return false;
    }

    // Deletar um tópico
    public boolean deletarTopico(Long id) {
        return topicos.removeIf(topico -> topico.getId().equals(id));
    }
}
