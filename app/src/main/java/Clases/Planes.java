package Clases;

public class Planes {
    private int xtreme;
    private int mindfullnes;

    // contructor
    public Planes()
    {
        xtreme = 12000;
        mindfullnes = 24000;
    }

    //getter o accesadores
    public int getXtreme()
    {
        return xtreme;
    }
    public int getMindfullnes()
    {

        return mindfullnes;
    }

    //Setter o Mutador
    public void setXtreme(int xtreme)
    {
        this.xtreme = xtreme;
    }
}
