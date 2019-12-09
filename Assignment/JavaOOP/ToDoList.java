import java.util.Scanner;

public class ToDoList
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in); // Scanner set up

        Queue queue = new Queue(); // Creates an instance of queue

        queue.readFromFile(); // Reads previous queues if they exist

        // Variables used throughout the loop
        String start = "If you would like to create an event or a task, type either 'Event' or 'Task'!\n"; 
        start = start + "If you would like to view your current Queue, enter 'View'\nIf you wish to remove the top item from your Queue, enter 'Remove'\n";
        start = start + "If you want to peek at the first item in your Queue, enter 'Peek'";
        String end = "If you wish to exit, type exit, otherwise press any letter";
        String exit = "exit";
        String strEvent = "event";
        String strTask = "task";
        String view = "view";
        String remove = "remove";
        String peek = "peek";

        System.out.println(end);

        while (!(in.next().equals(exit))) // While input != exit, continue
        {
            System.out.println(start);

            String input = in.next(); // Take in input
            input = input.toLowerCase(); // Convert it to lower case

            if (input.equals(strEvent)) // Creates Event
                Event.createEvent(queue);

            else if (input.equals(strTask)) // Creates Task
                Task.createTask(queue);

            else if (input.equals(view)) // Views the current Queue
                System.out.println(queue.view());

            else if (input.equals(remove)) // Removes first item from Queue
                System.out.println(queue.dequeue());
    
            else if (input.equals(peek)) // Looks at first item in Queue
                System.out.println(queue.peek());

            else if (input.equals(exit)) // Exits loop
                break;

            System.out.println(end);
        }
        queue.writeToFile(); // Writes existing Queue to a file
    }
}