FROM java:8
WORKDIR /
ADD build/libs/orderprocessingweb-0.0.1-SNAPSHOT.jar ordproc_web.jar
RUN sh -c 'touch /ordproc_web.jar'
EXPOSE 80
ENTRYPOINT ["java","-jar","/ordproc_web.jar"]
