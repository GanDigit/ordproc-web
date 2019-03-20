#!/usr/bin/env bash

cd ..


#docker run -p <HOST_PORT>:<CONTAINER:PORT> IMAGE_NAME
# here we map 8087 (to be used from browser) to the port 8082 (mentioned in the application.properties  --> server.port=8082).
# EXPOSE 80 mentioned in teh dockerfile is just indication. To indicate the springboot property should be 80 (server.port=80).
docker run -p 8087:8082 gandigit/ordproc-catalog-service