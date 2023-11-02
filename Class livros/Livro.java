import java.math.*;

public class Livro {

    // Declaração dos atributos da classe Livro
    private Long ISBN;
    private String titulo;
    private String autorPrincipal;
    private String segundoAutor;
    private String categoria;
    private String descricao;
    private int anoPublicacao;
    private int quantidadePaginas;
    private double notaAvaliacao;
    private int quantidadeAvaliacoes;

    // Construtores da classe Livro
    public Livro() {}

    public Livro(Long iSBN, String titulo, String autorPrincipal, String segundoAutor, String categoria,
            String descricao, int anoPublicacao, int quantidadePaginas, double notaAvaliacao,
            int quantidadeAvaliacoes) {
        // Inicialização dos atributos no construtor
        ISBN = iSBN;
        this.titulo = titulo;
        this.autorPrincipal = autorPrincipal;
        this.segundoAutor = segundoAutor;
        this.categoria = categoria;
        this.descricao = descricao;
        this.anoPublicacao = anoPublicacao;
        this.quantidadePaginas = quantidadePaginas;
        this.notaAvaliacao = notaAvaliacao;
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }

    // Métodos getters e setters para acessar e modificar os atributos da classe

    // Método de impressão
    public void imprimir() {
        if (segundoAutor.equals("")) {
            System.out.println(autorPrincipal + ". " + titulo + ". " + anoPublicacao + ". ISBN: " + ISBN + ".");
        } else {
            System.out.println(autorPrincipal + ", " + segundoAutor + ". " + titulo + ". " + anoPublicacao + ". ISBN: " + ISBN + ".");
        }
    }

    // Método para criar uma cópia do livro
    public Livro clone() {
        return new Livro(ISBN, titulo, autorPrincipal, segundoAutor, categoria, descricao, anoPublicacao, quantidadePaginas, notaAvaliacao, quantidadeAvaliacoes);
    }

    // Método para ler os dados do livro
    public void ler() {
        // Aqui você pode implementar a lógica para ler os dados do livro a partir da entrada do usuário ou de um arquivo.
    }

    // Método main, onde o programa começa a execução
    public static void main(String[] args) {
        // Leitura da quantidade de livros
        int qtd = Integer.parseInt(MyIO.readLine());
        int i = 0, k = 0;
        Livro[] livros = new Livro[qtd];
        String[] entrada = new String[qtd + 1];
        String[] dados;

        // Leitura de dados
        do {
            entrada[i] = MyIO.readLine();
        } while (!entrada[i++].equals("FIM"));

        i = 0;

        // Preenchimento do array de livros
        while (!entrada[i].equals("FIM")) {
            dados = entrada[i++].split("\\|");
            livros[k++] = new Livro(Long.parseLong(dados[0]), dados[1], dados[2], dados[3], dados[4],
                    dados[5], Integer.parseInt(dados[6]), Integer.parseInt(dados[7]),
                    Double.parseDouble(dados[8]), Integer.parseInt(dados[9]));
        }

        // Pesquisa de dados
        do {
            dados = MyIO.readLine().split(";");
            for (Livro livro : livros) {
                if (livro.getTitulo().equals(dados[0]) && livro.getAnoPublicacao() == Integer.parseInt(dados[1]) && livro.getAutorPrincipal().equals(dados[2])) {
                    livro.imprimir();
                }
            }
        } while (!dados[0].equals("FIM"));
    }
}