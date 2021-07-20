package ires.patterns.decorator;

interface IEmployee {
    public String getRole();
}

public class Employee implements IEmployee {

    public static void main(String[] args) {
        IEmployee e = new Employee();
        System.out.println( e.getRole() );
        e = new ProjectManager(e);
        System.out.println(e.getRole());
    }

    public String getRole(){
        return "impiegato";
    }
}

class EmployeeDecorator implements IEmployee {
    protected IEmployee instance;

    EmployeeDecorator( IEmployee e ){
        instance = e;
    }

    @Override
    public String getRole() {
        return instance.getRole();
    }
}

class ProjectManager extends EmployeeDecorator {
    public ProjectManager( IEmployee e ){
        super(e);
    }

    @Override
    public String getRole(){
        return super.getRole() + ", project manager ";
    }
}
