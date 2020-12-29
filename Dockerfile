FROM selenium/standalone-chrome:4.0.0-beta-1-prerelease-20201208

COPY target/lib lib
COPY target/ui.test.ks-1.0.1-20170818.jar test.jar

RUN java -Djava.awt.headless=true -classpath test.jar:lib org.suren.autotest.web.framework.selenium.SeleniumEngine -browser chrome -version 62

USER root
RUN locale-gen zh_CN.UTF-8
ENV LANG zh_CN.UTF-8
ENV LANGUAGE zh_CN:zh
ENV LC_ALL zh_CN.UTF-8

ENTRYPOINT ["java", "-Djava.awt.headless=true", "-Dchrome.args.headless=true", "-jar", "test.jar"]
