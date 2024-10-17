# Goflox
# Gloflox Studio Management Application

This is a Spring Boot-based API application that allows studio owners to manage classes and members to book those classes. The application manages classes, classSlots, and member bookings while maintaining real-time availability of slots.

## Features

- Create new classes with capacity and schedule.
- Manage class slots for each date of a class.
- Book a class for a specific date.
- Track available class slots in real-time based on bookings.

## Technologies Used

- **Java** (Spring Boot Framework)
- **H2** (In-Memory Database)
- **JPA** (Java Persistence API for ORM)
- **Maven** (Dependency Management)

## Requirements

To run this application, you need:

- **Java 17** or above.
- **Maven** installed.



## API Endpoints

### 1. **Create Class**
   Create a new class for the studio.
   
   - **URL**: `/classes`
   - **Method**: `POST`
   - **Payload**:
     ```json
     {
       "name": "Flute Music Session",
       "startDate": "2024-12-01",
       "endDate": "2024-12-20",
       "capacity": 60
     }
     ```

   - **Response**: 
     - `201 Created` on success.
     - UNDERCONSTRUCTION

### 2. **Book a Class**
   Book a slot for a specific date in a class.
   
   - **URL**: `/bookings`
   - **Method**: `POST`
   - **Payload**:
     ```json
     {
       "name": "Sai Rahul",
       "bookingDate": "2024-12-01",
       "classId": 1
     }
     ```

   - **Response**: 
     - `201 CREATED` on success.
     - `409 CONFLICT` if the class or slots are unavailable.

## Managing Class Slots

Each class has associated slots based on the class capacity and schedule. Class slots are automatically created when a new class is added, for each day in the range between the `startDate` and `endDate`. Available slots are updated dynamically when a booking is made.


## Actuator Endpoints

This application includes Spring Boot Actuator for monitoring:

- **Health Check**: `/actuator/health`
- **Info**: `/actuator/info`
```properties
management.endpoints.web.exposure.include=*
