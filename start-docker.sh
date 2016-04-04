mvn clean && mvn compile && mvn package -Dmaven.test.skip=true
docker run --name anarchy_redis -d redis:3.0
docker build -t tifu/service-repository:1.0 .
docker run -P -p 9000:9000 --link anarchy_redis:redis -i -d --name anarchy_web tifu/service-repository:1.0