public class Quad
{
    public static String solveQuad(int a,int b,int c)
    {
        double x1=((-b)+(Math.sqrt(b*b-4*a*c)))/(2*a);
        double x2=((-b)-(Math.sqrt(b*b-4*a*c)))/(2*a);
        return ("Solutions: "+x1+" , "+x2);
    }
}
