import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Queue
{
    private ArrayList<EventOrTask> list;
    String fileName = "QueueToDoListJava.txt"; // Name of file thats created

    public Queue() // creates a queue in the form of an ArrayList
    {
        this.list = new ArrayList<EventOrTask>();
    }

    public ArrayList<EventOrTask> getQueue()
    {
        return this.list;
    }

    public void enqueue(EventOrTask item) // Adds an Event or Task to the Queue
    {
        getQueue().add(item);
    }

    public String dequeue() // Removes first item from queue and returns it
    {
        try
        {
            EventOrTask begin = getQueue().remove(0);
            String statement = "The first item in the queue is now removed";
            return "\n" + begin.toString() + "\n\n" + statement + "\n";
        }
        catch (Exception e)
        {
            return "\nThere's no items to remove!\n";
        }
    }

    public Boolean isEmpty() // Checks if queue is empty
    {
        return (getQueue().size() == 0);
    }

    public String view() // Prints the queue on screen
    {
        if (isEmpty())
            return "\nToDoList is Empty\n";
        else
            return "\n" + toString() + "\n";
    }

    public String peek() // returns first item in queue but doesn't remove it
    {
        try
        {
            EventOrTask item = getQueue().get(0);
            return "\n" + item.toString() + "\n";
        }
        catch (Exception e)
        {
            return "\nThere are no elements in your To Do List to peek at!\n";
        }
    }

    public String element(int num) // returns item at specified index, included as it is a regular queue method however is not used in the test file.
    {
        try
        {
            EventOrTask item = getQueue().get(num);
            return item.toString();
        }
        catch (Exception e)
        {
            return "\nThis element does not contain an item!\n";
        }
    }

    public int size()
    {
        return getQueue().size(); // returns size of queue
    }

    public void writeToFile()
    {
        try
        {
            File file = new File(fileName); //Creating file if not already there
            FileWriter writer = new FileWriter(file); // Writer to write into file

            for (EventOrTask item : getQueue())
            {
                writer.write(item.toString() + "\n"); // Write Event or Task to file, one per line 
            }
            
            
            writer.close(); // closing file
    
        }
        catch (IOException e)
        {
    
        }
    }

    public void readFromFile()
    {
        try
        {   
            File file = new File(fileName); // Obtaining file
            FileReader reader = new FileReader(file); // Reading file
            BufferedReader bReader = new BufferedReader(reader); // Reading file
            
            String date; // Initialising variables
            String time;
            String line;
    
            while ((line = bReader.readLine()) != null) // While line != nothing, continue
            {
                int length = line.length(); // Get length of line
                String newLine = line.substring(1, length - 1); // Get inputs without opening and closing parentheses

                if (newLine.contains("[")) // This signifies it is a task
                {
                    ArrayList<String> people = new ArrayList<String>(); // Create an arrayList for people participating in task
                    String [] task = newLine.split(","); // Split the line to get inputs to create task
                    int arrayLength = task.length; // Get length of task

                    date = task[0]; // Get date input
                    time = task[1].replaceAll("\\s+", ""); // Get time input, also removes whitespace for better formatting with replaceAll
                    String duration = task[2].replaceAll("\\s+", ""); // Get duration input
                    String person1 = task[3].replaceAll("\\[", ""); // Gets first person and removes opening square bracket for formatting.
                    String lastPerson = task[arrayLength - 1].replaceAll("\\]", "").replaceAll("\\s+", ""); // Gets last person and removes closing bracket for formatting.

                    people.add(person1); // Add first person to ArrayList for the task
                    for (int i = 4; i < arrayLength - 1; i ++) // A loop to add people between first and last to the ArrayList for the task
                        people.add(task[i]); 
                    people.add(lastPerson); // Add last person to the ArrayList for the task

                    EventOrTask oldTask = new Task(date, time, duration, people); // Create a Task object 
                    enqueue(oldTask); // Add it to the queue
                }
                else // Signifies it is an event
                {
                    String [] event = newLine.split(","); // Splits the line to get inputs for the event

                    date = event[0]; // Gets date input
                    time = event[1].replaceAll("\\s+", ""); // Gets time input
                    String location = event[2].replaceAll("\\s+", ""); // Gets location input

                    EventOrTask oldEvent = new Event(date, time, location); // Create an event Object
                    enqueue(oldEvent); // Add it to the queue
                }
            }
            reader.close(); // Closes the file and stops reading from it
            bReader.close();
        }
        catch (IOException e)
        {

        }
    }

    public String toString() // A toString method for the queue
    {

        String output = "(";
        
        int i = 0;
        for (i = 0; i < getQueue().size(); i ++)
        {
            if (!(i == getQueue().size() - 1))
                output = output + getQueue().get(i) + ", ";
            else
                output += getQueue().get(i);
        }
        return output + ")";
    }
}