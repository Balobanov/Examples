package ua.org.oa.balobanov_d.task5_1;

import java.awt.Color;

public class Car
{
    private Color color;
    private int maxSpeed;
    private int engineCapacity;

    public Car(Color c, int ms, int ec) 
    {
        color = c;
        maxSpeed = ms;
        engineCapacity = ec;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(color.getRGB() == ((Car)o).getColor().getRGB())
            if(maxSpeed == ((Car)o).getMaxSpeed())
                if(engineCapacity == ((Car)o).getEngineCapacity())
                    return true;
        return false;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
 
    @Override
    public String toString()
    {
        return "Color" + color.toString() + ". Max Speed = " + maxSpeed + ". Engine Capacity = " + engineCapacity;
    }
}