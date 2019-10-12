# Build environment start
FROM gradle AS build-env

RUN mkdir -p /app

WORKDIR /app

COPY . ./

RUN gradle build

VOLUME /app
# Build environment end


# Runtime environment
FROM openjdk:14-alpine

ENV PMD_VERSION 6.18.0
ENV JAR_NAME codeshelf-tool-pmd-0.0.1-SNAPSHOT.jar

RUN apk add --update --no-cache wget unzip
RUN mkdir -p /opt

RUN cd /opt \
      && wget -nc -O pmd.zip https://github.com/pmd/pmd/releases/download/pmd_releases/${PMD_VERSION}/pmd-bin-${PMD_VERSION}.zip \
      && unzip pmd.zip \
      && rm -f pmd.zip \
      && mv pmd-bin-${PMD_VERSION} pmd

COPY ./misc/pmd /usr/bin/pmd
COPY ./misc/cpd /usr/bin/cpd
RUN chmod +x /usr/bin/pmd /usr/bin/cpd

COPY --from=build-env /app/build/libs/${JAR_NAME} /app/

CMD ["sh", "-c", "java", "-jar", "/app/codeshelf-tool-pmd-0.0.1-SNAPSHOT.jar"]
# Runtime environment end
