# Spring WebSocket Chat Application  

This is a simple real-time chat application built using Spring Boot and WebSocket (STOMP protocol), containerized with Docker.

## Description  

The application allows multiple users to join a public chat room and exchange messages in real time. When a user joins or leaves the chat, a notification is broadcast to all connected users.

## Technologies  

- Java 17  
- Spring Boot  
- WebSocket (STOMP + SockJS)  
- HTML, CSS, JavaScript

## How It Works
- Enter a username
- Join the chat
- Send messages in real-time
- All connected users will instantly see messages

## Screenshot
<img width="1868" height="1022" alt="image" src="https://github.com/user-attachments/assets/c1d4ac75-5f07-4ba9-b999-febb67f1a44e" />


  

## How to Run  

### Prerequisites  

- Docker Desktop installed and running

### Steps  

1. Clone the repository:

```bash
git clone https://github.com/labodzz/ChatApp.git
cd ChatApp
```
2. Run the application

 ```bash
docker compose up --build
```
Open the application:
http://localhost:8080



   
