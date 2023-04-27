FROM alpine:3.5
MAINTAINER BPM
USER root
RUN echo -e "https://mirrors.aliyun.com/alpine/v3.5/main" > /etc/apk/repositories
RUN echo -e "https://mirrors.aliyun.com/alpine/v3.5/community" >> /etc/apk/repositories
ENV ALPINE_PACKAGES  "bash openjdk8-jre curl"
RUN apk --update add apk-tools && apk add ${ALPINE_PACKAGES}
RUN ln -s /usr/lib/jvm/java-1.8-openjdk /usr/jdk1.8.0
ENV JAVA_HOME /usr/jdk1.8.0
ADD wrapper/wrapper-camunda/wrapper-camunda-0.0.2.RELEASE.jar
ENTRYPOINT ["java","-jar","-Dfile.encoding=UTF-8","/wrapper-camunda-0.0.2.RELEASE.jar"]