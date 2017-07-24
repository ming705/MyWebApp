#!/bin/bash

cwd=$(pwd)

export CLASSPATH="$cwd/tomcat/lib/servlet-api.jar:$cwd/src:$cwd/tomcat/webapps/MyWebApp/WEB-INF/classes"

javac -cp $CLASSPATH $cwd/src/mypkg/*.java -d $cwd/classes

rm -v $cwd/tomcat/webapps/MyWebApp/quoteList.jsp
cp -v $cwd/jsp/quoteList.jsp $cwd/tomcat/webapps/MyWebApp/

rm -v $cwd/tomcat/webapps/MyWebApp/META-INF/context.xml
cp -v $cwd/dd/context.xml $cwd/tomcat/webapps/MyWebApp/META-INF

rm -v $cwd/tomcat/webapps/MyWebApp/WEB-INF/web.xml
cp -v $cwd/dd/web.xml $cwd/tomcat/webapps/MyWebApp/WEB-INF

rm -v -R $cwd/tomcat/webapps/MyWebApp/WEB-INF/classes
cp -v -R $cwd/classes $cwd/tomcat/webapps/MyWebApp/WEB-INF

./tomcat/bin/shutdown.sh
./tomcat/bin/startup.sh