# uiandhttp


<h3>Перед запуском</h3>
Если не установлен gradle, то при первом запуске он выкачается, так что прийдется подождать)

<h3>Запуск</h3>
Тесты запускать командой в зависимости от системы:
<ul>
 <li>
  <p>
   <strong>
    <code>./gradlew test -Ptype=%sometype%</code>
   </strong>
   на Unix подобных
   </p>
  </li>
  <li>
   <p>
    <strong>
    <code>gradlew test -Ptype=%sometype%</code>
    </strong>
    на Windows
   </p>
  </li>
</ul>

Где параметр <strong>%sometype%</strong> может принимать значения:
<ul>
 <li>
   <strong>"drv"</strong> запустится только тест с браузером
  </li>
  <li>
   <strong>"http"</strong> запустится только тест через хттп запросы
  </li>
  <li>
    <strong>"drv, http"</strong> запустятся оба теста
  </li>
</ul>
Если не задать параметр и запустить просто <code>./gradlew test</code> то по умолчанию будет использоваться <strong>http</strong>

<h3>Результаты</h3>
в корне репы ./build/reports/tests/test/index.html
