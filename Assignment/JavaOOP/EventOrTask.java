import java.util.Scanner;

public class EventOrTask
{
    private String date;
    private String startTime;

    public EventOrTask(String date, String startTime) // Creates an EventOrTask object, this is used so an event and a task can be put into the same list
    {
    	this.date = date;
    	this.startTime = startTime;
    }

    public String getDate()
    {
        return this.date;
    }

    public String getStartTime()
    {
        return this.startTime;
    }


    public static String setDate() // A setter to set the date 
    {
        Scanner in = new Scanner(System.in); // Scan input

        System.out.print("\nEnter a date (in the format 'DD/MM/YYYY') for your Event/Task to take place: ");
        String date = in.next();

        return date;  
    }


    public static String setStartTime() // A setter to set the Start Time
    {
        Scanner in = new Scanner(System.in); // Scan input

        System.out.print("Enter a start time (in the format 'HH:MM') for your Event/Task: ");
        String startTime = in.next();

        return startTime;

    }

}