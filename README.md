Сегодня я предлагаю тебе сделать маленькую игру на реакцию.

Правила игры:
На экране появляется отсчет время и нужно успеть нажать на кнопку как можно ближе к нулю.
Перед началом, игрок выбирает сложность игры:
1) Время через которое обновляется таймер: 0.2\0.5\1.0 секунд.
2) Начальное время на таймере 1-3\2-4\3-6 сек
3) Количество партий <Пользователь вводит с клавиатуры, максимально 20>

Игра длится выбранное количество раундов. Начальное время выбирается рандомно в пределах предыдущего меню. После начала отсчета и нажатия выбранной клавиши рассчитать время до 0. Суммировать время нажатия после каждого раунда. Перед началом отчета игрок должен нажать клавишу Enter после чего начнется отсчет времени.

По итогам игры(когда заканчиваются все раунды) предложить пользователю записать его результат в турнирную таблицу (При этом спросить ввести имя):
<Вид турнирной таблицы>
<Имя> <Дата проведения игры в формате ДД:ММ:ГГГГ ЧЧЖ:ММ>  <Игровое время>

Вверху таблицы будут игроки у которых по модулю время меньше.

!!!!! Тех задание:
1) Расчет времени для каждого игрока должен происходить в отдельном потоке
2) В главном меню игры должен быть таймер, сколько ты находишь в игре
3) Главный поток НЕ должен блокироваться! Так, что во время игры можно нажать Esc и вернуться в главное меню!
4) Перед игрой, нужно дать возможность игроку выбрать с помощью какой кнопки на клавиатуре он будет играть
5) Таблица Рекордов должна быть записаны в файле в Формате JSON
6) Не забывай про классы и красивый структурированный код)

Задание со звездочкой (*):
1) Сделать игру на несколько игроков: Все то же самое только вместо одного игрока который нажимает на одну кнопку может быть до 4-х, причем у каждого свой таймер (в отдельно потоке) и у каждого своя кнопка. Выигрывает тот, у кого в сумме за все раунды меньше время. Кстати, для этого режима отдельная турнирная таблица.
2) Сейчас рекорды храниться  в открытом виде и есть возможность сжульничать! Исправь это зашифровав файл!

Пример того, как я себе представляю вид игры: 

***
Обновление таймера: 0.5 секунд
Начало 2-4
Количество раундов 5
***
Раунд 1 - Ты готов? <Ожидание клавиши>
Поехали!
Игрок 1 - 3.7 сек 
Игрок 1 - 3.2 сек 
Игрок 1 - 2.7 сек 
Игрок 1 - 2.2 сек 
Игрок 1 - 1.7 сек 
Игрок 1 - 1.2 сек 
Игрок 1 - 0.7 сек 
Ты нажал на 0,37 секунде

Раунд 2 - Ты готов? <Ожидание клавиши>
Поехали! 
Игрок 1 - 2.4 сек 
Игрок 1 - 1.9 сек 
Игрок 1 - 1.4 сек 
Игрок 1 - 0.9 сек 
Игрок 1 - 0.4 сек 
Ты нажал на -0,24 секунде

<и так делее еще 3 раунда >
<После последнего>
Твой результат за 5 раундов 1.74 секунды! 
Записать в таблицу рекордов?

*****


