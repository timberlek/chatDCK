# Système de base du docker
FROM debian:11

# Mise à jour du système
RUN apt update && apt -y upgrade

# Configuration de l'utilisateur sudo
RUN apt-get install -y sudo
RUN useradd -m -N -s /bin/bash -u 1000 -p '$1$.bchr8wv$St4eVcTffR2BHUQ3NgRrV0' user && \
    usermod -aG sudo user

USER root

# installation de java
#RUN sudo apt-get install -y openjdk-11-jdk-headless

# installation de divers outils réseaux
#RUN sudo apt-get install -y git
#RUN sudo apt-get install -y net-tools

# installation firewall
RUN sudo apt install -y ufw

# nettoyage du noyau
RUN sudo apt-get clean

# configuration du firewal
RUN sudo ufw default deny incoming
RUN sudo ufw default allow outgoing

RUN sudo ufw logging off

RUN sudo /lib/ufw/ufw-init start
RUN sudo /lib/ufw/ufw-init force-reload

RUN sudo ufw allow 9000/tcp

RUN sudo ufw start
RUN sudo ufw enable

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