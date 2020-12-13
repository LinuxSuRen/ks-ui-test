build:
	mvn clean package -U

run:
	@java -Djava.awt.headless=true -jar target/ui.test.ks-1.0.1-20170815.jar -url ${KS} -password ${KS_PASS}

image:
	docker build . -t surenpi/ks-test

image-run:
	@docker run --rm surenpi/ks-test -url ${KS} -username ${KS_USER} -password ${KS_PASS}

jnlp-image:
	docker build . -t surenpi/selenium-agent -f jnlp-agent/Dockerfile
