# Project Name

The exam registration service is a critical component of a Learning Management System. We had developed a simplified version of the exam registration service that meets the specified features as below.

---

## Features

- Student can register themself.
- Student can enroll in a subject.
- Students can register for the exam only after enrolling in the corresponding subject

---

## Requirements

- JDK 17 or higher
- Gradle 7.x or higher
- Database (MYSQL 8.0)
- Postman for local testing

---

## Installation

- CLone the repository from gitHub
- MySQL configuration is done in application.properties file, modify the configuration as per you system specifications.
- ./gradlew build and run 
- Test using the postman collection -> [text](LearningNavigator.postman_collection.json)
-  RUun test cases in below sequence & modify path parameter as required
    1. Create Students
    2. Create subjects
    3. Enroll student in subject
    4. Create Exam
    5. Register student for exam


### Prerequisites

1. Ensure you have JDK 17 or higher installed on your machine.
2. Make sure Gradle is installed or use the Gradle wrapper provided.

### Clone the repository

git clone https://github.com/Adityaingale176/LEARNING_NAVIGATOR