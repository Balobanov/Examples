package ua.org.ao.balobanov;

import java.awt.Color;

/**
 *
 * @author DENNNN
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       // Два объекта с реализацией equals и toString для класса, по умолчанию
       Car car3 = new Car(Color.red, 320, 16);
       Car car4 = new Car(Color.red, 300, 12);
       
       
       System.out.println(car3.equals(car4));
       System.out.println(car4.equals(car3));
       
       System.out.println(car3);
       System.out.println(car4);
       
       System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.println("~~~~~~~~Переопределение для объектов~~~~~~~~");
       System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       Car car1 = new Car(Color.red, 320, 16)
        {
                @Override
                public boolean equals(Object o)
                {
                    if(this.getColor().getRGB() == ((Car)o).getColor().getRGB())
                        if(this.getMaxSpeed() == ((Car)o).getMaxSpeed())
                            if(this.getEngineCapacity() == ((Car)o).getEngineCapacity())
                            {
                                System.out.println("Объекты равны. equals для объекта car1");
                                return true;
                            }
                    System.out.println("Объекты не равны. equals для объекта car1");
                    return false;
                }
                
                @Override
                public String toString()
                {
                    return "Для объекта car1. " 
                            + "Цвет: " +  this.getColor().toString() 
                                + ". Скорость: " + this.getMaxSpeed()
                                    + ". Объем двигателя: " + this.getEngineCapacity();
                }
        };
        
        
        /*
         * Метод toString выводит информацию в другом порядке для car2
         * Метод equals инвертирует значение полученное при сравнении
         * если объекты равны будет false, если не равны true
         */
        Car car2 = new Car(Color.red, 300, 12)
        {
                @Override
                public boolean equals(Object o)
                {
                    if(this.getColor().getRGB() == ((Car)o).getColor().getRGB())
                        if(this.getMaxSpeed() == ((Car)o).getMaxSpeed())
                            if(this.getEngineCapacity() == ((Car)o).getEngineCapacity())
                            {
                                System.out.println("Объекты равны. equals для объекта car2");
                                return !true;
                            }
                    System.out.println("Объекты не равны. equals для объекта car2");
                    return !false;
                }
                
                @Override
                public String toString()
                {
                    return "Для объекта car2. " 
                            +  "Скорость: " + this.getMaxSpeed()
                                + ". Объем двигателя: " + this.getEngineCapacity()
                                   + ". Цвет: " +  this.getColor().toString();
                }
        };
        
       System.out.println(car1.equals(car2));
       System.out.println(car2.equals(car1));
       
       System.out.println(car1);
       System.out.println(car2);
    }
    
}