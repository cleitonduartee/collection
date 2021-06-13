package com.estudo;

import java.util.*;

public class ExemploList {

    public static void main(String[] args) {

        //Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça :

        System.out.println("Crie um lista e adicione as 7 notas: ");

        //Exemplos de iniciar uma List;

        //List notas = new ArrayList(); //antes do java 5
        //ArrayList<Double> notas = new ArrayList<>();
        //List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        //List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); //Desse jeito fica limitado, não podendo adicionar adicionar e nem remover elmentos por ex.
        //List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); //Desse jetio a lista é imutável, não podendo tbem adicionar e nem remover elementos.

        List<Double> notas = new ArrayList<>(); //Generics (jdk 5) - Diamond Operator(jdk 7)
        notas.addAll(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);

        System.out.println("Exiba a posição da nota 5.0: "+ notas.indexOf(5d));

        System.out.println("Adicione na Lista a nota 8.0 na posição: 4");
        notas.add(4,8d);
        System.out.println(notas);

        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5d), 6d );
        System.out.println(notas);

        System.out.println("Confira se a nota 5.0 esta na lista: "+notas.contains(5d));

        System.out.println("Exiba todas as notas em que foram informados: "); //Na Interface LIST o mesmo garante a ordem de inserção
        int indice = 1;
        for (Double nota: notas) {
            System.out.println(indice +" - "+ nota);
            indice++;
        }

        System.out.println("Exiba a terceira nota adicionada: "+notas.get(2));

        System.out.println("Exiba a menor nota: "+ Collections.min(notas));

        System.out.println("Exiba a maior nota: "+ Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma =0d;
        while (iterator.hasNext()) soma += iterator.next();
        System.out.println("Exiba a soma dos valores: "+soma);

        System.out.println("Exiba a média das notas: "+soma/notas.size());

        System.out.println("remova a nota zero: ");
        notas.remove(0d);
        //notas.remove(notas.indexOf(0d));
        System.out.println(notas);

        System.out.println("Remova a nota da posição 0: ");
        notas.remove(0);
        System.out.println(notas);

        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
           if(iterator1.next() < 7) iterator1.remove();
        }
        System.out.println("Remova as notas menores que 7 e exiba a lista: "+notas);

        System.out.println("Apague toda a lista: ");
        notas.clear();
        System.out.println(notas);

        System.out.println("Confira se a lista está vazia: "+notas.isEmpty());
    }
}
