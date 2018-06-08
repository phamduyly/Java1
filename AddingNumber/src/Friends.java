import java.util.ArrayList;
import java.util.Scanner;

public class Friends
{
    public static void main( String[] args )
    {
        int menu;
        menu = 0;
        int choice;
        choice = 0;


        Scanner input = new Scanner(System.in);
        ArrayList< Friends > name = new ArrayList<  >();
        ArrayList< Friends > age = new ArrayList<  >();

        System.out.println(" 1. Add a Friend ");
        System.out.println(" 2. Remove a Friend ");
        System.out.println(" 3. Display All Friends ");
        System.out.println(" 4. Exit ");
        menu = input.nextInt();

        while(menu != 4)
        {    

        switch(menu)
        {                     

        case 1:
            while(choice != 2)
            {
                System.out.println("Enter Friend's Name: ");
                name.add = input.next();
                System.out.println("Enter Friend's Age: ");
                age.add(input.nextInt());                    
                System.out.println("Enter another? 1: Yes, 2: No");
                choice = input.nextInt();
            } break;

            case 2:
                System.out.println("Enter Friend's Name to Remove: ");
                name.remove(input.next()); break;

            case 3:
                for(int i = 0; i < name.size(); i++)
                {
                System.out.println(name.get(i));
                }
                for(int k = 0; k < age.size(); k++)
                {    
                System.out.println(age.get(k));
                }break;
        }
        System.out.println(" 1. Add a Friend ");
        System.out.println(" 2. Remove a Friend ");
        System.out.println(" 3. Display All Friends ");
        System.out.println(" 4. Exit ");
        menu = input.nextInt();
        }
        System.out.println("Thank you and goodbye!");
}


public String name;
public int age;

public Friends( String friendsName, int friendsAge )
{
    this.name = friendsName;
    this.age = friendsAge;
}
public String toString()
{
    return super.toString();
}
public void setName( String friendsName )
{
    name = friendsName;
} 
public void setAge( int friendsAge )
{
    age = friendsAge;
}
public String getName()
{
    return name;
}
public int getAge()
{
    return age;
}
}   