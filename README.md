[![Build Status](https://travis-ci.org/levelp/JavaGradle.svg?branch=master)](https://travis-ci.org/levelp/JavaGradle)
[![Coverage Status](https://coveralls.io/repos/github/levelp/JavaGradle/badge.svg?branch=master)](https://coveralls.io/github/levelp/JavaGradle?branch=master)

JavaGradle
==========

**Gradle** - система автоматической сборки, 
построенная на принципах Apache Ant и Apache Maven, 
но предоставляющая DSL на языке *Groovy* (скриптовая Java) 
вместо традиционной 
XML формы представления конфигурации проекта.

2 идеи:
-------
1. Инкрементальная сборка
2. Использовать "человеческий" язык вместо XML: Groovy.

Пример использования Gradle для сборки проекта.

Скачать и установить
--------------------
* Интерпретатор Groovy для Windows: http://groovy.codehaus.org/Download
* Скачать Gradle: https://gradle.org/gradle-download/
 * https://services.gradle.org/distributions/gradle-3.2.1-all.zip - полный пакет
 * https://services.gradle.org/distributions/gradle-3.2.1-bin.zip - только необходимое
* Распаковать архив Gradle в удобную папку (последняя версия 3.2.1)
 * Например в корень диска **C:\**, 
 тогда запускаемый скрипт C:\gradle-3.2.1\bin\gradle.bat
* Задать GRADLE_HOME=C:\gradle-3.2.1
* Добавить в пути (переменную **PATH**): **C:\gradle-3.2.1\bin** 
* Проверяем: **gradle -version**
  
```  
Gradle 2.3

Build time:   2015-02-16 05:09:33 UTC
Build number: none
Revision:     586be72bf6e3df1ee7676d1f2a3afd9157341274

Groovy:       2.3.9
Ant:          Apache Ant(TM) version 1.9.3 compiled on December 23 2013
JVM:          1.8.0_40 (Oracle Corporation 25.40-b02)
OS:           Windows 7 6.1 x86
```

Синтаксис Groovy
----------------
Поиграться с кодом на Groovy можно:
* Groovy Web Console: https://groovyconsole.appspot.com/
* http://www.tutorialspoint.com/execute_groovy_online.php

Жизненный цикл в Gradle
-----------------------
1. Фаза инициализации (Initialization phase) - Gradle решает 
какие цели (задачи) будут участвовать в сборке.
2. Фаза конфигурирования (Configuration phase) - объекты собраны 
во внутреннюю объектную модель (DAG - directed acyclic graph).
3. Фаза исполнения (Execution phase) - задачи сборки выполняются 
в порядке разрешения зависимостей.

**Конфигурирование**
``` groovy 
testTask {
  println 'Config Task';
}
```
Весь код описанный как конфигурационный выполняется каждый
раз при запуске файла сборки Gradle, вне зависимости от того,
какое задание выполняется. 

**Исполнение**
``` groovy
testTask << {
  println 'Execute Task'
}
```

Стандартные цели (tasks) Gradle
-------------------------------
**plugin: 'java' задачи сборки:**
* **compileJava** - компиляция Java исходников из **main/java** 
* **compileTestJava** - компиляция Java исходников из **test/java**
* **processResources** - обработка/копирование ресурсов из **main/resources** 
* **processTestResources** - обработка/копирование ресурсов из **test/resources**
* **assemble** - собирает все **jar**, **war**, **zip** и **tar** архивы
* **build** - собирает и тестирует текущий проект
* **buildDependents** - собирает и тестирует текущий проект, а
  также все проекты которые зависят от него
* **buildNeeded** - собирает и тестирует текущий проект, а также все
  проекты от которых он зависит
* **classes** - собирает main-классы
* **clean** - удаляет каталог сборки (по-умолчанию каталог **build**)
* **jar** - cобирает jar-архив содержащий main-классы
* **testClasses** - cобирает классы для тестов
* **test** - собирает тесты и запускает их

**plugin: 'java' задачи проверки**
* **check** - выполняет все проверки
* **test** - выполняет все unit-тесты

**plugin: 'java' задачи создания документации**
* **javadoc** - создает Javadoc API документацию для исходного кода

Репозитории
-----------
Gradle предоставляет средства для доступа как Ivy, так и Maven репозиториям.
* **mavenCentral()** - предопределенный метод для доступа к центральному репозиторию Maven.
* **jcenter()** - метод для доступа к Bintray's JCenter 
* **flatDir** - использовать локальный каталог как репозиторий.
``` groovy
repositories {
  mavenCentral()
}
```





