FROM alpine
RUN apk add --no-cache openjdk8
WORKDIR /app/
COPY build/libs/post-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java"]
CMD ["-jar", "/app/post-0.0.1-SNAPSHOT.jar"]

#ENTRYPOINT overwright olmur
#CMD overwright olur