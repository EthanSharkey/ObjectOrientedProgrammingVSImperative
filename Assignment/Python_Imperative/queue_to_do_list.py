queue = "" # Creates a queue using a string

# Variables used throughout the loop
start = "If you would like to create an event or a task, type either 'event' or 'task'!\n"
start += "If you would like to view your current Queue, enter 'view'\nIf you wish to remove the top item from your Queue, enter 'remove'\n"
start += "If you want to peek at the first item in your Queue, enter 'peek'\n";
end = "If you wish to exit, type 'exit', otherwise press any letter\n"
exit = "exit"
strevent = "event"
strtask = "task"
view = "view"
remove = "remove"
peek = "peek"


inp = input(end) # First input

while inp != exit:    # While input != exit, continue
    inp = input(start) # Input that is used throughout the loop for the if statements

    if inp == strevent: # If event entered, create event
        date = input("Enter the date (in the format 'DD/MM/YYYY') in which your Event will take place: ") # Input for date

        start_time = input("Enter the start time (in the format 'HH:MM') for your Event: ") # Input for time

        location = input("Enter the location for your Event: ") # Input for location

        queue = queue + "(" + date + ", " + start_time +", " + location + "), "# Adding the Event to the queue
        print("\nYour Event has been added to the Queue!") # A prompt for the user to see that it has been successfully added

    elif inp == strtask: # If task entered, create task
        date = input("Enter the date (in the format 'DD/MM/YYYY') in which your Task will take place: ") # Input for date

        start_time = input("Enter the start time (in the format 'HH:MM') for your Task: ") # Input for time

        duration = input("Enter the duration (in the format 'N hours : M minutes') of your Task: ") # Input for duration

        people = input("Enter a list of people (in the format 'person1, person2....') involved in the Task!\n") # input for group of people taking part in task

        queue = queue + "(" + date + ", " + start_time +", " + duration + ",  [" + people + "]), "# Adding the Task to the queue
        print("\nYour Task has been added to the Queue!") # A prompt for the user to see that it has been successfully added

    elif inp == view: # If view entered, Print the queue
        print("\n(" + queue + ")")
    
    elif inp == remove: # If remove entered, remove first item from queue
        try:
            i = 0
            while queue[i] != ")": # When it finds a closing parantheses, stop - signifying end of the first item in the queue
                i += 1

            print("Removed: " + queue[0:i + 3]) # prints what has been removed
            
            strin = queue[i + 3::] 
            queue = strin
            
            print("\n(" + queue + ")\n") # Prints what is remaining in the queue
        
        except IndexError: # An exception for if the queue is empty
            print("")

    elif inp == peek: # If peek entered, reveal first item of queue without removing it
        try:
            i = 0
            while queue[i] != ")": # When it finds a closing parantheses, stop - signifying end of the first item in the queue
                i += 1

            print("\n" + queue[0: i + 1]) # Prints first item of queue
        
        except IndexError: # An exception for if the queue is empty
            print("")

    print("\n" + end + "\n") # Prints end prompt


