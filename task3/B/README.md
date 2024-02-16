На вход подается название директории (относительный путь от места запуска программы до директории) и имя целевой строки. 

Требуется обойти всю директорию рекурсивно, найти объекты. в имени которых присутствует целевая строка как подстрока и заархивировать их.

Формат архива на ваше усмотрение.

Пример.

Входные данные
directory passport

Структура каталога
directory -> passport -> 1.txt
directory -> passport -> 2
directory -> passport -> 3.md5
directory -> 1passport2.txt
directory -> pass2port.bin
directory -> passp0rt.sh
directory -> 2138123PASSPORT214124124

Вывод
архив directory

Структура архива
passport -> 1.txt
passport -> 2
passport -> 3.md5
1passport2.txt
2138123PASSPORT214124124