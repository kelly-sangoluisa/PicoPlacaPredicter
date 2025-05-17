# Pico y Placa Predictor

This is a Java console application that predicts whether a vehicle **can be on the road** at a given **date and time** based on Ecuador's "Pico y Placa" traffic restriction system.

## 📌 Features

- Validates license plate format (3 letters followed by 3 or 4 digits).
- Parses user-provided date and time.
- Applies local traffic rules based on:
  - Day of the week
  - Last digit of the license plate
  - Restricted time schedules
- Displays a clear result message to the user.

## 🧠 How It Works

The app uses a set of pre-defined rules:
- **Monday**: Plates ending in 1 and 2  
- **Tuesday**: Plates ending in 3 and 4  
- **Wednesday**: Plates ending in 5 and 6  
- **Thursday**: Plates ending in 7 and 8  
- **Friday**: Plates ending in 9 and 0  
- **Restricted Hours**:  
  - Morning: 06:00 - 09:30  
  - Evening: 16:00 - 20:00  

## 🚀 How to Run

### Prerequisites

- Java 8 or higher
- Any IDE (e.g., IntelliJ IDEA, VS Code) or terminal with `javac` and `java`

### Steps

1. Clone this repository:

```bash
git clone https://github.com/your-username/pico-y-placa-predictor.git
cd pico-y-placa-predictor
# PicoPlacaPredicter
