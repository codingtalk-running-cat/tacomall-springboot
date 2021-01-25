FROM mysql:5.7.18

COPY my.cnf /etc/mysql/mysql.conf.d/

WORKDIR /etc/mysql/

RUN  cd mysql.conf.d \

    && chmod 644 ./my.cnf