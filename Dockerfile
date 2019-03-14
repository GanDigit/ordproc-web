FROM java:8
WORKDIR /
ADD build/libs/orderprocessingweb-0.0.1-SNAPSHOT.jar ord_order_processing_web.jar
RUN sh -c 'touch /ord_order_processing_web.jar'
ENTRYPOINT ["java","-jar","/ord_order_processing_web.jar"]
