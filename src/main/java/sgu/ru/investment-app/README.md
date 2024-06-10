# Запуск приложения

```
mvn clean install
mvn spring-boot:run
```

# Запуск тестов

```
mvn test
```

# Проверка эндпойнтов

1. Получить весь список тарифов:

```
curl -X GET http://localhost:8080/api/tarifs
```

2. Добавить новый тариф:

```
curl -X POST -H "Content-Type: application/json" -d '{"name":"Medium","rate":3.0}' http://localhost:8080/api/tarifs
```

3. Получить тариф по ID:

```
curl -X GET http://localhost:8080/api/tarifs/1
```

4. Установить тарифу по ID новую тарифную ставку и новую дату изменения:

```
curl -X PUT "http://localhost:8080/api/tarifs/1?rate=12.0&lastModified=2023-01-01T00:00:12.316339000"
```

5. Удалить тариф по ID:

```
curl -X DELETE http://localhost:8080/api/tarifs/1
```

6. Получить весь список пользователей:

```
curl -X GET http://localhost:8080/api/users
```

7. Получить пользователя по ID:

```
curl -X GET http://localhost:8080/api/users/1
```

8. Установить пользователю по ID новый тариф ID и обновить дату изменения:

```
curl -X PUT "http://localhost:8080/api/users/1?tarifId=1&lastModified=2023-01-01T01:11:11.111111000"
```

9. Удалить пользователя по ID:

```
curl -X DELETE http://localhost:8080/api/users/1
```

10. Добавить пользователя

```
curl -X POST -H "Content-Type: application/json" -d '{"username":"Stas","tarifId":1}' http://localhost:8080/api/users
```
