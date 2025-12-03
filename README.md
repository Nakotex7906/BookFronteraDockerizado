# 📚 Proyecto BookFrontera (Revisión Cruzada)

Este proyecto está dockerizado. Sigue estos pasos para levantarlo en cualquier PC.

## 📋 Prerrequisitos

- Tener **Docker** y **Docker Compose** instalados (Docker Desktop en Windows/Mac).

## 🚀 Cómo ejecutarlo

1. **Configurar Credenciales:**

   - Duplica el archivo `.env.example`.
   - Renómbralo a `.env`.
   - Pega las credenciales de Google (Client ID y Secret) que se enviaron por interno.

2. **Levantar la App:**
   Abre una terminal en esta carpeta y ejecuta:
   ```bash
   docker-compose up --build
   ```
## 🏗 Arquitectura del Sistema

```mermaid
graph TD
    %% Estilos
    classDef person fill:#08427b,stroke:#052e56,color:white;
    classDef container fill:#1168bd,stroke:#0b4884,color:white;
    classDef db fill:#2f95d7,stroke:#206897,color:white;
    classDef external fill:#999999,stroke:#666666,color:white;

    %% Actores
    Student[Usuario / Estudiante]:::person
    Admin[Administrador]:::person

    %% Caja del Sistema
    subgraph "Sistema BookFrontera (Dockerized)"
        Frontend[("Frontend<br/>(React + Vite + Nginx)<br/>Puerto: 5173")]:::container
        Backend[("Backend API<br/>(Spring Boot 3 + Java 21)<br/>Puerto: 8080")]:::container
        Database[("Base de Datos<br/>(PostgreSQL 15)<br/>Puerto: 5432")]:::db
    end

    %% Sistemas Externos
    Google[("Google System<br/>(OAuth2 & Calendar API)")]:::external
    Cloudinary[("Cloudinary<br/>(Almacenamiento Imágenes)")]:::external

    %% Relaciones
    Student -->|Usa (HTTPS)| Frontend
    Admin -->|Usa (HTTPS)| Frontend

    Frontend -->|Solicita datos (JSON/HTTPS)| Backend
    
    Backend -->|Lee/Escribe (JDBC)| Database
    
    Backend -->|Autenticación & Sincronización Eventos| Google
    Backend -->|Sube/Borra imágenes de salas| Cloudinary

    %% Notas de flujo
    linkStyle 2 stroke:#0a3fa6,stroke-width:2px;
    linkStyle 4 stroke:#0a3fa6,stroke-width:2px;   
