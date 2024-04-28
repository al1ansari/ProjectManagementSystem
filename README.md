# Project Management System API

Welcome to the Project Management System API documentation. This API provides endpoints for managing projects, allowing users to perform CRUD (Create, Read, Update, Delete) operations on projects.


## Table of Contents

- [Setup Instructions](#setup-instructions)
- [API Usage](#api-usage)
  - [Create a Project](#create-a-project)
  - [Get All Projects](#get-all-projects)
  - [Get Project by ID](#get-project-by-id)
  - [Update a Project](#update-a-project)
  - [Delete a Project](#delete-a-project)
- [Error Handling](#error-handling)

## Setup Instructions
### Prerequisites

- Java 17 or higher installed on your system
- Maven for building and managing dependencies

### Steps to Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/your_username/project-management-system.git
2. **Navigate to the project directory**
3. **Build the project**
4. **Run the application**

# API Usage

## Create a Project

**Endpoint:** `POST /projects`

Create a new project with the provided details.

**Request Body:**
```json
{
    "name": "New Project",
    "description": "This is a new project",
    "startDate": "2024-04-27",
    "endDate": "2024-05-27"
}


```
## Get All Projects

**Endpoint:** `GET /projects`

Retrieve a list of all projects.

## Get Project by ID

**Endpoint:** `GET /projects/{id}`

Retrieve details of a specific project by its ID.

## Update a Project

**Endpoint:** `PUT /projects/{id}`

Update an existing project with the provided details.

**Request Body:**
```json
{
    "name": "Updated Project",
    "description": "This is an updated project",
    "startDate": "2024-04-27",
    "endDate": "2024-06-27"
}
```
## Delete a Project

**Endpoint:** `DELETE /projects/{id}`

Delete a project with the specified ID.

## Error Handling

- If a project with the specified ID is not found, a `404 Not Found` response will be returned.
- If there are validation errors in the request body, a `400 Bad Request` response will be returned.

This documentation provides a clear overview of the API endpoints, including their descriptions and error handling mechanisms. Feel free to reach out if you have any questions or need further assistance.
