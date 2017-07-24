# Start up Tomcat
./tomcat/bin/startup.sh
https://my-java-app-ming705.c9users.io

#Installing MySQL
$ mysql-ctl install
MySQL 5.5 database added.  Please make note of these credentials:
Root User: ming705
Database Name: c9

#Start / stop mysql
$ mysql-ctl start | stop

#To use the mysql monitor:
$ mysql-ctl cli

show databases;
use c9;
source norris_data.sql
select * from Quotes;

create user 'tomcat'@'%' identified by 'tomcat';
grant all privileges on *.* to 'tomcat'@'%' with grant option;

# Install phpMyadmin (first shutdown tomcat: phpMyadmin uses the same port as tomcat)
$ phpmyadmin-ctl install
https://my-java-app-ming705.c9users.io/phpmyadmin

# Git commands:
git init
touch .gitignore
vi .gitignore
git add .
git commit -m "initial commit"
#First create a reposity on github.com before performing the next step
git remote add origin https://github.com/ming705/MyWebApp.git
git push -u origin master
git status

