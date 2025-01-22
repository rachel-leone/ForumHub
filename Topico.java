import java.time.LocalDateTime;

public class Topico {
    private final Long id;
    private String titulo;
    private String mensagem;
    private final LocalDateTime dataCriacao;

    public Topico(Long id, String titulo, String mensagem) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Tópico ID: " + id + "\nTítulo: " + titulo + "\nMensagem: " + mensagem + "\nData de Criação: " + dataCriacao + "\n";
    }
}
