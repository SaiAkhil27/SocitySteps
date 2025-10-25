# SocitySteps – Demo Module  
  
This is the **demo module** of the *SocitySteps* project, a Spring Boot based management system for apartment societies including blocks, apartments, floors, rooms, residents, and related workflows.  

---

## 🧱 Overview  
- Manage multiple **Blocks** (e.g., A1, A2, B1…)  
- Each Block has many **Apartments**  
- Each Apartment has many **Floors**, each Floor has many **Rooms**  
- Each Room can have multiple **Residents**, plus monthly rent, cost, maintenance, etc.  
- Built using Spring Boot, Spring Data JPA, Lombok, ModelMapper, and relational database (MySQL or similar)  

---

## 📁 Module Structure (`/demo`)  

src/
├─ main/java/com/example/demo/
│ ├─ controllers/
│ ├─ dto/
│ ├─ entities/
│ ├─ repositories/
│ ├─ services/
│ └─ responses/
├─ resources/
│ └─ application.properties


---

---

## ⚙️ Technologies Used  

| Technology | Purpose |
|-------------|----------|
| **Spring Boot** | Backend framework |
| **Spring Data JPA** | ORM and database layer |
| **Lombok** | Reduces boilerplate (getters, setters, constructors) |
| **ModelMapper** | Entity ↔ DTO conversion |
| **MySQL / H2** | Database |
| **Postman / Swagger** | API testing |

---

## ✅ Features  

- 🔹 **CRUD operations** for Blocks, Apartments, Floors, Rooms, Residents  
- 🔹 **Hierarchical relationships** maintained via JPA mappings  
- 🔹 **DTOs** used for API responses to maintain clean architecture  
- 🔹 **@ElementCollection** for map-based data (e.g., monthly maintenance per room)  
- 🔹 **Custom APIResponse wrapper** for consistent HTTP responses  
- 🔹 **ModelMapper configuration** for automatic object mapping  
- 🔹 **Lombok** for less boilerplate and cleaner code  

---

## 🚀 How to Run  

1. Clone the repository  
   ```bash
   git clone https://github.com/SaiAkhil27/SocitySteps.git
   cd SocitySteps/demo
