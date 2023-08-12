| #   | HeapSize   | Spent time               |
| --- |:----------:|:------------------------:|
| 1   | 256        | OutOfMemoryError         |
| 2   | 512        | spend msec:10280, sec:10 |
| 3   | 1024       | spend msec:8442, sec:8   |
| 4   | 1500       | spend msec:8094, sec:8   |
| 5   | 1600       | spend msec:8029, sec:8   |
| 6   | 1700       | spend msec:8051, sec:8   | 
| ℹ️7   | 1800        | spend msec:7503, sec:7   |
| 8   | 1900       | spend msec:7679, sec:7   |
| 9   | 2000       | spend msec:7870, sec:7   |


Оптимальным является heap size = 1800МБ

После оптимизации при heap size = 1800МБ время обработки уменьшилось, и стало равным
spend msec:1524, sec:1
