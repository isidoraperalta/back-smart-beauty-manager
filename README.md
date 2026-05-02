# 💇 Back Smart Beauty Manager

## 📋 Prerrequisitos

| Herramienta | Versión mínima | Notas |
|-------------|---------------|-------|
| **☕ Java**    | 21            | Si es que se levanta sin docker |
| **🐳 Docker**  | cualquiera    | [docker.com](https://www.docker.com/products/docker-desktop)  — solo para la opción Docker  |

---

## 🚀 Opción A — Ejecución local (desarrollo)

```bash
# 1. Levantar solo la base de datos
docker compose up -d postgres

# 2. Ejecutar el backend con Maven Wrapper
./mvnw spring-boot:run
```

O ejecutar la clase `BackSmartBeautyManagerApplication` desde el IDE.

✅ La API estará disponible en `http://localhost:8080`.

---

## 🐳 Opción B — Todo con Docker

```bash
# Construye la imagen del backend y levanta postgres + backend
docker compose up -d
```

| Servicio  | URL / Puerto          |
|-----------|-----------------------|
| ⚙️ Backend   | http://localhost:8080 |
| 🗄️ PostgreSQL| localhost:5431        |

```bash
# 📊 Ver logs del backend
docker compose logs -f backend

# ⛔ Detener contenedores sin eliminar volumen (datos de la base de datos)
docker compose down

# 💥 Detener contenedores eliminando volumen (datos de la base de datos)
docker compose down -v
```
---

## 📁 Estructura de carpetas

```
├── docs/                                                     # Documentación y colecciones
│   └── back-smart-beauty-manager.postman_collection.json     # Colección de Postman
├── sql/                                                      # Scripts de inicialización de BD
│   ├── 01-schema.sql                                         # DDL (creación de tablas)
│   └── 02-seed.sql                                           # DML (datos de ejemplo)
├── src/
│   ├── main/
│   │   ├── java/com/back/sbm/
│   │   │   ├── model/
│   │   │   │   ├── entities/                                 # Entidades JPA (Cliente, Servicio, Cita)
│   │   │   │   └── repositories/                             # Interfaces Spring Data JPA
│   │   │   ├── services/                                     # Lógica de negocio
│   │   │   │   └── map/                                      # Mappers para transformación de DTOs
│   │   │   ├── controllers/                                  # Endpoints REST
│   │   │   │   └── dto/                                      # Objetos de transferencia de datos
│   │   │   └── exception/                                    # Manejador global de excepciones
│   │   └── resources/
│   │       └── application.yml                               # Configuración de Spring
│   └── test/                                                 # Pruebas unitarias
├── docker-compose.yml                                        # Orquestación: backend + PostgreSQL
├── Dockerfile                                                # Multi-stage: compilar y ejecutar backend
├── pom.xml                                                   # Dependencias Maven
└── mvnw / mvnw.cmd                                           # Maven Wrapper
```
---

## 🔌 Endpoints API

### 👥 Clientes
- **GET** `/clientes` - Obtener todos los clientes
- **GET** `/clientes/{id}` - Obtener un cliente por ID
- **POST** `/clientes` - Crear un cliente
- **PUT** `/clientes/{id}` - Actualizar un cliente
- **DELETE** `/clientes/{id}` - Eliminar un cliente

### 💇 Servicios
- **GET** `/servicios` - Obtener todos los servicios
- **GET** `/servicios/{id}` - Obtener un servicio por ID
- **POST** `/servicios` - Crear un servicio
- **PUT** `/servicios/{id}` - Actualizar un servicio
- **DELETE** `/servicios/{id}` - Eliminar un servicio

### 📅 Citas
- **GET** `/citas` - Obtener todas las citas
- **GET** `/citas/{id}` - Obtener una cita por ID
- **POST** `/citas` - Crear una cita
- **PUT** `/citas/{id}` - Actualizar una cita
- **DELETE** `/citas/{id}` - Eliminar una cita

---

## 📬 Postman

- 📌 La colección de Postman está en `docs/back-smart-beauty-manager.postman_collection.json`
