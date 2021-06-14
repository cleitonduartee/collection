package com.estudo;

/* Dados as seguintes informações sobre minhas séries favoritas,
crie um conjunto e ordene este conjunto exibindo:
(nome - genero - tempo de epiódio);

Série 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
Série 1 = Nome: dark, genero: drama, tempoEpisodio: 60
Série 1 = Nome: that '70s show, genero: comédia, tempoEpisodio: 25
 */

import java.util.*;

public class ExemploOrdenaçãoSet {
    public static void main(String[] args) {
        System.out.println("--\tOdem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got","fantasia", 60));
            add(new Serie("dark","drama", 60));
            add(new Serie("that '70s show","comédia", 25));
        }};
        for (Serie serie: minhasSeries) System.out.println(serie.getNome()+" - "+serie.getGenero()+"- "+serie.getTempoDeEpisodio());


        System.out.println("--\tOdem inserção\t--");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("got","fantasia", 60));
            add(new Serie("dark","drama", 60));
            add(new Serie("that '70s show","comédia", 25));
        }};
        for (Serie serie: minhasSeries1) System.out.println(serie.getNome()+" - "+serie.getGenero()+"- "+serie.getTempoDeEpisodio());

        System.out.println("--\tOdem natural(TempoEpisodio)\t--" );
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);

        for (Serie serie: minhasSeries2) System.out.println(serie.getNome()+" - "+serie.getGenero()+"- "+serie.getTempoDeEpisodio());


        System.out.println("--\tOdem Nome/Gênero/TempoEpisodio\t--");
        Set<Serie> minhasSeries3 = new TreeSet<>( new ComparetorNomeGeneroTempoEpsodio());
        minhasSeries3.addAll(minhasSeries2);
        for (Serie serie: minhasSeries3) System.out.println(serie.getNome()+" - "+serie.getGenero()+"- "+serie.getTempoDeEpisodio());


    }
}

class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer tempoDeEpisodio;

    public Serie(String nome, String genero, Integer tempoDeEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoDeEpisodio = tempoDeEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoDeEpisodio() {
        return tempoDeEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoDeEpisodio=" + tempoDeEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoDeEpisodio.equals(serie.tempoDeEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoDeEpisodio);
    }

    @Override
    public int compareTo(Serie s1) {
        int tempo = Integer.compare(this.getTempoDeEpisodio(), s1.getTempoDeEpisodio());
        if(tempo != 0) return tempo;

        int genero = this.getGenero().compareTo(s1.getGenero());
        if(genero != 0) return genero;

        return this.getNome().compareTo(s1.getNome());

    }
}

class ComparetorNomeGeneroTempoEpsodio implements  Comparator<Serie>{


    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if(nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if(genero != 0) return genero;

        return Integer.compare(s1.getTempoDeEpisodio(), s2.getTempoDeEpisodio());

    }
}

