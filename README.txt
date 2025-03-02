Related issue: https://github.com/spring-projects/spring-framework/issues/34522

When using v3.4.3 (pom.xml), the application does not work:
$ docker build -t spring-boot-issue-44498-pom:latest -f pom.Dockerfile .
$ docker run --rm spring-boot-issue-44498-pom:latest
result: It hangs, no expected output ("INIT SOMETHING").

When using v3.4.2, or v3.4.3-modified (pom2.xml), the application works:
$ docker build -t spring-boot-issue-44498-pom2:latest -f pom2.Dockerfile .
$ docker run --rm spring-boot-issue-44498-pom2:latest
result: It terminates correctly, produces the expected output ("INIT SOMETHING").
