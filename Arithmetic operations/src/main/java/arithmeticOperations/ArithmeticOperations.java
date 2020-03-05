package arithmeticOperations;

public class ArithmeticOperations {

    public double add(double firstNum, double secondNum){
        return firstNum + secondNum;
    }

    public double sub(double firstNum, double secondNum){
        return firstNum - secondNum;
    }

    public double mul(double firstNum, double secondNum){
        return firstNum * secondNum;
    }

    public double div(double firstNum, double secondNum){
        return (double) firstNum / secondNum;
    }

    public int factorial(int num){
        if(num < 0)
            return -1;
        if(num == 0)
            return 1;
        else
            return num * factorial(num - 1);
    }

    public double pow(double num, int deg){
        boolean isNegative = false;
        double result = 1;

        if(deg < 0)
            isNegative = true;


        deg = Math.abs(deg);

        for(int i = 0; i < deg; i++)
            result *= num;

        if(isNegative)
            return 1 / result;
        return result;
    }

    public double lg(int num) {
        return Math.log10(num);
    }
}
