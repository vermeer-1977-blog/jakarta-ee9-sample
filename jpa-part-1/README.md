# Jakarta Persistence (JPA)

## Overview

Native Query の戻り値を DTO(Not Entity) で取得する Sample. 

Qureryの受け取りはDTO （@Entity クラスではない）

## How to run

make war

```
./mvnw package
```


run cargo

```
./mvnw cargo:run
```


access web-api

```
http://localhost:8080/jpa-part-1/api/users
```