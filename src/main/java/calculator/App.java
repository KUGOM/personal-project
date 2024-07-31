//예외처리 실패
//inquiry가 값1개밖에 못받아옴 자동적으로 remove도 확인불가
package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws BadInputException {
        //int[] results = new int[10];
        LinkedList<Double> results = new LinkedList<>();//값을 무한히 저장하기 위해 LinkedList사용
        double result = 0;
        //int index = 0; //연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언
        Scanner sc = new Scanner(System.in);
        boolean re = true;

        while (re) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int su1 = sc.nextInt();
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            System.out.print("두 번째 숫자를 입력하세요: ");
            int su2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.

            Calculator calculator = new Calculator();
            result = calculator.calculate(su1, su2, operator);

            System.out.println("결과: " + result);

            results.add(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = sc.next();
            if (remove.equals("remove")) {/* remove을 입력 받으면 반복 종료 */
                calculator.removeResults();
                //results.removeFirst();//첫번쨰 결과 삭제
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            String inquiry = sc.next();
            if (inquiry.equals("inquiry")) {
                calculator.searchResults();
                /*for (Double element : results) {
                    System.out.print(element + " ");

                }*/
                System.out.println(" ");
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.next();
            if (exit.equals("exit")) {/* exit을 입력 받으면 반복 종료 */
                re = false;
            }

            /*if(index >=9) { //index값이 9를 넘어가면
                for (int i = 0; i < results.length - 1; i++) { //인덱스 0부터 8번방까지
                    results[index] = result;//다음 인데스의 값을 현재 인덱스 자리에 넣는다
                }
                results[index] = result; //인덱스 9에 결과값을 저장
            }
            else{//인덱스가 9 미만일때
                results[index++] = result;
            }*/
        }
    }
}