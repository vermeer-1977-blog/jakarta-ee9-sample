# Jakarta Persistence (JPA)

## Overview

Native Query の戻り値を DTO(Not Entity) で取得する Sample. 

Qureryの受け取りはDTO （@Entity クラスではない）  
* orm.xmlを使ってSQLを外部ファイルにする
* カラムマッピングはClassで指定して型安全

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
http://localhost:8080/jpa-part-3/api/users
```