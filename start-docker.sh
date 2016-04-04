mvn package -Dmaven.skip.tests=true
docker run --name redis -d redis:3.0
docker run -P -p 9000:9000 --link redis:redis -i -d --name=web tifu/service-repository:1.0