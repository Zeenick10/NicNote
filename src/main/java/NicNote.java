import java.util.Scanner;

public class NicNote {

    private String name,email,password,check,checkNote,addNew,newValue;

    boolean flag = false;

    NicNote(){
        scanner();
    }


    public static void main(String[] args) {
        NicNote assignment = new NicNote();
    }

    private void scanner(){
        Scanner sc = new Scanner(System.in);
        loginOrRegister(sc);
    }

    private void loginOrRegister(Scanner sc){
        System.out.println("Do you want to login or register? (l,r)");
        check = sc.nextLine();
        if(("l").equalsIgnoreCase(check)){
            goToRegister(sc);
        } else if (("r").equalsIgnoreCase(check)) {
            register(sc);
        }else{
            outputCommandWrong();
        }
    }

    private void goToRegister(Scanner sc){
        System.out.println("You don't have already account!!!\nDo you want to signup account?(y,n)");
        check = sc.nextLine();
        if(("y").equalsIgnoreCase(check)){
            register(sc);
        } else if (("n").equalsIgnoreCase(check)) {
            outputProcessEnd();
        }else {
            outputCommandWrong();
        }
    }

    private void register(Scanner sc){
        Register obj[] = new Register[1];
        System.out.print("Name : ");
        name = sc.nextLine();
        System.out.print("Email : ");
        email = sc.nextLine();
        System.out.print("Password : ");
        password = sc.nextLine();
        obj[0] = new Register(name,email,password);
        login(obj,sc);
    }

    private void outputProcessEnd(){
        System.out.println("Process End...");
    }

    private void outputCommandWrong(){
        System.out.println("Command Wrong!!!");
    }

    private void taskLists(Scanner sc){
            System.out.println("\nTaskLists\n-----------");
            String taskList[] = {"Meeting","Chill With Friend","Date","Hand Out"};

            int arrLength = taskList.length;
            for(int x=0;x<arrLength;x++){
                System.out.println(  (x+1)+"." + taskList[x]);
            }

            String newTaskList[] = new String[arrLength+1];

            boolean flag = false;
            while (true){
                System.out.println("\nDo you want to add new notes? (y,n)");
                checkNote = sc.nextLine();
                if(("y").equalsIgnoreCase(checkNote)){
                    System.out.println("\nAdd New Note\n---------------");
                    addNew = sc.nextLine();
                    newValue =addNew;

                    for(int j=0;j<arrLength;j++){
                        newTaskList[j] = taskList[j];
                    }

                    newTaskList[arrLength] = newValue;

                    System.out.println("\nTaskLists\n-------------");
                    for(int j=0;j<newTaskList.length;j++){
                        System.out.println((j+1)+"."+newTaskList[j]);
                    }
                } else if (("n").equalsIgnoreCase(checkNote)) {
                    outputProcessEnd();
                    flag = true;
                }else{
                    outputCommandWrong();
                    flag = true;
                }

                if(flag!=false){
                    break;
                }
            }
    }

    private void login(Register obj[],Scanner sc){
        while (true){
            System.out.println("\n-----Login Form-----");
            System.out.print("\nEmail : ");
            email = sc.nextLine();
            System.out.print("Password : ");
            password = sc.nextLine();
            for(int i=0;i<obj.length;i++){
                if(obj[i].email.equals(email) && obj[i].password.equals(password)){
                    flag =true;
                    taskLists(sc);
                }else{
                    System.out.println("\nInvalid Email and Password!!!!\nPlease, Enter Valid Email and Password...");
                }
            }
            if(flag!=false){
                break;
            }
        }

    }

}
class Register{
    String name,email,password;

    Register(String n,String e,String p){
        name = n;
        email = e;
        password = p;
    }
}
