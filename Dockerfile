# Système de base du docker
FROM debian:11

# Mise à jour du système
RUN apt update && apt -y upgrade

# installation de java
RUN apt-get install -y openjdk-11-jdk-headless

# installation de divers outils réseaux
RUN apt-get install -y git
RUN apt-get install -y net-tools

# installation et configuration de notre application
RUN git clone https://github.com/timberlek/chatDCK.git -b server

ADD . /chatDCK/
WORKDIR /chatDCK

VOLUME /chatDCK/logs
RUN chmod +x start.sh

# Lancement par défaut de notre application
CMD ./start.sh

# on ouvre le port 9000
EXPOSE 9000