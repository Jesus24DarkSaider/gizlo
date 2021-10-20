FROM openjdk:11
RUN mkdir /usr/src/userexternoes
COPY /target/userexternoes-1.0.0.jar /usr/src/userexternoes
WORKDIR /usr/src/userexternoes
EXPOSE 8103
CMD ["java", "-Djava.security.egd=file:/dev/.urandom", "-Duser.timezone=EC", "-jar", "userexternoes-1.0.0.jar"]