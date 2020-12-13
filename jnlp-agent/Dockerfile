FROM jenkins/inbound-agent:alpine as jnlp

FROM selenium/standalone-chrome:4.0.0-beta-1-prerelease-20201208

COPY --from=jnlp /usr/local/bin/jenkins-agent /usr/local/bin/jenkins-agent
COPY --from=jnlp /usr/share/jenkins/agent.jar /usr/share/jenkins/agent.jar

COPY target/lib lib
COPY target/ui.test.ks-1.0.1-20170815.jar test.jar

USER root
RUN locale-gen zh_CN.UTF-8
ENV LANG zh_CN.UTF-8
ENV LANGUAGE zh_CN:zh
ENV LC_ALL zh_CN.UTF-8

ENTRYPOINT ["/usr/local/bin/jenkins-agent"]
