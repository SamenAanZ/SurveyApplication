# Backend

## Docker

To start the application, enter the following command in the root directory:
> `docker compose up -d`

The `-d` is an optional flag that starts the container in a 'detached' mode. Without this option, the output runs in your terminal.

The command starts up the "SurveyService", "ResponseService" and a RabbitMQ instance. 

If you make any new changes, you can rebuild the images by adding the `--build` flag at the end.
The resulting command looks like this:
> `docker compose up -d --build`

## Production vs Development

To make the Survey and Response services connect to RabbitMQ, the RabbitMQ host has to be set correctly locally.
The RabbitMQ host configuration within a service, can be found under `application.properties` within the services' resources folder:

```
Service/
    └── src/
        └── main/
            ├── java
            └── resources/
                └── -> application.properties <-
```

The value to change is `spring.rabbitmq.host={VALUE}`

In the Azure environment or when developing locally, this has to be set to `localhost`.
When everything is dockerized, or running in seperate docker containers, this has to be set to `rabbitmq` (this is because the container is called `rabbitmq`).

## Azure

To upload the images to the Azure Container Registry, run the following commands:

Login to the ACR using the Azure CLI:
> `az acr login --name saztestregistry.azurecr.io`

Change image tags to the Container Registry aliasses, and push to Registry.

Survey Service:
> `docker tag backend-surveys-1 saztestregistry.azurecr.io/backendimages/surveys`
>
> `docker push saztestregistry.azurecr.io/backendimages/surveys`

Response Service:
> `docker tag backend_responses saztestregistry.azurecr.io/backendimages/responses`
>
> `docker push saztestregistry.azurecr.io/backendimages/responses`

API Gateway:
> `docker tag backend_api-gateway saztestregistry.azurecr.io/backendimages/api-gateway`
>
> `docker push saztestregistry.azurecr.io/backendimages/api-gateway`

RabbitMQ:
> `docker tag rabbitmq:3-management saztestregistry.azurecr.io/rabbitmq`
>
> `docker push saztestregistry.azurecr.io/rabbitmq`
