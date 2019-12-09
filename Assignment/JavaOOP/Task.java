import java.util.*;

public class Task extends EventOrTask
{

    private String duration;
    private ArrayList<String> people;


    public Task(String date, String startTime, String duration, ArrayList<String> people) // Creates a Task object
    {
        super(date, startTime);
        this.duration = duration;
        this.people = people;
    }

    public String getDuration()
    {
        return this.duration;
    }

    public ArrayList<String> getPeople()
    {
        return this.people;
    }


    public static String setDuration() // A setter for the duration
    {
        Scanner in = new Scanner(System.in); // Scan input

        System.out.print("Enter a duration (in the format 'N hours : M minutes') for your Task: ");
        String duration = in.nextLine();

        return duration;
    }

    public static ArrayList<String> addPeople() // A method to add people that are taking part in the task to the people ArrayList
    {
        Scanner in = new Scanner(System.in);
        ArrayList<String> people = new ArrayList<String>();

        System.out.println("Enter a list of people involved in the Task, one person per line!");
        System.out.println("When finished type 'finished' on the last line!");

        String peeps = in.next();
        while (!(peeps.equals("finished")))
        {
            people.add(peeps);

            peeps = in.next();
        }

        return people;
    }

    public static void taskSuccess() // A prompt to signify a task has been successfully added
    {
        String taskSuccess = "\nYour Task is now added to the Queue\n";
        System.out.println(taskSuccess);
    }

    public static void createTask(Queue queue) // Create a Task and adds it to the Queue
    {

        String date = setDate();
        String startTime = setStartTime();
        String duration = setDuration();
        ArrayList<String> people = addPeople();

        EventOrTask task = new Task(date, startTime, duration, people);
        queue.enqueue(task);
        
        taskSuccess();
 
    }


    public String toString() // A toString method for the Task class
    {
        String output = "(" + getDate() + ", " + getStartTime() + ", " + getDuration() + ", [";

        int i = 0;
        for (i = 0; i < getPeople().size(); i ++)
        {
            if (!(i == getPeople().size() - 1))
                output = output + getPeople().get(i) + ", ";
            else
                output += getPeople().get(i);
        }
        
        return output + "])";
    }
}