
package exercício.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class ExercícioLists {

    
    public static void main(String[] args) {
        
       //Criando List
       List<Double> temperatura = new ArrayList<>();
       
       //Adicionando valores na Lista (fica na ordem em que foram adicionados)
       temperatura.add(4.0);
       temperatura.add(17.0);
       temperatura.add(31.0);
       temperatura.add(26.0);
       temperatura.add(12.0);
       temperatura.add(34.0);
       temperatura.add(2.0);
       
       //ImprimirList
       System.out.println(temperatura.toString());
       
       //Exibir a posição em que se localiza um determinado elemento em uma lista
       System.out.println("Exiba a posição da temperatura 26 graus: "+ temperatura.indexOf(26d));
       
       //Adicionar um certo elemento na lista em uma determinada posição (sempre a posição que desaja -1)
       temperatura.add(3, 20.0);
       System.out.println(temperatura);
       
       //Substituindo 26 graus por 27 graus (é necessário saber a posição do elemento que deseja substituir)
       temperatura.set(4, 27.0);
       System.out.println(temperatura);
       
       //Verificar se um determinado elemento esta na lista
       System.out.println("Confira se a temperatura 26 graus está na lista: "+ temperatura.contains(26.0));
       System.out.println("Confira se a temperatura 27 graus está na lista: "+ temperatura.contains(27.0));
       
       //Mostrar lista em ordem em que foram informados (em coluna)
       System.out.println("Mostrar lista em ordem em que foram informados: ");
       for (Double temp : temperatura) System.out.println(temp);
       
       //Exibir o elemento localizado na posição que você deseja (sempre posição desejada -1, pois a lista começa na posição 0)
       System.out.println("Exiba a quarta temperatura adicionada: "+ temperatura.get(3));
       System.out.println(temperatura.toString());
       
       //Exibir a menor temperatura, necessário utilizar o Collections, pois a list não tem essa função
       System.out.println("Exiba a menor temperatura: "+ Collections.min(temperatura));
       
       //Exibir a maior temperatura, necessário utilizar o Collections, pois a list não tem essa função
       System.out.println("Exiba a maior temperatura: "+ Collections.max(temperatura));
       
       
       //Exibir a soma das temperatura, necessário utilizar o Iterator, pois a list não tem essa função, crie a variavel iterator
       Iterator<Double> iterator = temperatura.iterator();
       Double soma= 0.0;
       while (iterator.hasNext()){ // condição: enquanto iterator tiver próximo...
           Double next = iterator.next();
           soma += next;
       }
        System.out.println("Exiba a soma das temperaturas: "+ soma);
        
       //Exibir a média das temperatura
        System.out.println("Exiba a média das temperaturas: "+ (soma/temperatura.size()));
        
        //Remover um elemento da lista
        System.out.println("Remova a temperatura 34: ");
        temperatura.remove(34.0);
        System.out.println(temperatura);
        
        //Remover um elemento da lista a partir da posilção em que se encontra
        System.out.println("Remova a temperatura da posição 0: ");
        temperatura.remove(0);
        System.out.println(temperatura);
        
        //Remover elementos abaixo de uma certa condição por exemplo: 20
        System.out.println("Remova as temperaturas abaixo de 20 graus: ");
        Iterator<Double> iterator1 = temperatura.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if (next < 20.0){
                iterator1.remove();
            }   
        }
        System.out.println(temperatura); 
        
        //Apagar totalmente a lista
        temperatura.clear();
        System.out.println(temperatura); 
        
         //Verificar se a Lista está realmente vazia
         System.out.println("Confira se a lista esta vazia: "+ temperatura.isEmpty()); //A lista está vazia ? Sim = True, Não = False
    }
    
}
