#Anarchy Service Registry

##Starting Anarchy

How?

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

##Registering Service

All you need to do to register a service, is POST to `/register`. The payload must look like this:

```json
    {
        "key": "some-service-key",
        "port": "1234" //The port the service runs on
    }
```

Anarchy will take the client IP address and use that as the service path. Thus, you must register your services
from the same host/container that they run on

##Unregistering Services

To de-register your service (because of shut-down), just call DELETE `/remove` with the same payload as above.

##Find a Service

To find a service, call GET `/find?key=some-service-key`. This will get a randomly selected service from the
Redis set of registered services, under that key. The response will be in the format

`http://172.17.0.4:1234`

From there, your application should know what to do. I guess. I don't know - I'm new to all this.

*NOTE* I'm note sure how to make this better. Send some PR's and we can get to it. 