FROM debian:11

# Mise à jour du système
RUN apt update && apt -y upgrade

# installation de java
RUN apt-get install -y openjdk-11-jdk-headless
RUN apt-get install -y git

# installation et configuration de notre application
RUN git clone https://github.com/timberlek/chatDCK.git -b server

ADD . /chatDCK/
WORKDIR /chatDCK

EXPOSE 9000
VOLUME /chatDCK/logs

RUN chmod +x start.sh

CMD ./start.sh