# Rest Assured Practice Project

This repository is a comprehensive collection of Rest Assured examples and practices to master API testing. It covers essential topics such as serialization, deserialization, authentication, and JSON/XML handling, along with advanced scenarios like OAuth authentication and request/response specifications.

---

## **Project Structure**

### **1. Modules**
- **Complex JSON Handling**:
  - Models for nested and complex JSON structures.
  - Examples using **Lombok** annotations for cleaner code.
- **Dynamic Data Generation**:
  - Integration with the **Faker** library to generate random test data dynamically.
- **POJO Creation**:
  - Examples of POJO (Plain Old Java Object) classes for both JSON and XML payloads.
- **Authentication APIs**:
  - Covered basic, preemptive, digest authentication, OAuth 1.0/2.0, and token examples.

---

## **Topics Covered**

### **1. Rest Assured Basics**
- Introduction to Rest Assured.
- Setting up a Maven project.
- Making basic GET API calls using:
  - BDD (Behavior-Driven Development).
  - Non-BDD style.
- Using **Hamcrest Matchers** for validation.

### **2. Advanced GET Operations**
- Handling query and path parameters.
- Extracting response values using:
  - `JsonPath` methods (`getInt`, `getString`, `getList`).
  - `XMLPath` for XML payloads.

### **3. POST, PUT, DELETE Calls**
- Sending requests with:
  - JSON payloads as strings.
  - JSON files.
- Validating the full API workflow (e.g., POST -> GET -> PUT -> DELETE).

### **4. Serialization and Deserialization**
- Creating and using POJO classes with nested structures.
- Serialization:
  - Converting POJOs to JSON using **Jackson**.
  - Using `@JsonProperty` for custom field mapping.
- Deserialization:
  - Converting JSON to POJOs using **ObjectMapper**.
  - Handling arrays in JSON responses.

### **5. Authentication**
- Basic, preemptive, and digest authentication.
- OAuth 1.0 and OAuth 2.0 workflows:
  - Example APIs: **Flickr API**, **Spotify API**, and **Amadeus OAuth**.
- Handling JWT tokens.

### **6. Handling Complex JSON/XML**
- Parsing and validating complex JSON responses.
- Querying XML using `XMLPath`.
- Converting XML to POJOs for structured testing.

### **7. Request and Response Specifications**
- Defining reusable **RequestSpecification** and **ResponseSpecification** to:
  - Avoid repetitive code.
  - Enhance test maintainability.

### **8. SSL Certificate Handling**
- Ignoring SSL certification errors for secure API testing.

---

## **Technologies and Libraries**
- **Rest Assured** for API testing.
- **Maven** for project management.
- **Lombok** to reduce boilerplate code.
- **Jackson** for JSON serialization/deserialization.



---

## **How to Use This Project**

### **1. Prerequisites**
- Install **Java 8+**.
- Install **Maven**.
- Use an IDE like **Eclipse** or **IntelliJ IDEA** for better development and execution experience.
