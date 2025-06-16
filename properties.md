application.properties -  грузятся первыми всегда
в них можно указать тип профиля, как пример

Например при наличии dev профиля
application.properties + application-dev.properties
application-"profile name".properties

spring.profiles.active=dev
param -D