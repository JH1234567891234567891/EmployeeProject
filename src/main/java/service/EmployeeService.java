package service;

import vo.EmployeeVO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeService {
    private static EmployeeService instance = new EmployeeService();

    private ArrayList<EmployeeVO> list;

    private EmployeeService(){
        list = new ArrayList<>();
        //파일 로드해서 리스트에 초기화
        loadToCSV();
    }

    public ArrayList<EmployeeVO> getList() {
        return list;
    }

    private void loadToCSV() {
        try(FileReader fr = new FileReader("employee.csv");
            BufferedReader br = new BufferedReader(fr)) {
            br.readLine();//첫번째 줄인 필드 목록 미리 읽어서 건너뛰기
            while (true){
                String str = br.readLine();
                if(str == null) break;
//                System.out.println(str);
                String[] arr = str.split(",");
                list.add(new EmployeeVO(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), arr[4]));
            }
            //사원 정보 로드 완료
            System.out.println("사원 정보 로드 완료");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static EmployeeService getInstance() {
        if(instance == null) instance = new EmployeeService();
        return instance;
    }
}
