package com.estudo;

import java.util.*;

public class ExemploSet {

    public static void main(String[] args) {
        //Dado um lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

        //Exemplo de como iniciar um SET:
        //Set notas = new HashSet(); //antes do java 5
        //HashSet<Double> notas = new HashSet<>();
        //Set<double> notas = new HashSet<>(); //Generics (jdk 5) - Diamont operator (jdk 7)
        //Set<Double> notas = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); //Set imutável, não podendo adicionar e nem remover.

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);//Não mostra na ordem e também os elementos repeditos mostra somente uma vez, pois SET não aceita repetição.

        System.out.println("Exiba a posição da nota 5.0: ");
        System.out.println("- Em SET não temos o índice dos elementos, com isso não existe o método GET.");

        System.out.println("Adicione na Lista a nota 8.0 na posição 4: ");
        System.out.println("- Em SET não temos o índice dos elementos, com isso não é possivel passar a posição na qual o elemento será adicionado.");

        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        System.out.println("- Em SET não temos o índice dos elementos, com isso não temos o método SET.");

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));

        System.out.println("Exiba a terceira nota adicionada: ");
        System.out.println("- Em SET não temos o índice dos elementos, com isso não existe o método GET.");

        System.out.println("Exiba a menor nota: "+ Collections.min(notas));

        System.out.println("Exiba a maior nota: "+ Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exibir a soma dos valores: "+ soma);

        System.out.println("Exiba a média das notas: "+ soma/notas.size());

        System.out.println("Remova a nota 0 :");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("Remova a nota da posição 0: ");
        System.out.println("- Em SET não temos o índice dos elementos, com isso não existe o método Remove passando a posição.");

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            if(iterator1.next() < 7)   iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem em que foram informada. ");
        System.out.println("- Para exibir em ordem que foram informada, deve usar a implementação LinkedHashSet");
        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas2);

        System.out.println("Exiba todas as notas na ordem crescente: ");
        System.out.println("- Para exiber na ordem natural do tipo, devemos usar a implementação TreeSet. Como estamos usando o Double, o mesmo possui a implementação Comparable.");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto: ");
        notas3.clear();
        System.out.println(notas3);

        System.out.println("Confira se o conjunto está vazio: "+notas3.isEmpty());



    }
}
