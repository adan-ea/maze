FROM openjdk:17.0.2
COPY . /usr/src/mazeDorvilleElArabi
WORKDIR /usr/src/mazeDorvilleElArabi/src
RUN javac Main.java
CMD ["java", "Main"]