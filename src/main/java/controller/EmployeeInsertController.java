package controller;

import java.util.Scanner;

public class EmployeeInsertController implements Controller {

    @Override
    public void execute(Scanner sc) {
        System.out.println("사원 정보를 추가합니다.......");
        System.out.print("등록할 사원번호 : ");
        String id = sc.nextLine();

        //중복체크

    }
}
