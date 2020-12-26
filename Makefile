build:
	mvn clean package -U

run:
	@java -Djava.awt.headless=true -jar target/ui.test.ks-1.0.1-20170815.jar -url ${KS} -password ${KS_PASS}

java:
	java -classpath target/classes:${CLASSPATH}:${shell pwd}/target/lib test.Test

init-engine:
	java -Djava.awt.headless=true -classpath target/ui.test.ks-1.0.1-20170815.jar:target/classes:target/lib \
	org.suren.autotest.web.framework.selenium.SeleniumEngine -browser chrome -version 62

image:
	docker build . -t surenpi/ks-test
	docker push surenpi/ks-test

image-beijing:
	docker build . -t registry.cn-beijing.aliyuncs.com/surenpi/ks-ui-test
	docker push registry.cn-beijing.aliyuncs.com/surenpi/ks-ui-test

image-run:
	@docker run --rm surenpi/ks-test -url ${KS} -username ${KS_USER} -password ${KS_PASS}

jnlp-image:
	docker build . -t surenpi/selenium-agent -f jnlp-agent/Dockerfile
