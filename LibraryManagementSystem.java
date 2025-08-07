import java.util.*;

public class LibraryManagementSystem {
    
    private static Scanner input = new Scanner(System.in);
    private static Map<String,Book>  books_list = new HashMap<>();
    private static Map<String,User>  users_list = new HashMap<>();
    private static Map<String,List<String>>  borrowed_list = new HashMap<>();

    private static void newUserRegister()
    {
        System.out.println("Enter User Id (Note: it should be of 6 - 10 characters(it may include any numbers,alphbets,special characters)):");
        String User_id = input.nextLine();
        if(User_id.length() < 6 || User_id.length() > 10)
        {
            System.out.println("Enter Valid User_id... It should Satisfy the above mentioned condition");
            return;
        }
        System.out.print("Enter User Name: ");
        String User_name = input.nextLine();
        System.out.print("Enter User Mobile Number: ");
        long User_Phno = input.nextLong();
        input.nextLine();
        if(users_list.containsKey(User_id))
        {
            System.out.println("User Id already exists...");
            return;
        }

        User user = new User(User_id, User_name, User_Phno);
        users_list.put(User_id, user);
        System.out.println("Successfully Registered.....");

    }

    private static void viewAllBooks()
    {
        if(books_list.size() == 0)
        {
            System.out.println("No Books Exists....");
            return ;
        }
        int cnt = 1;
        for(Book book : books_list.values())
        {
            System.out.println(cnt+". "+ book);
            cnt++;
        }
    }

    private static void addNewBook()
    {
        System.out.println("Enter New Book Id: ");
        String Book_id = input.nextLine();
        if(books_list.containsKey(Book_id))
        {
            System.out.println("Book with this Id already Exists....");
            return ;
        }
        System.out.println("Enter New Book Name: ");
        String Book_name = input.nextLine();
        Book book = new Book(Book_id, Book_name);
        books_list.put(Book_id, book);
        System.out.println("Book with Id: "+Book_id+" is Added....");
    }

    private static void borrowBook()
    {
        System.out.println("Enter User Id: ");
        String User_id = input.nextLine();
        if(!users_list.containsKey(User_id))
        {
            System.out.println("Invalid User Id: User Id doesnot exits......");
            System.out.println("To borrow enter valid Registered User Id, if not there plese do register first By choosing Option 1 from below MENU.");
            return;
        }
        System.out.println("Enter Book Id: ");
        String Book_id = input.nextLine();
        String Book_name = books_list.get(Book_id).getNameName();
        if(!books_list.get(Book_id).getBookStatus())
        {
            System.out.println("Sorry !!! Book Id: "+Book_id+" not available.....");
        }
        Book book = new Book(Book_id, Book_name);
        book.setBookStatus(false);
        books_list.put(Book_id, book);
        List<String> bl = new ArrayList<>();
        if(borrowed_list.containsKey(User_id))
        {
            bl = borrowed_list.get(User_id);
        }
        bl.add(Book_id);
        borrowed_list.put(User_id, bl);
        System.out.println("Done!!! Please Return the Book Safely without Damage to avoid inconvenience");
    }

    private static void returnBook()
    {
        System.out.println("Enter User Id: ");
        String User_id = input.nextLine();
        System.out.println("Enter Book Id: ");
        String Book_id = input.nextLine();
        if(!borrowed_list.containsKey(User_id))
        {
            System.out.println("Invalid User Id : This User Id not Borrowed any Book.....");
            return;
        }
        else{
            if(!borrowed_list.get(User_id).contains(Book_id))
            {
                System.out.println("User Id: "+User_id+" not borrowed Book Id:"+Book_id);
            }
            else{
                borrowed_list.get(User_id).remove(Book_id);
                books_list.get(Book_id).setBookStatus(true);
                System.out.println("Book Successfully Returned....");
            }
        }
        

        

    }


    public static void main(String args[])
    {
        while(true)
        {
            System.out.println("=============== Library Manangement System =====================");
            System.out.println("****** MENU *******");
            System.out.println("1. New User Register");
            System.out.println("2. View All Books");
            System.out.println("3. Add New Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit Application");
            System.out.println("================================================================");
            System.out.println("Enter Your Choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch(choice)
            {
                case 1: System.out.println("##### Register #####");
                newUserRegister();
                break;
                case 2: System.out.println("##### List Of Books #####");
                viewAllBooks();
                break;
                case 3: System.out.println(" Fill Below Details");
                addNewBook();
                break;
                case 4: System.out.println("Fill Below Details");
                borrowBook();
                break;
                case 5: System.out.println("Fill Below Details");
                returnBook();
                break;
                case 6: System.exit(0);
                System.out.println("!!!! you are Successfully exited from Application");
                break;
                default : System.out.println("!!! Enter Right Choice !!!");
                
            }
        }

    }
}

