public class Calculators {
    public int add(int x, int y){
        return x + y;
    }
    public int sub(int a, int b){
        return a - b;
    }
    public int multiply(int e, int f){
        return e * f;
    }
    public int divide(int m, int n){
        return m / n;
    }
    public static Calculators calculator = new Calculators();
    public static void main(String[] args){
        int resultAdd = calculator.add(5,6);
        System.out.println("Addition is: " + resultAdd);
        int resultSub = calculator.sub(10,5);
        System.out.println("Subtraction is: " + resultSub);
        int resultMultiply = calculator.multiply(2, 10);
        System.out.println("Multiplication is: " + resultMultiply);
        int resultdivide = calculator.divide(6, 3);
        System.out.println("Division is: " + resultdivide);
    }
}
