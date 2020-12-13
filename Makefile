build:
	mvn clean package -U

run:
	java -Djava.awt.headless=true -jar target/ui.test.ks-1.0.1-20170815.jar -url ${KS}

image:
	docker build . -t surenpi/ks-test
