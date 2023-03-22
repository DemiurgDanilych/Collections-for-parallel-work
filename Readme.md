## Задача 1. Колл-центр

### Описание
Мы начали заниматься организацией техподдержки у одного из провайдеров города. К нам поступают звонки от разных абонентов, а мы, силами нескольких специалистов, эти звонки "разбираем"

### Работа программы
1. Создание и запуск потоков-специалистов и один поток-АТС (генерирует звонки)
2. Поток-АТС после запуска начинает генерировать несколько (например, 60) "звонков" раз в 1 секунду
3. Потоки-специалисты берут доступные звонки в работу
4. Методом `Thread.sleep()` нужно реализовать эмуляцию работы специалиста над вопросом (3-4 секунды, например)
5. Главный поток (main) ждет конца выполнения всех потоков

### Требования к программе
1. Никаких блокировок. Вся работа должна основываться на concurrent-коллекциях
2. Все константы должны быть оформлены как константы (никаких "Магических чисел")

<details>
  <summary>Подсказка</summary>

Кажется, стоит реализовать хранение звонков, ожидающих ответа, в Queue-коллекцию
</details>
