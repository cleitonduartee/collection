package com.estudo;

/*Dados as seguintes informações sobre Livros favoritos e seus autores
crie um dicionário e ordene este dicionário:

exibindo (nome Autor - Nome Livro)

Autor = Hawking, Stephen - Livro = Uma breve história do tempo, paginas: 256
Autor = Duhigg, Charles - Livro = O poder do hábito, paginas: 408
Autor = Harari, Yuval Noah - Livro = 21 lições para o século 21, paginas: 432
 */

import java.util.*;

public class ExemploOrdenaçãoMap {

    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o século 21", 432));
        }};
        Set<Map.Entry<String, Livro>> entries = meusLivros.entrySet();
        for (Map.Entry<String, Livro> livro: entries) System.out.println(" Autor: "+livro.getKey() + ". Livro: "+livro.getValue().getNomeLivro());

        System.out.println("--\tOrdem de inserção\t--");
        Map<String, Livro> meuslivrosOrdemInsercao = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições para o século 21", 432));
        }};
        Set<Map.Entry<String, Livro>> entries1 = meuslivrosOrdemInsercao.entrySet();
        for (Map.Entry<String, Livro> livro : entries1) System.out.println(" Autor: "+livro.getKey() + ". Livro: "+livro.getValue().getNomeLivro());

        System.out.println("--\tOrdem autores\t--");
        Map<String, Livro> meusLivrosOrdemAutor = new TreeMap<>(meuslivrosOrdemInsercao);
        Set<Map.Entry<String, Livro>> entries2 = meusLivrosOrdemAutor.entrySet();
        for (Map.Entry<String, Livro> livro : entries2) System.out.println(" Autor: "+livro.getKey() + ". Livro: "+livro.getValue().getNomeLivro());

        System.out.println("--\tOrdem alfabéticas nomes dos livros\t--");
        Set<Map.Entry<String, Livro>> meusLivrosPorNomeLivro = new TreeSet<>(new comparetorPorNomeLivro());
        meusLivrosPorNomeLivro.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivrosPorNomeLivro) System.out.println(" Autor: "+livro.getKey() + ". Livro: "+livro.getValue().getNomeLivro());
    }
}

class Livro {

    private String nomeLivro;
    private Integer qtdPaginas;

    public Livro( String nomeLivro, Integer qtdPaginas) {
        this.nomeLivro = nomeLivro;
        this.qtdPaginas = qtdPaginas;
    }


    public String getNomeLivro() {
        return nomeLivro;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nomeLivro.equals(livro.nomeLivro) && qtdPaginas.equals(livro.qtdPaginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeLivro, qtdPaginas);
    }

    @Override
    public String toString() {
        return "{" +
                "nomeLivro='" + nomeLivro + '\'' +
                ", qtdPaginas=" + qtdPaginas +
                '}';
    }
}

class comparetorPorNomeLivro implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
        return livro1.getValue().getNomeLivro().compareToIgnoreCase(livro2.getValue().getNomeLivro());
    }
}