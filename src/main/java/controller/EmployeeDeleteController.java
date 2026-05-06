package controller;

import exception.EmployeeException;
import service.EmployeeService;

import java.util.Scanner;

public class EmployeeDeleteController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("사원 정보를 추가합니다.......");
        System.out.print("등록할 사원번호 : ");
        String id = sc.nextLine();

        try {
            EmployeeService.getInstance().deleteEmployee(id);
            System.out.println("사원정보 삭제 완료");
        } catch (EmployeeException e){
            System.out.println(e.getMessage());
        }
    }
}
