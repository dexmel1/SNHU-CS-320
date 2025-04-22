# SNHU-CS-320
 Software Test, Automation QA

 ## How can I ensure that my code, program, or software is functional and secure?

I ensure functionality by writing detailed unit tests for each class and method, just like I did with the TaskServiceTest, ContactServiceTest, and AppointmentServiceTest files. These tests help me validate both expected behaviors and edge cases. For security, I apply strict input validation—checking for null values, limiting input lengths, and enforcing correct formats—within classes like Contact, Appointment, and Task. This helps prevent bad data from entering the system and reduces the risk of unintended behavior.

## How do I interpret user needs and incorporate them into a program?

When I interpret user needs, I start by carefully reviewing the requirements and considering how the user will interact with the system. I designed the service classes, like TaskService and ContactService, to include the operations users are likely to need—such as adding, searching, and updating data. I also make sure to validate inputs and throw clear exceptions to guide correct usage. I find that using a test-driven approach helps me continually align the functionality with what users actually need.

## How do I approach designing software?

My approach to software design starts with defining the core objects or models—like Task, Contact, and Appointment. I focus on encapsulating data and validation within each model to ensure consistency. Then, I build service classes around these models to manage their lifecycle and business logic. I aim to keep things modular by separating responsibilities across different layers, which makes my code easier to test and maintain. I also prioritize writing unit tests early to catch issues before they become problems.
