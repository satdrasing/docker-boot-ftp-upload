FROM openjdk:11.0.6-jdk as build

WORKDIR /ftp-uploader

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .

RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw package -DskipTests

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:11.0-jre

EXPOSE 8080

LABEL maintainer='satendra.kohli@gmail.com'

ARG DEPENDENCY=/ftp-uploader/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.satendra.ftpfileuploader.FtpFileUploaderApplication"]