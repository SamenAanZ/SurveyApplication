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

To launch the backend in a 'production mode', you can use the above `docker compose up -d` command.
With this, everything will be run in docker containers in one package, and the (Spring Profiles)[https://www.baeldung.com/spring-profiles] will make sure the environment variables are set properly.

To run everything in a 'development mode', you can individually launch every service using IntelliJ IDEA or just by building and running the project.
Additionally, you will need to install and run a RabbitMQ instance on your computer. (This is what I used on my Windows machine)[https://www.rabbitmq.com/install-windows.html#downloads] to run it locally.

If you want to run the RabbitMQ instance in Docker, you will need to adjust the development profile within `main/resources/application-dev.properties` to change the host to the host of the docker container. You have to do this for every related service.

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
