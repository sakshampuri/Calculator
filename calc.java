public class calc
{
    public static String s;
    public static String add(double num1,double num2)
    {
        double ans=num1+num2;
        s=String.valueOf(ans);
        return s;
    }

    public static String sub(double num1,double num2)
    {
        double ans=num1-num2;
        s=String.valueOf(ans);
        return s;
    }

    public static String multi(double num1,double num2)
    {
        double ans=num1*num2;
        s=String.valueOf(ans);
        return s;
    }

    public static String div(double num1, double num2)
    {
        double ans=num1/num2;
        s=String.valueOf(ans);
        return s;
    }

    public static String percent(double num1,double num2)
    {
        double ans=(num1/num2)*100;
        s=String.valueOf(ans);
        return s;
    }

    public static String sin(double num1)
    {
        double ans=Math.tan(num1);
        s=String.valueOf(ans);
        return s;
    }

    public static String cos(double num1)
    {
        double ans=Math.cos(num1);
        s=String.valueOf(ans);
        return s;
    }

    public static String tan(double num1)
    {
        double ans=Math.tan(num1);
        s=String.valueOf(ans);
        return s;
    }

    public static String cosec(double num1)
    {
        double ans=1/(Math.sin(num1));
        s=String.valueOf(ans);
        return s;
    }

    public static String sec(double num1)
    {
        double ans=1/(Math.cos(num1));
        s=String.valueOf(ans);
        return s;
    }

    public static String cot(double num1)
    {
        double ans=1/(Math.tan(num1));
        s=String.valueOf(ans);
        return s;
    }
}
