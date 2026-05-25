public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);//create scanner for input
    Registration registration = new Registration();
   registration.Register();


    System.out.println("1. Register");
    System.out.println("2. Login");
    int choice = scanner.nextInt();// Get user's choice
    scanner.nextLine();
    if(choice ==1 ) {
        registration.Register();//call register method
    } else if(choice==2 );
        System.out.println("Enter username");
        String username = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
    Registration registration1 = new Registration();

        System.out.println(Login.loginUser(username, password));//attempt login
    }

