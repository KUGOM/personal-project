package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private Queue<Double> results;//값을 무한히 저장하기 위해 LinkedList사용
    static double radius;
    final static double PI = 3.14159265358979323846;

    public Calculator(){
        this.results = new LinkedList<>();
    }

    public double calculateCircleArea(double radius){
        this.radius = radius;
        return PI * radius * radius;

    }

    public double calculate(int su1, int su2, char operator) throws BadInputException {
        double result = 0;

        switch (operator) {
            case '+':
                result = su1 + su2;
                break;
            case '-':
                result = su1 - su2;
                break;
            case '*':
                result = su1 * su2;
                break;
            case '/':
                if (su2 != 0) {
                    result = su1 / su2;
                } else {
                    throw new BadInputException("0이 아닌 정수");
                }
                break;
        }
        results.add(result);
        return result;
    }

    public Queue<Double> getResults() {
        return results;
    }

    public void setResults(double result) {
        this.results.add(result);
    }

    public void removeResults(){
        System.out.println("가장 먼저 저장된 "+ this.results.peek() +" 를 삭제합니다.");
        //Queue.peek() - 삭제와 동시에 반환
    }

    public void searchResults() {
        System.out.println("저장된 연산결과를 불러옵니다.");
        Queue<Double> results = this.getResults();
        for (double num : results) {
            System.out.println(num);
        }
    }
}
