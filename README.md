# page_objects[![Build status](https://ci.appveyor.com/api/projects/status/uemcieukmigo2tjx?svg=true)](https://ci.appveyor.com/project/Kalynovavs/page-objects)


Дополнение требований.

исходя из личного опыта предполагаю что дебетовые карты могут быть с овердрафтом (баланс карт может уходить в минус)
поэтому считаю сценарии тестов с отрицательным балансом позитивными.
пример карт с овердрафтом: https://ameriabank.am/ru/%D1%87%D0%B0%D1%81%D1%82%D0%BD%D1%8B%D0%BC%D0%BB%D0%B8%D1%86%D0%B0%D0%BC/%D0%BA%D1%80%D0%B5%D0%B4%D0%B8%D1%82%D1%8B/%D0%BF%D0%BE%D1%82%D1%80%D0%B5%D0%B1%D0%B8%D1%82%D0%B5%D0%BB%D1%8C%D1%81%D0%BA%D0%B8%D0%B8%D0%BA%D1%80%D0%B5%D0%B4%D0%B8%D1%82/%D0%BE%D0%B2%D0%B5%D1%80%D0%B4%D1%80%D0%B0%D1%84%D1%82

также исходя из информации выше, размер овердрафта расчитывается по разному и может быть больше 1000000.
