]633;E;echo "# Лаб 4: Нэгжийн тест (JUnit 5)";b3713882-ee70-42be-b3f4-7caaf03f6da1]633;C# Лаб 4: Нэгжийн тест (JUnit 5)

**Оюутан:** Д.Нурсолтан, В232270039

## Хувилбарууд
```
openjdk version "21.0.12.1" 2026-08-18
OpenJDK Runtime Environment (build 21.0.12.1+1-1-deb13u1-Debian)
OpenJDK 64-Bit Server VM (build 21.0.12.1+1-1-deb13u1-Debian, mixed mode, sharing)
[1mApache Maven 3.9.9[m
Maven home: /usr/share/maven
Java version: 21.0.12.1, vendor: Debian, runtime: /usr/lib/jvm/java-21-openjdk-amd64
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.12.111+deb13-amd64", arch: "amd64", family: "unix"
```

## Үр дүн
- Тестийн методын тоо: 13 (11 энгийн @Test, 2 @ParameterizedTest)
- results/mvn-test.txt-ийн Tests run: 26
- Мутацид унасан тест: ninetyIsExactlyA (expected: <A> but was: <B>), letterGradeBoundaries[6] буюу 90,A мөр (expected: <A> but was: <B>). Tests run: 26, Failures: 2, BUILD FAILURE (results/mvn-test-mutant.txt)

## Дүгнэлт
Энэ лабораторид би Maven төсөл үүсгэж, JUnit 5-аар GradeCalculator классын letterGrade ба totalScore методуудыг тестэлсэн. Тест бүрийг Arrange–Act–Assert бүтэцтэй бичиж, @DisplayName-ээр монгол нэр өгсөн. Ердийн утгуудаас гадна 90, 89.99, 60, 59.99, 0, 100 гэсэн хязгаарын утгуудыг шалгаж, буруу оролтод (-1, 101, сөрөг ирц, 40-өөс хэтэрсэн лаб) assertThrows ашигласан. Хоёр @ParameterizedTest нь letterGrade-ийн 12 мөр, totalScore-ийн 3 мөрийг тусдаа тест болгон ажиллуулсан тул методын тоо 13 байхад Surefire 26 тест тоолсон. Мутацийн туршилтаар score >= 90-ийг score > 90 болгоход яг 90 оноо A-ийн оронд B болж, ninetyIsExactlyA болон 90,A мөртэй parameterized тест унасан. Хамгийн сонирхолтой нь энэ нэг жижиг хязгаарын алдааг хоёр тест давхар илрүүлсэн явдал бөгөөд хязгаарын утгыг тусад нь шалгаагүй бол энэ алдаа мэдэгдэхгүй өнгөрөх байсан. Нөхцөлийг буцааж засахад бүх 26 тест дахин ногоон болсон. Үүнээс pass болсон тест нь зөв тест гэсэн үг биш, тестийн чанарыг мутациар шалгаж болдгийг ойлгосон.
