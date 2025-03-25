# Calculator Project

A simple calculator application built with Spring Boot that provides basic arithmetic operations through a REST API.

## Features

- Basic arithmetic operations (Addition, Subtraction, Multiplication, Division)
- RESTful API endpoints
- Input validation
- Error handling

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Spring Boot 3.x

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── calculator/
│   │           ├── controller/    # REST API controllers
│   │           ├── util/          # Utility classes
│   │           └── CalculatorApplication.java
│   └── resources/
```

## Getting Started

1. Clone the repository:
```bash
git clone <repository-url>
```

2. Navigate to the project directory:
```bash
cd calculator-project
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Calculator Operations

- **Addition**: `POST /api/calculator/add`
- **Subtraction**: `POST /api/calculator/subtract`
- **Multiplication**: `POST /api/calculator/multiply`
- **Division**: `POST /api/calculator/divide`

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

## Error Handling

The application includes proper error handling for:
- Division by zero
- Invalid input parameters
- Missing required fields

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 
