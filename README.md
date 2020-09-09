# Nice Home Assignment

## Message Handling Server.

Author: Tamir Mayblat, tamirmayb@gmail.com

## Content

## Prerequisites :

* A working rabbitmq server with factory settings (localhost:5672, username: guest, password: guest)

## How to use :

* Start rabbitmq server. 
* Start ConsumerApp (8081) and ProducerApp (8080) microservices.
* Send post request to the shuffle ms - http://localhost:8080/nice/message. 

* Example :  curl -d "input=5" -X POST http://localhost:8080/nice/message
or use any rest client to send the requests.

### Thanks