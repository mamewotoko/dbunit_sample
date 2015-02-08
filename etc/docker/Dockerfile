FROM ubuntu:14.04
MAINTAINER Takashi Masuyama<mamewotoko@gmail.com>
RUN sudo apt-get update && apt-get install -y openssh-server mysql-server mysql-client supervisor
RUN mkdir -p /var/run/sshd /var/run/mysqld /mysql_init
EXPOSE 22 3306
COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf
COPY mysql_config.sh /mysql_init/mysql_config.sh
COPY initialize_db.sh /mysql_init/initialize_db.sh
RUN /usr/bin/mysqld_safe &
COPY my.cnf /etc/mysql/my.cnf
CMD ["/usr/bin/supervisord"]
