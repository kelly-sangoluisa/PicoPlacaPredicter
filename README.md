# Pico y Placa Predictor

This is a Java console application that predicts whether a vehicle **can be on the road** at a given **date and time** based on Ecuador's "Pico y Placa" traffic restriction system.

## ✨ Features
- Validates license plate format (3 letters followed by 3 or 4 digits).
- Parses user-provided date and time.
- Applies local traffic rules based on:
  - Day of the week
  - Last digit of the license plate
  - Restricted time schedules
- Displays a clear result message to the user.

## 🧠 How It Works

| Day        | Restricted Plate Endings |
|------------|-------------------------|
| Monday     | 1, 2                    |
| Tuesday    | 3, 4                    |
| Wednesday  | 5, 6                    |
| Thursday   | 7, 8                    |
| Friday     | 9, 0                    |
| Saturday   | No restrictions         |
| Sunday     | No restrictions         |

**Restricted Hours:**
- Morning: 06:00 - 09:30
- Evening: 16:00 - 20:00

> **Note:** Saturday and Sunday are free days; there are no driving restrictions.

## 🚀 How to Run

### Prerequisites

- Java 8 or higher
- Maven (recommended for building and running tests)
- Any IDE (e.g., IntelliJ IDEA, VS Code)

### Steps

1. **Clone this repository:**

    ```bash
    git clone https://github.com/kelly-sangoluisa/PicoPlacaPredicter.git
    cd PicoPlacaPredicter/picoplatapredictor
    ```

2. **Build the project (with Maven):**

    ```bash
    mvn clean install
    ```

3. **Run the application:**

    Using Maven:

    ```bash
    mvn exec:java "-Dexec.mainClass=com.app.App"
    ```

    Or compile and run manually:

    ```bash
    javac -d target/classes src/main/java/com/app/*.java src/main/java/com/app/business/*.java src/main/java/com/app/input/*.java src/main/java/com/app/output/*.java
    
    java -cp target/classes com.app.App
    ```

## 🧪 Running Tests

This project uses **JUnit 5** for unit testing and includes unit tests for the main components to ensure reliability and correctness. Below is a summary of the test coverage:

### Business Logic
- **PredictorTest**:  
  - Tests the prediction logic for various scenarios, including valid and invalid dates/times, and different plate formats.
- **RuleSetTest**:  
  - Verifies rule addition, restriction checks, and correct handling of multiple rules.
- **RuleTest**:  
  - Checks restriction logic for days, digits, and schedules, including edge cases.
- **ScheduleTest**:  
  - Ensures time interval checks work for start, end, and out-of-range times.

### Input Validation
- **DateInputTest**:  
  - Validates correct and incorrect date parsing, including invalid formats and non-existent dates.
- **TimeInputTest**:  
  - Validates correct and incorrect time parsing, including invalid formats and out-of-range times.
- **LicensePlateTest**:  
  - Tests plate format validation and extraction of the last digit, including edge cases with non-digit endings.

### Output
- **ResultFormatterTest**
  - Verifies that the result messages are correct for both allowed and restricted scenarios.


To run all tests:
```bash
mvn test
 ```

## 📝 Parameters & Examples

### Input Parameters

When you run the application, you will be prompted to enter:

- **Date:** The date you want to check, in the format `dd-MM-yyyy`  
  _Example:_ `15-06-2024`
- **Time:** The time you want to check, in the format `HH:mm` (24-hour format)  
  _Example:_ `08:30`
- **License Plate:** The vehicle's license plate (3 letters and 3 or 4 digits, with or without a dash)  
  _Examples:_ `ABC-1234`, `XYZ123`

### Example Usage

```
Enter the date (dd-MM-yyyy): 12-06-2024
Enter the time (HH:mm): 08:30
Enter the license plate (e.g., ABC-1234): ABC-1234
You are NOT allowed to drive because your license plate ends with 4 and today is Wednesday. Driving is restricted at 08:30 due to 'Pico y Placa' regulations.
```

```
Enter the date (dd-MM-yyyy): 15-06-2024
Enter the time (HH:mm): 10:00
Enter the license plate (e.g., ABC-1234): XYZ-5678
You are allowed to drive at this time.
```

## 📁 Folder Structure

```
PicoPlacaPredicter/
│
├── .gitignore
├── README.md
└── picoplatapredictor/
    ├── pom.xml
    └── src/
        ├── main/
        │   └── java/
        │        └── com/
        │           └── app/
        │               ├── App.java
        │               ├── business/
        │               │   ├── Predictor.java
        │               │   ├── Rule.java
        │               │   ├── RuleSet.java
        │               │   └── Schedule.java
        │               ├── diagrams/
        │               │   └── classDiagram.png
        │               ├── input/
        │               │   ├── DateInput.java
        │               │   ├── LicensePlate.java
        │               │   └── TimeInput.java
        │               └── output/
        │                   └── ResultFormatter.java
        └── test/
            └── java/
                └── com/
                    └── app/
                        ├── business/
                        │   ├── PredictorTest.java
                        │   ├── RuleSetTest.java
                        │   ├── RuleTest.java
                        │   └── ScheduleTest.java
                        ├── input/
                        │   ├── DateInputTest.java
                        │   ├── LicensePlateTest.java
                        │   └── TimeInputTest.java
                        └── output/
                            └── ResultFormatterTest.java
```