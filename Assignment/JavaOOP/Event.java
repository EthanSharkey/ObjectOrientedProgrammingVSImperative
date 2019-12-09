import java.util.Scanner;

public class Event extends EventOrTask
{
    private String location;


    public Event(String date, String startTime, String location) // Creates an Event
    {
        super(date, startTime);
        this.location = location;
    }

    public String getLocation()
    {
        return this.location;
    }


    public static String setLocation() // setter to set location
    {
        Scanner in = new Scanner(System.in); //Scan input

        System.out.print("Enter the location for your Event: ");
        String location = in.next();

        return location;
    }

    public static void eventSuccess() // A success notification for the user
    {
        String eventSuccess = "\nYour Event is now added to the Queue\n";
        System.out.println(eventSuccess);
    }

    public static void createEvent(Queue queue) // A create Event method which adds the Event to the queue
    {

        String date = setDate();
        String startTime = setStartTime();
        String location = setLocation();

        EventOrTask event = new Event(date, startTime, location);
        queue.enqueue(event);

        eventSuccess();
    }

    public String toString() // A to String method for the event class
    {
        return "(" + getDate() + ", " + getStartTime() + ", " + getLocation() + ")";
    }
}