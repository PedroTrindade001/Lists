package Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListsSegundaParte {


    public static void main(String[] args) {
        //Criando variável e alocando dentro da lista alguns elementos
        List<Carro> meusCarros = new ArrayList<>(){{
            add(new Carro("Onix", 2017, "Preto"));
            add(new Carro("Camaro", 2020, "Amarelo"));
            add(new Carro("Gol", 2009, "Prata"));
        }};
        System.out.println("Ordem de Inserção");
        System.out.println(meusCarros);

        //Aleatorizar a ordem da lista
        System.out.println("Ordem Aleatória");
        Collections.shuffle(meusCarros);
        System.out.println(meusCarros);

        //Ordernar pelo atributo String Modelo (Necessário implementar comparable na classe Carro e um método compareTo)
        System.out.println("Ordem Natural(Modelo/Nome)");
        Collections.sort(meusCarros);
        System.out.println(meusCarros);

        //Ordenar por ano, também funciona com outros atributos do objeto (criado a classe comparatorAno para efetuar)
        System.out.println("Ordem Ano");
        Collections.sort(meusCarros, new comparatorAno());
        System.out.println(meusCarros);

        //Ordenar por cor, também funciona com outros atributos do objeto (criado a classe comparatorCor para efetuar)
        System.out.println("Ordem Cor");
        Collections.sort(meusCarros, new comparatorCor());
        System.out.println(meusCarros);

        //
        System.out.println("Ordem Modelo/Cor/Ano");
        Collections.sort(meusCarros, new comparatorModeloCorAno());
        System.out.println(meusCarros);

    }


}

class Carro implements Comparable<Carro> {
    private String modelo;
    private Integer ano;
    private String cor;

    public Carro(String modelo, Integer ano, String cor) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + modelo + '\'' +
                ", idade=" + ano +
                ", cor='" + cor + '\'' +
                '}';
    }

//Adicionado para ordenar pelo nome/modelo no main
    @Override
    public int compareTo(Carro carro) {
        return this.getModelo().compareToIgnoreCase(carro.getModelo());
    }
}

//Utilizado para ordenar pelo atributo "Ano"
class comparatorAno implements Comparator<Carro>{
    @Override
    public int compare(Carro c1, Carro c2){
        return Integer.compare(c1.getAno(), c2.getAno());
    }
}

//Utilizado para ordenar pelo atributo "Cor"
class comparatorCor implements Comparator<Carro>{
    @Override
    public int compare(Carro c1, Carro c2){
        return c1.getCor().compareToIgnoreCase(c2.getCor());
    }
}

//Utilizado para ordenar pelo atributo "Modelo">"Cor">"Ano"
class comparatorModeloCorAno implements Comparator<Carro>{
    @Override
    public int compare(Carro c1, Carro c2){

        int modelo = c1.getModelo().compareToIgnoreCase(c2.getModelo());
        //Só ira passar para o próximo atributo quando o modelo estiver organizado.
        if (modelo != 0){
            return modelo;
        }
        int cor = c1.getCor().compareToIgnoreCase(c2.getCor());
        //Só ira passar para o próximo atributo quando a cor estiver organizada.
        if (cor != 0){
            return cor;
        }
        //Organizar Ano
        return Integer.compare(c1.getAno(), c2.getAno());
    }
}
