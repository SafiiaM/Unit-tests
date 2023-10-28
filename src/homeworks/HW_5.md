
__Урок 5. Другие виды тестирования__

*Задание 1. *Представьте, что вы работаете над разработкой простого приложения для записной книжки, которое позволяет пользователям добавлять, редактировать и удалять контакты.
Ваша задача - придумать как можно больше различных тестов (юнит-тесты, интеграционные тесты, сквозные тесты) для этого приложения. Напишите название каждого теста, его тип и краткое описание того, что этот тест проверяет.

*Задание 2. *Ниже список тестовых сценариев. Ваша задача - определить тип каждого теста (юнит-тест, интеграционный тест, сквозной тест) и объяснить, почему вы так решили.
""Проверка того, что функция addContact корректно добавляет новый контакт в список контактов"".
""Проверка того, что при добавлении контакта через пользовательский интерфейс, контакт корректно отображается в списке контактов"".
""Проверка полного цикла работы с контактом: создание контакта, его редактирование и последующее удаление"".


___Юнит тесты:___

addContactTest() {
Проверяет успешность добавления нового контакта в записную книжку Положительный сценарий: В списке понтактов появился новый контакт
Негативный сценарий: Новый контакт в списке контактов не появился
}

editContactTest() {
Проверяет успешность редактирования контакта
Положительный сценарий: Внесённые изменения отображаются корректно
Негативный сценарий: Данные контакта не изменились
}

deleteContactTest() {
Проверяет успешность удаления контакта
Положительный сценарий: Контакт удалён из списка контактов
Негативный сценарий: Контакт не удалён из списка контактов
}

showContactListTest() {
Проверяет отображение списка контактов
Положительный сценарий: Список контактов отображается
Негативный сценарий: Список контактов не отображается
}

showContactTest() {
Проверяет отображение информации о контакте
Положительный сценарий: Информация о контакте отображается
Негативный сценарий: Информация о контакте не отображается
}

entryContactTest() {
Проверяет ввод данных пользователем
(отдельный тест для каждого поля ввода)
Положительный сценарий: Введённые пользователем данные успешно считываются с UI
Негативный сценарий: Ошибка считывания данных с UI
}

saveToFileTest() {
Проверяет сохранение списка контактов в файл
Положительный сценарий: Список контактов успешно сохраняется в файл
Негативный сценарий: Ошибка записи файла
}

loadFileTest() {
Проверяет загрузку списка контактов из файла
Положительный сценарий: Список контактов успешно загружается из файла
Негативный сценарий: Ошибка чтения файла
}

findContactTest() {
Проверка поиска в списке контактов
(тесты по всем возможным атрибутам)
Положительный сценарий: Искомый контакт найден
Негативный сценарий: Искомый контакт не найден
}

findNonExistentContactTest() {
Проверка поиска несуществующего контакта
(тесты по всем возможным атрибутам)
Положительный сценарий: Сообщение о том, что данный контакт отсутствует
Негативный сценарий: Что-угодно, кроме сообщения об отсутствии искомого контакта в справочнике
}

idCountTest() {
Проверяет инкремент счётчика id при добавлении пользователя
Положительный сценарий: При добавлении пользователя счётчик id увеличивается
Негативный сценарий: Счётчик не увеличивается
}

___Интеграционные тесты:___
newContactTest() {
Проверяет ввод данных пользователем в UI
Положительный сценарий: Данные о новом контакте успешно собраны
Негативный сценарий: Ошибка сбора данных из UI
}

showInfoContactAfterSearchTest(Contact contact) {
Проверяет вывод информации о запрошенном контакте
Положительный сценарий: Данные о запрошенном контакте успешно отображены в UI
Негативный сценарий: Ошибка отображения данных в UI
Негативный сценарий: Неверное отображения данных в UI
}

deleteContactAfterUserChoiceTest(Contact contact) {
Проверяет удаление выбранного кользователем контакта
Положительный сценарий: Данные о контакте успешно удалены из списка контактов, файл успешно перезаписан
Негативный сценарий: Ошибка записи файла
Негативный сценарий: Контакт не удалился из списка
Негативный сценарий: Удалён не тот контакт
}

searchContactInListTest(String name) {
Проверяет поиск контакта по имени
Положительный сценарий: Данные о контакте найдены (либо информация об отсутствии искомого контакта) и переданы в UI
Негативный сценарий: Существующий контакт не найден в списке контактов
Негативный сценарий: Ошибка отображения в UI
Негативный сценарий: Отображается не тот контакт, который быз запрошен
Негативный сценарий: Информация о том, что искомого контакта нет в справочнике не отображается
}

___Сквозные тесты:___

showContactsInBaseTest() {
Загрузка данных из файла и отображение их на экране пользователя
Положительный сценарий: Данные загружаются и отображаются корректно
Негативный сценарий: Ошибка считывания файла
Негативный сценарий: Ошибка отображения в UI
Негативный сценарий: Некорректное отображения в UI
Негативный сценарий: Неполное отображения в UI
}

createNewContactTest() {
Создание нового контакта, добавление в список контактов, сохранение в файл
Положительный сценарий: Данные из UI, добавляются в список контактов, сохраняются в файл
Негативный сценарий: Ошибка записи файла
Негативный сценарий: Ошибка считывания данных из UI
Негативный сценарий: Ошибка добавления в список контактов
Негативный сценарий: Ошибка индексации нового контакта
}