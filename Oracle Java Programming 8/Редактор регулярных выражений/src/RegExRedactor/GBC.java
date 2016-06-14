/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegExRedactor;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author DENNNN
 */
public class GBC extends GridBagConstraints{
    public GBC(int grifx, int gridy)
    {
        this.gridx = gridx;
        this.gridy = gridy;
    }
    
    public GBC(int grifx, int gridy, int gridwidth, int gridheight)
    {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridheight = gridheight;
        this.gridwidth = gridwidth;
    }
    
    public GBC setFill(int fill)
    {
        this.fill = fill;
        return this;
    }
    
    public GBC setAnchor(int anchor)
    {
        this.anchor = anchor;
        return this;
    }
    
    public GBC setWeight(double weightx, double weighty)
    {
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }
    
    public GBC setInsets (int distance)
    {
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }
    
    public GBC setIpad(int ipadx, int ipady)
    {
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }
}
