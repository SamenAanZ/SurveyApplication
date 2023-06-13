# Backend

To start the application, enter the following command in the root directory:
> `docker compose up -d`

The `-d` is an optional flag that starts the container in a 'detached' mode. Without this option, the output runs in your terminal.

The command starts up the "SurveyService", "ResponseService" and a RabbitMQ instance. 

If you make any new changes, you can rebuild the images by adding the `--build` flag at the end.
The resulting command looks like this:
> `docker compose up -d --build`
