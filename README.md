# SFD Web Service
>Web Service for Doscom's Software Freedom Day Agenda.

# Stack & Technology 
This Web Service develop with this awesome technology
- Spring Boot
- MongoDB

# Run Project
Use the command below to execute this project 
```
$ ./gradlew bootRun
```
And this application will run in `http://localhost:8080`

# Feature
Note : Create or Update API depend on user request. If user request has id, it belong to create. If user request has not id, it belong to update.
### 1. Register to Workshop or Update registered User
This Endpoint will create or update festival participant.
- Checking whether participant register with same username or not
- Register participant to SFD Workshop 
- Sending email verification 
- Make account in SFD Festival with bonus 100 point SFD Festival

### 2. Register Festivalor Update registered User
This Endpoint will create or update festival participant.
- Checking whether participant register with same username or not
- Register participant to SFD Festival

### 3. Add or Update Stand 
This Endpoint will create or update stand. 
- Checking whether stand has registered or not
- Add Stand to SFD Festival
 
### 4. Submit Score
This Endpoint will submit user score given from every stand.  
- Checking whether user ever participate in this stand or not 
- Submit Score in SFD Festival 

### 5. Find All Workshop User
This Endpoint will send All registered user in Workshop

### 6. Find All Festival User
This Endpoint will send All registered user in Festival

### 7. Find All Stand
This Endpoint will send All registered user in Workshop