# Calculator Project

A robust calculator API built with Spring Boot that provides basic arithmetic operations. This project demonstrates RESTful API development using Spring Boot and follows best practices for application development.

## 🚀 Features

- Basic arithmetic operations:
  - Addition
  - Subtraction
  - Multiplication
  - Division
- RESTful API endpoints with proper HTTP methods
- Input validation and error handling

## 🛠️ Tech Stack

- **Framework:** Spring Boot 2.7.0
- **Language:** Java 11
- **Build Tool:** Maven 3.6+

## 📋 Prerequisites

Before you begin, ensure you have the following installed:
- JDK 11 or higher
- Maven 3.6 or higher
- Git

## 🔧 Installation & Setup

1. **Clone the repository:**
```bash
git clone <repository-url>
cd calculator-project
```

2. **Build the project:**
```bash
mvn clean install
```

3. **Run the application:**
```bash
mvn spring-boot:run
```

4. **Using Docker:**
```bash
docker build -t calculator-api .
docker run -p 8080:8080 calculator-api
```

## 🌐 API Documentation

### Available Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/calculate/add` | Add two numbers |
| POST | `/api/calculate/subtract` | Subtract two numbers |
| POST | `/api/calculate/multiply` | Multiply two numbers |
| POST | `/api/calculate/divide` | Divide two numbers |

### Request Format
```json
{
    "num1": 10,
    "num2": 5
}
```

### Response Format
```json
{
    "result": 15,
    "operation": "add",
    "message": "Operation successful"
}
```

## 💻 Example Usage

### Using CURL

```bash
# Addition
curl -X POST http://localhost:8080/api/calculate/add \
-H "Content-Type: application/json" \
-d '{"num1": 10, "num2": 5}'

# Subtraction
curl -X POST http://localhost:8080/api/calculate/subtract \
-H "Content-Type: application/json" \
-d '{"num1": 10, "num2": 5}'

# Multiplication
curl -X POST http://localhost:8080/api/calculate/multiply \
-H "Content-Type: application/json" \
-d '{"num1": 10, "num2": 5}'

# Division
curl -X POST http://localhost:8080/api/calculate/divide \
-H "Content-Type: application/json" \
-d '{"num1": 10, "num2": 5}'
```

### Using Postman
1. Import the provided Postman collection
2. Set the base URL to `http://localhost:8080`
3. Use the pre-configured requests for each operation

## 🧪 Testing

### Running Tests
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=CalculatorControllerTest

# Run with coverage
mvn test jacoco:report
```

## 📁 Project Structure

```
calculator-project/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/calculator/
│       │       ├── controller/
│       │       ├── service/
│       │       ├── model/
│       │       └── CalculatorApplication.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

## 🔒 Security

- Input validation to prevent invalid operations
- Error handling for division by zero
- Rate limiting (configurable)
- Request/Response logging

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- Kanhaiya Lal - Initial Spring-Boot Project

## 🙏 Acknowledgments

- Spring Boot team for the amazing framework
- All contributors who have helped shape this project 
