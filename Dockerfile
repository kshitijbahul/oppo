ARG CODE_VERSION=12.04
FROM openjdk:11-jdk-slim
RUN apt-get update && apt-get install nginx -y \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*
COPY target/*.jar /oppo.jar
RUN mkdir /LoanApplication
COPY LoanApplication/dist /LoanApplication
COPY src/main/resources/nginx.conf  /LoanApplication

CMD ['java', '-jar', '/oppo.jar','&']
CMD ['java', '-jar', '/oppo.jar','&']