FROM    ubuntu:14.04

ENV DEBIAN_FRONTEND noninteractive
#prevent apt from installing recommended packages
RUN echo 'APT::Install-Recommends "false";' > /etc/apt/apt.conf.d/docker-no-recommends && \
    echo 'APT::Install-Suggests "false";' >> /etc/apt/apt.conf.d/docker-no-recommends

# Install java
RUN     apt-get update && apt-get install -y openjdk-7-jdk && \
        rm -rf /var/lib/apt/lists/*

ENV     JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64

# Run gradle wrapper to install gradle and project dependencies
WORKDIR /usr/local/app
ADD      gradle ./
COPY     gradlew build.gradle ./
RUN     ./gradlew clean
