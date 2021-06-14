package com.estudo;

import java.util.*;

public class ExemploMap {

    public static void main(String[] args) {
	/* Dado os modelos dos carrose seus respectivos consumo na estrada, faça:
	modelo = gol - consumo = 14,4km/l
	modelo = uno - consumo = 15,6km/l
	modelo = mobi - consumo = 16,1km/l
	modelo = hb20 - consumo = 14,5km/l
	modelo = kwid - consumo = 15,6km/l
	 */

    // Exemplo iniciar MAp
        /*Map carrosPopulares = new HashMap(); //antes do java 5
          */
        // Map<String, Double> carrosPopulares = new HashMap<>(); //Generics(jdk 5)
        // HashMap<String, Double> carrosPopulares = new HashMap<>();
        // Map<String, Double> carrosPopulares = Map.of("gol",14.4,"uno",15.6,"mobi",16.1,"hb20",14.5,"kwid",15.6);

        System.out.println("Crie um dicionario que relacione os modelos e seus respectivos consumo: ");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares);

        System.out.println("Substitua o consumo do gol por 15,2 km/l");
        carrosPopulares.put("gol",15.2);
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo tucson está no dicionário: "+carrosPopulares.containsKey("tucson"));

        System.out.println("Exiba o consumo do uno: "+carrosPopulares.get("uno"));

        System.out.println("Exiba o terceiro modelo adicionado: ");
        System.out.println("- Com a implementação HashMap não é possivel, pois a ordem é aleatória.");

        System.out.println("Exiba os modelos");
        for (String modelo:  carrosPopulares.keySet()) System.out.println(modelo);

        System.out.println("Exiba o consumo dos carros: ");
        for (Double consumo: carrosPopulares.values()) System.out.println(consumo);

        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        double consumoEconomico = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();

        for (Map.Entry<String, Double> entry: entries) if(entry.getValue().equals(consumoEconomico)){
            System.out.println(entry.getKey()+" - "+consumoEconomico);
        }

        System.out.println("Exiba o modelo menos econômico e seu consumo");
        double consumoAlto = Collections.min(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries1 = carrosPopulares.entrySet();
        for (Map.Entry<String, Double> entry: entries1) {
            if (entry.getValue().equals(consumoAlto)){
                System.out.println(entry.getKey()+" - "+consumoAlto);
            }
        }

        Double soma = 0d;
        for (Double consumo: carrosPopulares.values()) soma+=consumo;
        System.out.println("Exiba a soma dos consumos: "+ soma);

        System.out.println("Exiba a média do consumo deste dicionário:  "+soma/carrosPopulares.size());

        System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        while(iterator.hasNext()) if (iterator.next() == 15.6) iterator.remove();
        System.out.println(carrosPopulares);

        System.out.println("Exiba todos os carros na ordem que foram informado: ");
        Map<String, Double> carrosOrdem = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosOrdem);

        System.out.println("Exiba o dicionário ordenado pelo modelo");
        Map<String, Double> carrosPorModelo = new TreeMap<>(carrosOrdem);
        System.out.println(carrosPorModelo);

        System.out.println("Apague o dicionário de carros: ");
        carrosOrdem.clear();
        carrosPopulares.clear();
        carrosPorModelo.clear();
        System.out.println(carrosPopulares);

        System.out.println("Confirma se o dicionário está vazio: "+ carrosPopulares.isEmpty());




    }
}
