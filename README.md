# Spring Data with Redis and REST API
#### Tested on macOS 10.13.3
Get redis running locally in docker with
```
docker run -d -p 6379:6379 --name cricketRedis redis
```

Insert a sample record into Redis by GET'ing this endpoint:
```
http://localhost:8082/v1/cricket/add/id1/name1
```
Get a redis cli with
```
docker exec -it cricketRedis sh
```
#### redis-cli inside container
```
127.0.0.1:6379> ping
PONG
127.0.0.1:6379> set name test
OK
127.0.0.1:6379> get name
"test"
127.0.0.1:6379> incr counter
(integer) 1
127.0.0.1:6379> incr counter
(integer) 2
```

