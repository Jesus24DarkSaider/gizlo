FROM openjdk:11
RUN mkdir /usr/src/usuarioms
COPY /target/usuarioms-1.0.0.jar /usr/src/usuarioms
WORKDIR /usr/src/usuarioms
EXPOSE 9021
CMD ["java", "-Djava.security.egd=file:/dev/.urandom", "-Duser.timezone=EC", "-jar", "usuarioms-1.0.0.jar"]