#Anarchy Service Registry

Register your microservices here. How?

```bash
    sh ./start-docker.sh
```

That'd be it.

If you don't want to run in docker, feel free to spin up a TomCat instance (or JBoss, whatever),
and build this as a WAR. Personally, I'd just run

```bash
    test@test:~$ mvn clean && mvn compile && mvn package -Dmaven.test.skip=true
```

and just run `java -jar ./whatever.jar`, but that's just me. If anybody knows how to *not* need to do the
-Dmaven.test.skip thing when packaging the JAR, please let me know!

Cool.