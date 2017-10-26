This project uses a local mongo installation or a docker stack for test cases.



To prepare your system for docker swarm simply call 
`docker swarm init --advertise-addr 127.0.0.1`

```
# example call how to start a mongo instance with pure docker
docker run --name test-mongo -v /home/eiko/tmp/mongodb/data:/data/db -p 27017:27017 -d mongo

# example call how to start a mongo shell
docker exec -it test-mongo /bin/bash
```
