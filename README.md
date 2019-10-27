# Spring Data with Redis and REST API
#### Tested on macOS 10.13.3
Get redis running locally in docker with
```
docker run -d -p 6379:6379 --name cricketRedis redis
```

Insert a sample record with key 'id1' into Redis by GET'ing this endpoint:
```
http://localhost:8082/v1/cricket/add/id1/name1
```
Get the full Cricket object with key 'id1' (with hardcoded md5) by GET'ing this endpoint:
```
http://localhost:8082/v1/cricket/get/id1
```
Get a redis cli with
```
docker exec -it cricketRedis sh
Then run:
# redis-cli
```
#### redis-cli inside container
```
127.0.0.1:6379> ping
PONG
127.0.0.1:6379> KEYS *
1) "\xac\xed\x00\x05t\x00\x0bcricket:id1"
```

