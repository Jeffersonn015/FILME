package Etapa03;

// class tratar erros de validação
class ValorInvalidoException extends Exception {
    public ValorInvalidoException(String message) {
        super(message);
    }
}

// Classe Filme que encapsula e valida atributos
public class Filme {
    private String titulo;  // Armazena o título do filme
    private int duracao;    // Armazena a duracao em minutos
    private String genero;   // Armazena o genero do filme

    // Construtor 
    public Filme(String titulo, int duracao, String genero) throws ValorInvalidoException {
        setTitulo(titulo);     // Chama o método para definir o título
        setDuracao(duracao);   // Chama o método para definir a duração
        setGenero(genero);     // Chama o método para definir o gênero
    }

    // Método para saber o título
    public String getTitulo() {
        return titulo; 
    }

    // Método para definir o título
    public void setTitulo(String titulo) throws ValorInvalidoException {
        if (titulo == null || titulo.trim().isEmpty()) { // uma validacao para ver se o título esta vazio
            throw new ValorInvalidoException("O título NÃO pode estar VAZIO!!");
        }
        this.titulo = titulo; // se o título é válido
    }

    // Método para obter a duração
    public int getDuracao() {
        return duracao;
    }

    // Método para definir a duração
    public void setDuracao(int duracao) throws ValorInvalidoException {
        if (duracao <= 0) { // uma validacao da duração  paar ver se é maior que zero
            throw new ValorInvalidoException("A duração deve ser maior que ZERO!!");
        }
        this.duracao = duracao; // Atribui a duração válida
    }

    // Método para obter o gênero
    public String getGenero() {
        return genero;
    }

    // Método para definir o gênero
    public void setGenero(String genero) throws ValorInvalidoException {
        // Validaco para ver se o genero é romance, terror ou comedia
        if (!genero.equalsIgnoreCase("Romance") && 
            !genero.equalsIgnoreCase("Terror") && 
            !genero.equalsIgnoreCase("Comédia")) {
            throw new ValorInvalidoException("O gênero deve ser Romance, Terror ou Comédia.");
        }
        this.genero = genero; // Atribui o gênero válido
    }

    // Método para exibir informações do filme
    public String exibirInfo() {
        return "Título: " + titulo + ", Duração: " + duracao + " minutos, Gênero: " + genero;
    }

    public static void main(String[] args) {
        try {
            Filme filme = new Filme("As Branquelas", 120, "Comédia"); 
            System.out.println(filme.exibirInfo()); // mostra as informacoes do filme
        } catch (ValorInvalidoException e) {
            System.out.println(e.getMessage()); // mostra mensagem de erro se tiver
        }
    }
}
