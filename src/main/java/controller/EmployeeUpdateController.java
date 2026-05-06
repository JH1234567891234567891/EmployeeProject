package controller;

import exception.EmployeeException;
import service.EmployeeService;
import vo.EmployeeVO;

import java.util.Scanner;

public class EmployeeUpdateController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("사원 정보를 수정합니다.......");
        System.out.print("수정할 사원번호 : ");
        String id = sc.nextLine();

        try {
            EmployeeVO vo = EmployeeService.getInstance().searchEmployee(id.trim());

            System.out.println("수정할 사원 명 : ");
            vo.setName(sc.nextLine());
            System.out.println("수정할 사원 직급 : ");
            vo.setPosition(sc.nextLine());
            System.out.println("수정할 사원 급여 : ");
            vo.setSalary(sc.nextInt()); sc.nextLine();
            System.out.println("수정할 사원 입사일 : ");
            vo.setHireDate(sc.nextLine());
            System.out.println("사원정보 수정 성공");
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
            System.out.println("사원정보 수정에 실패하였습니다.");
        }

    }
}
