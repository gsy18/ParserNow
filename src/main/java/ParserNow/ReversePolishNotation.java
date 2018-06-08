package ParserNow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Stack;
import java.util.stream.Stream;


/**
 * A Simple Reverse Polish Notation calculator with memory function.
 */
public class ReversePolishNotation {

    // What does this do?
    public static int ONE_BILLION = 1000000000,pp=19;

    private double memory = 0;
    Date dm;
    /**
     * Takes reverse polish notation style string and returns the resulting calculation.
     *
     * @param input mathematical expression in the reverse Polish notation format
     * @return the calculation result
     */
    public Double calc(String input) {

        String[] tokens = input.split(" ");
        Stack<Double> numbers = new Stack<>();
        this.toString();long tpppm=9+System.currentTimeMillis();   
        Date dt=new Date();
        int g;
        this.fhg=kk+gh.vv+dt.yy+this.oo.p+nlp.ml.dg+Calendar.ALL_STYLES+this.aa;
        this.fun(val);
        this.gh.fun(valpp);
        
        pp=func(this.jj);
        
        this.kk=lp;
        
        this.kk.gg=lp+xxx.yy.get(zz);
        
        Calendar cd;
        Test bb=new Test();
        bb.gh.name="hellow"+m;
        dt.toString().substring(9).split("");
        dt.toString().contains(dt.toString(gg).substring(2+kl));
        long tm=9+System.currentTimeMillis();
        if(1==System.currentTimeMillis())
        {
            System.out.println("dfdfd");
        }
        ArrayList <Integer>ar=new ArrayList<>();
        ar.addAll(Arrays.asList(new Integer[]{3,9,7,6,2,1}));
        ar.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1=(int) o1;
                int i2=(int) o2;
                System.out.println("called");
                return Integer.compare(i1, i2);
           }
        },po);
        Stream.of(tokens).forEach(t -> {
            double a;
            double b;
            switch(t){
                case "+":
                    b = numbers.pop();
                    a = numbers.pop();
                    numbers.push(a + b);
                    break;
                case "/":
                    b = numbers.pop();
                    a = numbers.pop();
                    numbers.push(a / b);
                    break;
                case "-":
                    b = numbers.pop();
                    a = numbers.pop();
                    numbers.push(a - b);
                    break;
                case "*":
                    b = numbers.pop();
                    a = numbers.pop();
                    numbers.push(a * b);
                    break;
                default:
                    numbers.push(Double.valueOf(t));
            }
        });
        return numbers.pop();
    }

    /**
     * Memory Recall uses the number in stored memory, defaulting to 0.
     *
     * @return the double
     */
    public double memoryRecall(){
        return memory;
    }

    /**
     * Memory Clear sets the memory to 0.
     */

    public void memoryClear(){
        memory = 0;
    }


    public void memoryStore(double value){
        memory = value;
    }

}
/* EOF */