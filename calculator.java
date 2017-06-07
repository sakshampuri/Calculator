import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class calculator extends JFrame implements ActionListener, KeyListener
{
   public JButton[] dig=new JButton[10];
   public JButton sin,cos,tan,toNegative,add,subtract,divide,multiply,quad,clear,equals,result,back;
   public JTextField txt,a,b,c,o1,o2,op;
   public JPanel inputField,digits,quadSwitcher,extras,zero,addSubt,display;
   public int width=280,height=450;
   public static String input="";
   private ImageIcon img;
   private Color color1=Color.orange;
   private JLabel cred;
   private Double n1=0.0,n2=0.0,angle;
   private boolean setOp=false;
   public calculator()
   {
       super("CALCULATOR");
       cred=new JLabel("Developed By Saksham Puri.");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       img=new ImageIcon("calc.png");
       this.setIconImage(img.getImage());
       this.setLayout(new FlowLayout());
       setSize(width,height);
       display=new JPanel();
       display.setLayout(new FlowLayout());
       display.setPreferredSize(new Dimension(width-15,30));
       o1=new JTextField(null,6);
       o1.setEditable(false);
       op=new JTextField(null,1);
       op.setEditable(false);
       op.setText(null);
       o2=new JTextField(null,6);
       o2.setEditable(false);
       display.add(o1);
       display.add(op);
       display.add(o2);
       this.add(display);
       txt=new JTextField(null,20);
       txt.setEditable(false);
       inputField=new JPanel();
       txt.setPreferredSize(new Dimension(width-50,30));
       inputField.add(txt);
       this.add(inputField);
       txt.addKeyListener(this);
       for(int i=0;i<10;i++)
        dig[i]=new JButton(i+"");
       sin=new JButton("sin");
       cos=new JButton("cos");
       tan=new JButton("tan");
       toNegative=new JButton("+/-");
       add=new JButton("add");
       subtract=new JButton("Subtract");
       add=new JButton("Add");
       multiply=new JButton("Multiply");
       quad=new JButton("Quadratic Equation");
       quad.addActionListener(this);
       divide=new JButton("Divide");
       equals=new JButton("=");
       quadSwitcher=new JPanel();
       quadSwitcher.add(quad);
       this.add(quadSwitcher);
       digits=new JPanel();
       digits.setLayout(new GridLayout(3,3,5,5));
       for(int i=9;i>=1;i--)
        digits.add(dig[i]);
       extras=new JPanel();
       extras.setLayout(new GridLayout(2,3,4,4));
       extras.add(sin);
       sin.setToolTipText("calculate sin of angle.");
       extras.add(cos);
       cos.setToolTipText("calculate cos of angle.");
       extras.add(tan);
       tan.setToolTipText("calculate tan of angle.");
       extras.add(toNegative);
       extras.add(multiply);
       extras.add(divide);
       this.add(digits);
       zero=new JPanel();
       dig[0].setPreferredSize(new Dimension((width/2)-7,25));
       zero.add(dig[0]);
       this.add(zero);
       this.add(extras);
       clear=new JButton("clear");
       clear.addActionListener(this);
       addSubt=new JPanel();
       addSubt.setLayout(new GridLayout(2,2,5,5));
       addSubt.setPreferredSize(new Dimension(width-40,60));
       addSubt.add(add);
       addSubt.add(subtract);
       addSubt.add(equals);
       addSubt.add(clear);
       this.add(addSubt);
       for(int i=0;i<10;i++)
        dig[i].addActionListener(this);
       sin.addActionListener(this);
       cos.addActionListener(this);
       tan.addActionListener(this);
       toNegative.addActionListener(this);
       equals.addActionListener(this);
       add.addActionListener(this);
       subtract.addActionListener(this);
       multiply.addActionListener(this);
       divide.addActionListener(this);
       c=new JTextField("c",4);
       a=new JTextField("a",4);
       b=new JTextField("b",4);
       c.addActionListener(this);
       b.addActionListener(this);
       a.addActionListener(this);
       this.getContentPane().setBackground(color1);
       inputField.setBackground(color1);
       digits.setBackground(color1);
       zero.setBackground(color1);
       quadSwitcher.setBackground(color1);
       extras.setBackground(color1);
       display.setBackground(color1);
       addSubt.setBackground(color1);
       quad.setToolTipText("Solve quadratic equations.");
       setVisible(true);
       this.add(cred);
       setResizable(false);
   }
   public static void main(String args[])
   {
       calculator ob=new calculator();
    }
   @Override
   public void keyPressed(KeyEvent e)
   {
      int keyCode=e.getKeyCode();
      if(e.getSource()==inputField){
          if(keyCode==KeyEvent.VK_ENTER){
          char o=op.getText().charAt(0);
          n1=Double.parseDouble(o1.getText());;
          n2=Double.parseDouble(o2.getText());
           if(o=='+')
              txt.setText(calc.add(n1,n2));
           if(o=='-')
              txt.setText(calc.sub(n1,n2));
           if(o=='X')
             txt.setText(calc.multi(n1,n2));
           if(o=='/')
            txt.setText(calc.div(n1,n2));
           setOp=false;
         }
      }
   }
   public void getAngle()
   {
       try{
       angle=Double.parseDouble(JOptionPane.showInputDialog("Enter The Angle: "));
    }
    catch(Exception rf){
        JOptionPane.showMessageDialog(null,"ERROR!");
    }
   }
   @Override
   public void actionPerformed(ActionEvent e)
   {
       String str=e.getActionCommand();
       if(Character.isDigit(str.charAt(0))){ 
           txt.setText(txt.getText()+""+str);
           if(setOp==false)
            o1.setText(o1.getText()+str); 
           else 
            o2.setText(o2.getText()+str);
        }
        else if(str.equalsIgnoreCase("clear")){txt.setText(""); o1.setText(null);o2.setText(null);op.setText(null);}
         else if(str.equalsIgnoreCase("tan")) {
             getAngle();
             txt.setText(calc.tan(angle));
            }
          else if(str.equalsIgnoreCase("sin")){
             getAngle();
             txt.setText(calc.sin(angle));
            }
           else if(str.equalsIgnoreCase("cos")){
             getAngle();
             txt.setText(calc.cos(angle));
            }
            else if(str.equalsIgnoreCase("add")){
                setOp=true;
                txt.setText(txt.getText()+""+"+");
                op.setText("+");
            }
             else if(str.equalsIgnoreCase("subtract")){
                   setOp=true;
                   txt.setText(txt.getText()+""+"-");
                   op.setText("-");
            }
              else if(str.equalsIgnoreCase("+/-"))txt.setText(txt.getText()+""+"-");
               else if(str.equalsIgnoreCase("multiply")){
                   setOp=true;
                   txt.setText(txt.getText()+""+"*");
                   op.setText("X");
            }
                else if(str.equalsIgnoreCase("divide")){
                    setOp=true;
                    txt.setText(txt.getText()+""+"/");
                    op.setText("/");
            }
                 else if(str.equalsIgnoreCase("=")){
                     char o=op.getText().charAt(0);
                     n1=Double.parseDouble(o1.getText());;
                     n2=Double.parseDouble(o2.getText());
                     if(o=='+')
                      txt.setText(calc.add(n1,n2));
                     if(o=='-')
                      txt.setText(calc.sub(n1,n2));
                     if(o=='X')
                      txt.setText(calc.multi(n1,n2));
                     if(o=='/')
                      txt.setText(calc.div(n1,n2));
                      setOp=false;
            }
                  else if(str.equalsIgnoreCase("Quadratic Equation")) setQuad();
                   else if(str.equalsIgnoreCase("back"))back();
                    else if(str.equalsIgnoreCase("calculate") || e.getSource()==c){try{
                        back(); txt.setText(calcQuad()); validate(); repaint();}
                        catch(Exception prop){
                            txt.setText("Enter Proper Coefficients.");
                       }
                    }
   }
   public void back()
   {
       this.getContentPane().removeAll();
       this.setSize(width,height);
       add(display);
       add(inputField);
       add(quadSwitcher);
       add(digits);
       add(zero);
       add(extras);
       add(addSubt);
       add(cred);
       inputField.removeAll();
       quadSwitcher.removeAll();
       inputField.add(txt);
       quadSwitcher.add(quad);
       display.add(o1);
       display.add(op);
       display.add(o2);
       validate();
       repaint();
   }
   public String calcQuad()
   {
       return Quad.solveQuad(Integer.parseInt(a.getText()),Integer.parseInt(b.getText()),Integer.parseInt(c.getText()));
   }
   public void setQuad()
   {
       inputField.removeAll();
       quadSwitcher.removeAll();
       this.getContentPane().remove(display);
       this.setSize(width,height-45);
       a.setEditable(true);
       b.setEditable(true);
       c.setEditable(true);
       inputField.add(a);
       inputField.add(new JLabel("x^2   +  "));
       inputField.add(b);
       inputField.add(new JLabel("x     +  "));
       inputField.add(c);
       result=new JButton("Calculate");
       result.setToolTipText("Calculate The Two Possible Solutions (if any)");
       back=new JButton("Back");
       back.setToolTipText("Go back to the calculator.");
       back.addActionListener(this);
       result.addActionListener(this);
       quadSwitcher.add(result);
       quadSwitcher.add(back);
       validate();
       repaint();
   }
   @Override
   public void keyReleased(KeyEvent e){}
   @Override
   public void keyTyped(KeyEvent e){}
   public String performOperation(String str)
   {
       int length=str.length(),n1=0,n2;
       for(int i=0;i<length;i++)
       {
           if(Character.isDigit(str.charAt(i))==true)
            n1=(n1*10)+Integer.parseInt(str.charAt(i)+"");
           
       }
       return "Performed Operation";
   }
}
       
