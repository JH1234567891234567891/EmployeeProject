package controller;

public class HandlerMapping {
    private static HandlerMapping instance = new HandlerMapping();

    private HandlerMapping() {}

    public static HandlerMapping getInstance() {
        if(instance == null) instance = new HandlerMapping();
        return instance;
    }

    public Controller createController(int no){
        Controller controller = null;
        switch (no){
            case 1 -> controller = new EmployeeInsertController();
            case 2 -> controller = new EmployeeDeleteController();
            case 3 -> controller = new EmployeeUpdateController();
            case 4 -> controller = new EmployeeSearchForNameController();
            case 5 -> controller = new PrintAllController();
        }
        return controller;
    }
}
