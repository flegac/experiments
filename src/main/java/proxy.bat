@echo off
SET JAVA_HOME=aaa
for /d %%i in ("\Program Files\Java\j*") do (
	if %JAVA_HOME% GTR %%i SET JAVA_HOME=%%i
	echo %%i
)
echo JAVA_HOME : %JAVA_HOME%
::--------------------------------------------------------------------

SET CIV_PATH=%~dp0

SET LIBS=%CIV_PATH%libs

SET COMMON=%LIBS%\log4j\log4j.jar;%LIBS%\google\gson-2.2.4.jar;%LIBS%\junit\hamcrest-core-1.3.jar;%LIBS%\junit\junit-4.11.jar;%LIBS%\assertj\assertj-core-3.3.0.jar
SET LWJGL=%LIBS%\lwjgl\jar\lwjgl.jar;%LIBS%\lwjgl\jar\lwjgl_util.jar;%LIBS%\lwjgl\jar\jinput.jar;%LIBS%\twl\TWL.jar;%LIBS%\twl\xpp3-1.1.4c.jar;%LIBS%\slick\slick-util.jar;%LIBS%\ogg\jorbis-0.0.17.jar
SET SPARK=%LIBS%\spark\spark.jar;%LIBS%\slf4j-api-1.7.13.jar;%LIBS%\spark\jetty\jetty-http-9.3.6.v20151106.jar;%LIBS%\spark\jetty\jetty-io-9.3.6.v20151106.jar;%LIBS%\spark\jetty\jetty-server-9.3.6.v20151106.jar;%LIBS%\spark\jetty\jetty-util-9.3.6.v20151106.jar;%LIBS%\spark\jetty\servlet-api-3.1.jar;%LIBS%\spark\jetty\websocket-api-9.3.6.v20151106.jar;%LIBS%\spark\jetty\websocket-server-9.3.6.v20151106.jar;%LIBS%\spark\jetty\javax-websocket-client-impl-9.3.6.v20151106.jar;%LIBS%\spark\jetty\javax.websocket-api-1.0.jar;%LIBS%\spark\jetty\javax-websocket-server-impl-9.3.6.v20151106.jar;%LIBS%\spark\jetty\websocket-client-9.3.6.v20151106.jar;%LIBS%\spark\jetty\websocket-common-9.3.6.v20151106.jar;%LIBS%\slf4j\slf4j-api-1.7.21.jar
SET GAME_LIBS=%LIBS%\flo\fullgame.jar

SET classpath=%COMMON%;%LWJGL%;%SPARK%;%GAME_LIBS%
SET LWJGL_NATIVE_LIBRARY_PATH=%LIBS%\lwjgl\native\windows

::run configuration
SET JVM_PARAM=-Xmx1G

SET TO_LAUNCH=fr.flegac.civ.proxy.GameProxyRunner
SET ARG0=%CIV_PATH%conf

"%JAVA_HOME%\bin\java.exe" -Dfile.encoding=UTF-8 %JVM_PARAM% -classpath %classpath% -Djava.library.path=%LWJGL_NATIVE_LIBRARY_PATH% %TO_LAUNCH% %ARG0%

pause