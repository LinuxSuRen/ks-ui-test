FROM selenium/standalone-chrome:4.0.0-beta-1-prerelease-20201208

COPY target/lib lib
COPY target/ui.test.ks-1.0.1-20170815.jar test.jar

USER root
RUN locale-gen zh_CN.UTF-8
ENV LANG zh_CN.UTF-8
ENV LANGUAGE zh_CN:zh
ENV LC_ALL zh_CN.UTF-8

CMD ["java", "-Djava.awt.headless=true", "-jar", "test.jar"]
