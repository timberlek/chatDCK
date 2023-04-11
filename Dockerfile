FROM debian.9

# installation de java
RUN apt-get install openjdk-11-jdk-headless

# installation et configuration de notre application
RUN git clone https://github.com/timberlek/chatDCK.git

ADD . /chatDCK/
WORKDIR /chatDCK

EXPOSE 9000
VOLUME /chatDCK/logs

# Mise à jour du système
RUN apt update && apt upgrade

CMD ./server.sh