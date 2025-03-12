# Bank Account Management System (Spring Boot)

This is a **Spring Boot REST API** for managing bank accounts, allowing users to create accounts, deposit, withdraw, fetch details, and delete accounts.

## Features  
- Create a bank account (`POST /`)
- Get account details by ID (`GET /{id}`)
- Deposit money into an account (`PUT /{id}/deposit`)
- Withdraw money from an account (`PUT /{id}/withdraw`)
- Get all accounts (`GET /accounts`)
- Delete an account (`DELETE /{id}/delete`)

## Technologies Used  
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **H2 / MySQL Database**
- **Lombok**
- **Spring Web**
- **Maven**

## API Endpoints  

| HTTP Method | Endpoint            | Description                        |
|------------|---------------------|------------------------------------|
| `POST`    | `/`                 | Create a new bank account         |
| `GET`     | `/{id}`             | Get account details by ID         |
| `PUT`     | `/{id}/deposit`     | Deposit money into an account     |
| `PUT`     | `/{id}/withdraw`    | Withdraw money from an account    |
| `GET`     | `/accounts`         | Get all accounts                  |
| `DELETE`  | `/{id}/delete`      | Delete a bank account             |

## How to Run Locally  

1. **Clone the Repository**  
   ```sh
   git clone https://github.com/your-username/bank-account-management.git
   cd bank-account-management
