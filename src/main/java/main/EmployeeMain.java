package main;

import controller.Controller;
import controller.HandlerMapping;
import service.EmployeeService;

import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true){
                System.out.println("|------------ 사원 관리 프로그램 ------------|");
                System.out.println("| 사원 정보를 어떻게 관리하시겠습니까?          |");
                System.out.println("| 1. 등록 | 2. 삭제 | 3. 수정 | 4. 검색(사번) |");
                System.out.println("| 5. 전체 사원 조회  |    0. 프로그램 종료     |");
                System.out.print("| 원하시는 번호를 입력하세요 : ");


                int no = sc.nextInt(); sc.nextLine();

                Controller controller = HandlerMapping.getInstance().createController(no);
                if(controller !=null){
                    controller.execute(sc);
                }

                if(no==0) {System.out.println("프로그램을 종료합니다."); break;}
            }

        } finally {
            EmployeeService.getInstance().exportToCSV();
        }

    }
}
