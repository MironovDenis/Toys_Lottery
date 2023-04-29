package Toys_Lottery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Lottery {
    public static void main(String[] args) {

        Toy input1 = new Toy(1, "Плюшевый медведь", 30);
        Toy input2 = new Toy(2, "Кукла Маша", 20);
        Toy input3 = new Toy(3, "Машинка", 15);
        Toy input4 = new Toy(4, "Мячик", 155);

        List<Toy> toys = new ArrayList<Toy>();
        
        toys.add(input1);
        toys.add(input2);
        toys.add(input3);
        toys.add(input4);
        
        PriorityQueue<Toy> queue = new PriorityQueue<Toy>(Comparator.comparingInt(Toy::getWeight));
        for (Toy toy : toys) {
            queue.offer(toy);
        }

        int totalWeight = 0;
        int count = 0;
        for (Toy toy : toys) {
            count += 1;
            totalWeight += toy.getWeight();
        }
        System.out.println("Всего игрушек: " + totalWeight);

        for (int i = 0; i < count; i++) {
            Toy current = queue.poll();
            float chance = current.getWeight()*100/totalWeight;
            System.out.println(i+1 + ". " + current.getName() + ". Шанс выпадения: " + chance + "%");
        }
    }
}
