# Jakarta Persistence (JPA)

## Overview

Native Query(orm.xml) & DTO(Not Entity) のベースとなるプロジェクト. 

Qureryの受け取りは @Entity クラス（DTOではない）

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
http://localhost:8080/jpa-part-0/api/users
```