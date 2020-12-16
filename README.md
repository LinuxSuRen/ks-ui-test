[![](https://goreportcard.com/badge/linuxsuren/ks-ui-test)](https://goreportcard.com/report/linuxsuren/github-go)
[![](http://img.shields.io/badge/godoc-reference-5272B4.svg?style=flat-square)](https://godoc.org/github.com/linuxsuren/ks-ui-test)
[![Contributors](https://img.shields.io/github/contributors/linuxsuren/ks-ui-test.svg)](https://github.com/linuxsuren/github-go/graphs/contributors)
[![GitHub release](https://img.shields.io/github/release/linuxsuren/ks-ui-test.svg?label=release)](https://github.com/linuxsuren/github-go/releases/latest)
![GitHub All Releases](https://img.shields.io/github/downloads/linuxsuren/ks-ui-test/total)

This is not the official UI test for [Kubesphere](https://github.com/kubesphere/kubesphere/). I created this only for someone 
who might want to have less simple and meaningless work with developing Kubesphere.

# Run it

You can run it a with normal browser via: `make build run`

Or, you can also run it in a container with a headless browser: `make build image-run`

# How it works

This project base on [phoenix.webui.framework](https://github.com/LinuxSuRen/phoenix.webui.framework) 
which is a UI testing framework of [Selenium](https://github.com/SeleniumHQ/selenium).

# Run in container

`docker run --rm registry.cn-beijing.aliyuncs.com/surenpi/ks-ui-test -url ${KS} -user ${KS_USER} -password ${KS_PASS}`

# Run in Jenkins

First, Start Jenkins via: `jcli center start`. Then config [jcli](https://github.com/jenkins-zh/jenkins-cli) if you've done it before.

Second, build the JNLP agent image via: `make jnlp-image`. 
Then run it: `jcli computer launch simple -m docker --remove --agent-type custom --custom-image surenpi/selenium-agent`

At last, create a pipeline with the following content:

```
pipeline {
    agent {
		    label 'simple'
    }
    environment {
        KS = "http://127.0.0.1:30880/login"
    }
    stages {
        stage('Example') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'kubesphere', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh "java -Djava.awt.headless=true -jar /test.jar -url ${KS} -password ${PASS} -username ${USER}"
                }
            }
        }
    }
}
```

In order to make sure this pipeline works well, please remember provide a correct URL of Kubesphere and a credential.

You can trigger this pipeline via a command line: `jcli job build -b simple`. Or just trigger it manually.
