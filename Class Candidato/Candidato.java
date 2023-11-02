import java.util.*;

public class Candidato {
    // Informações privadas
    private int codigo;
    private String nome;
    private double[] nota;// notas do jurados
    private int NF;// nota final
    private char nivel;// nivel pela nota

    // criando um função vazia
    public Candidato() {

    }

    public Candidato(int codigo, String nome, double[] nota, int NF, char nivel) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.nota = nota;
        this.NF = NF;
        this.nivel = nivel;
    }

    // criando os gets e sets
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNota() {
        return nota;
    }

    public void setNota(double[] nota) {
        this.nota = nota;
    }

    public char getNivel() {
        return nivel;
    }

    public void setNivel(char nivel) {
        this.nivel = nivel;
    }

    public int getNF() {
        return NF;
    }

    // função para fornecer o nivel da nota
    public void setNF(int NF) {
        this.NF = NF;
        if (NF >= 45) {
            setNivel('A');
        } else if (NF >= 40) {
            setNivel('B');
        } else if (NF >= 35) {
            setNivel('C');
        } else if (NF >= 30) {
            setNivel('D');
        } else {
            setNivel('E');
        }
    }

    // Este método retorna uma representação em string do objeto Candidato.
    public String toString() {
        String retorn = "[" + codigo + "]" + nome + ": ";
        if (nota != null) {
            retorn += (NF + "(" + nivel + ")");
        } else {
            retorn += "-";
        }
        return retorn;
    }

    // Main
    public static void main(String[] args) {
        String L;
        String[] dados;
        Candidato nv;

        double[] nota;
        int NF, i = 0;
        double soma_da_nota;
        Candidato[] candidatos = new Candidato[50];

        L = MyIO.readLine();

        // Parte 1 e 2
        while (!L.equals("FIM")) {
            dados = L.split(",");
            nota = new double[5];
            nv = new Candidato();
            nv.setCodigo(Integer.parseInt(dados[0]));
            nv.setNome(dados[1]);
            if (validaDados(dados)) {
                nota[0] = Double.parseDouble(dados[2]);
                nota[1] = Double.parseDouble(dados[3]);
                nota[2] = Double.parseDouble(dados[4]);
                nota[3] = Double.parseDouble(dados[5]);
                nota[4] = Double.parseDouble(dados[6]);
                nv.setNota(nota);

                soma_da_nota = nota[0] + nota[1] + nota[2] + nota[3] + nota[4];
                NF = (int) Math.round(soma_da_nota);
                nv.setNF(NF);
            }
            candidatos[i++] = nv;
            MyIO.println(nv.toString());

            L = MyIO.readLine();

        }
        MyIO.println("***************");
        // parte 3
        for (Candidato c : candidatos) {
            if (c != null && c.getNota() != null && setentaporcento(c.getNota())) {
                MyIO.println(c.toString());
            }
        }
        MyIO.println("*****");

        for (Candidato c : candidatos) {
            if (c != null && c.getNota() != null && c.getNF() >= 40) {
                MyIO.println(c.toString());
            }
        }

    }

    public static boolean validaDados(String[] dados) {
        int tam = dados.length;
        if (tam != 7) {
            return false;
        }

        for (int i = 2; i < tam; i++) {
            if (dados[i].equals("x")) {
                return false;
            }
        }
        return true;
    }

    public static boolean setentaporcento(double[] nota) {
        int tamanho = nota.length;
        for (int i = 0; i < tamanho; i++) {
            if (nota[i] >= 70) {
                return true;
            }
        }
        return false;
    }
}